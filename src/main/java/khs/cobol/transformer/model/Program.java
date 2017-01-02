package khs.cobol.transformer.model;

import java.util.List;

public class Program {

	private String name;
	private String typeName;
	private String pckge;
	private List<Variable> variables;
	private List<Function> functions;
	
	public static Program singleInstance = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPckge() {
		return pckge;
	}

	public void setPckge(String pckge) {
		this.pckge = pckge;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<Variable> getVariables() {
		return variables;
	}

	public void setVariables(List<Variable> variables) {
		this.variables = variables;
	}

	public List<Function> getFunctions() {
		return functions;
	}

	public void setFunctions(List<Function> functions) {
		this.functions = functions;
	}
	

	

}
