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
    public static String DBMETHOD = "DB_METHOD";
    public static String PROC_DIV = "procdiv";

	private String name;
	private String typeName;

	private String expr;
    public String getExpr() { return expr;  }
    public void setExpr(String expr) { this.expr = expr;  }


    private Method[] body;
    public Method[] getBody() { return body; }
    public void setBody(Method[] body) { this.body = body; }

    private Method stmElse;
    public Method getStmElse() { return stmElse; }
    public void setStmElse(Method stmElse) { this.stmElse = stmElse;}

    private String value;
    public String getValue() { return value;  }
    public void setValue(String value) { this.value = value; }

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

        if (DBMETHOD.equalsIgnoreCase(getName())) {
            expression = "selectInto();";

        } else if (IF.equalsIgnoreCase(getName())) {
            StringBuilder sb = new StringBuilder(String.format("if ( %s ) {", getExpr()));

            // Eval body here, appending each body method expression to sb.
            for (Method m : this.getBody()) {
                // Recurse on method, m
                sb.append("\n\t\t\t").append( m.expression() ).append(";");
            }
            sb.append("\n\t\t}");

            // Recurse to optional paired else ( allows arbitrary if-else nesting)
            if (null != getStmElse()) {
                sb.append(getStmElse().expression());
            }

            expression = sb.toString();

        } else if (ELSE.equalsIgnoreCase(getName())) {
            StringBuilder sb = new StringBuilder(String.format(" else {" ));

            // Eval body else-body here, appending each body method expression to sb.
            for (Method m : this.getBody()) {
                sb.append("\n\t\t\t").append(m.toString());
            }
            sb.append("\n\t\t}");
            expression = sb.toString();

        } else if (PROC_DIV.equalsIgnoreCase(getName())) {
            expression = PROC_DIV;

        }  else if ("DISPLAY".equalsIgnoreCase(getName())) {
            // TODO if value is object array, enumerate/print its elements
            expression = String.format("System.out.println(%s)", getValue());

        } else 	if (MOVE.equalsIgnoreCase( getTypeName())) {
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
