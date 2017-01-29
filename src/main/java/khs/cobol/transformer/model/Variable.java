package khs.cobol.transformer.model;

import java.util.ArrayList;
import java.util.List;

import khs.transformer.util.Syntax;

public class Variable {

	private String name;
	private String typeName;

	private String value;
	private boolean isLocal;
	private boolean isWorking;
	private boolean isArray;
	private String  fileLevel;
	private List<Variable> variables;
	private String varLevel;
	private String picture;



	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getVarLevel() {
		return varLevel;
	}
	public void setVarLevel(String varLevel) {
		this.varLevel = varLevel;
	}

	public List<Variable> getVariables() {
		return variables;
	}
	public void setVariables(List<Variable> variables) {
		this.variables = variables;
	}

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	public boolean isLocal() {
		return isLocal;
	}
	public void setLocal(boolean isLocal) {
		this.isLocal = isLocal;
	}

	public boolean isWorking() {
		return isWorking;
	}
	public void setWorking(boolean isWorking) {
		this.isWorking = isWorking;
	}

	public boolean isArray() {
		return isArray;
	}
	public void setArray(boolean isArray) {
		this.isArray = isArray;
	}

	public String getFileLevel() {
		return fileLevel;
	}
	public void setFileLevel(String fileLevel) {
		this.fileLevel = fileLevel;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String value() {
		return "ZERO".equalsIgnoreCase(this.getValue()) ? "0.0" : this.getValue();
	}


	public String expression() {

		String dataType = "String";
		String expression = null;

		if (this.picture != null && this.picture.indexOf('Z') >= 0) {
			dataType = "Double";
		} else

		if (this.picture != null && this.picture.indexOf('X') >= 0) {
			dataType = "String";
		}

		if ("SPACES".equals(this.getValue())) {
			dataType = "String";
		}

		if (getVarLevel().equalsIgnoreCase("sqlca")) {
		    // Transfigure SQLCA into int sqlcode
		    setName("sqlcode");
		    dataType = "int";
        }

		if (this.variables.isEmpty()) {
		   	// no levels, just define variable
			if (this.name.equalsIgnoreCase("FILLER")) {
				expression ="";
			} else {
                String level = getVarLevel().equalsIgnoreCase("sqlca") ? "" : " Level";
				expression = String.format("//%s %s\n\tprivate %s %s;\n", level,  getVarLevel().toUpperCase(), dataType, Syntax.var(getName()));
			}
		} else {
		    // get workstorage levels
		   List<String> vars = new ArrayList<String>();
		   expression = expressionLevels(vars,this.variables);

//            expression += String.format("// Level %s\n\tpublic String[] %s = new String[]{ ",  getVarLevel(), Syntax.var(getName()) );
            expression += String.format("// Level %s\n\tprivate InItem[] %s = new InItem[]{ ",  getVarLevel(), Syntax.var(getName()) );

		   String sep = "";
			for (String var : vars) {
//                expression += String.format("%s\"%s\"", sep, var);
                expression += String.format("%s() -> %s", sep, var);
				sep = ", ";
			}

		   expression+=" };";

		}

		return expression;
	}


    private String expressionLevels(List<String> vars,List<Variable> variables) {

    	String expression = "";
    	for (Variable v : variables) {

    		if (v.getName().equalsIgnoreCase("FILLER")) {
    			vars.add(Syntax.val(v.getValue()));
    		} else {
    			vars.add(Syntax.var(v.getName()));
    		}

    		expression += v.expression()+'\n'+'\t';

    	}


    	return expression;

    }




}
