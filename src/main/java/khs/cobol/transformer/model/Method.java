package khs.cobol.transformer.model;

import khs.transformer.util.Syntax;

public class Method {

	public static String MOVE = "MOVE";
	public static String ADD = "ADD";
	public static String MULTI = "MULTI";
	public static String CALL = "CALL";
    public static String DISPLAY = "DISPLAY";
    public static String IF = "IF";
    public static String ELSE = "ELSE";
    public static String DBMETHOD = "DbMethod";

	private String name;
	private String typeName;

	private String expr;
    public String getExpr() { return expr;  }
    public void setExpr(String expr) { this.expr = expr;  }


    private Method[] body;
    public Method[] getBody() { return body; }
    public void setBody(Method[] body) { this.body = body; }

    // ---- db2 stuff ----
	private String sql;
    private String[] sqlArgs;

    public String[] getSqlArgs() { return sqlArgs; }

    public void setSqlArgs(String[] sqlArgs) { this.sqlArgs = sqlArgs;  }

    public String getSql() {  return sql;  }

    public void setSql(String sql) { this.sql = sql;  }

    // ------------------


	private Type type;

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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String expression() {

		String expression = "";

		if (DBMETHOD.equalsIgnoreCase(this.getName())) {
			expression = "selectInto();";
		}
        else if(IF.equalsIgnoreCase(this.getName())){
            expression = String.format("if (%s) {", getExpr());
        }
        else if("procdiv".equalsIgnoreCase(this.getName())){
            System.out.println("procdiv");
        }

		if (this.getTypeName() == null) {
			return expression;
		}

		if (this.getTypeName().equalsIgnoreCase(MOVE)) {

			expression = Syntax.var(this.getType().getVarName()) + " = " + Syntax.val(this.getType().getValue());
		}



		return expression;

	}

	public String constants(String value) {

		String result = value;

		if (value.equals("PI")) {
			result = "Math.PI;";
		}

		return result;

	}

}
