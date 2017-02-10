package khs.cobol.transformer.model;

import khs.transformer.util.Syntax;


public class Method {

    private static String GOBACK = "GOBACK";
    private static String EXIT = "EXIT";
    private static String MOVE = "MOVE";
    private static String SET = "SET";
    private static String ADD = "ADD";
    private static String MULTI = "MULTI";
    private static String CALL = "CALL";
    private static String DISPLAY = "DISPLAY";
    private static String IF = "IF";
    private static String ELSE = "ELSE";
    private static String DBMETHOD = "DB_METHOD";
    private static String PROC_DIV = "procdiv";

    private String name;
    private String typeName;

    private String expr;

    public String getExpr() {
        return expr;
    }

    public void setExpr(String expr) {
        this.expr = expr;
    }


    private Method[] body;

    public Method[] getBody() {
        return body;
    }

    public void setBody(Method[] body) {
        this.body = body;
    }

    private Method stmElse;

    public Method getStmElse() {
        return stmElse;
    }

    public void setStmElse(Method stmElse) {
        this.stmElse = stmElse;
    }

    private String value;

    public String getValue() {

        // Hack around issue of Cobol vars coming into this process with numeric prefixes and minuss in the name
        // TODO fix Cobol-to-Java var name fixup (do it at another point)
        for( Variable var : Program.singleInstance.getVariables() ){
            if (var.getName().replace('-', '_').equalsIgnoreCase(value)) {
                return "v_" + value;
            }
        }
        return value;
    }

    public void setValue(String value) { this.value = value; }

    // ---- db2 stuff ----
    private String sql;
    private String[] sqlArgs;

    public String[] getSqlArgs() {
        return sqlArgs;
    }

    public void setSqlArgs(String[] sqlArgs) {
        this.sqlArgs = sqlArgs;
    }

    public String getSql() {
        return null == sql ? "" : sql.trim();
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

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
            StringBuilder sb = new StringBuilder(String.format("final String sql = \"%s\";\n", getSql()));

            // Build "into" output record from sqlArgs
            String sep = "";
            sb.append("\n\t\tfinal OutItem[] into = new OutItem[]{");
            sep = "\n\t\t\t";
            for (String item : getSqlArgs()) {
                sb.append(sep);
                sb.append(String.format("s -> v_%s = (String)s", item));
                sep = ",\n\t\t\t";
            }
            sb.append("\n\t\t};\n");

            // Call Database helper
            sb.append("\n\t\tsqlcode = Database.getInstance().selectInto( sql, into );\n");

            expression = sb.toString();

        } else if (IF.equalsIgnoreCase(getName())) {
            StringBuilder sb = new StringBuilder(String.format("if ( %s ) {", getExpr()));

            // Eval body here, appending each body method expression to sb.
            for (Method m : this.getBody()) {
                // append string result of recurse on method, m
                sb.append("\n\t\t\t").append(m.expression()).append(';');
            }
            sb.append("\n\t\t}");


            if (null != getStmElse()) {
                // append string result of recurse to optional paired else ( allows arbitrary if-else nesting)
                sb.append(getStmElse().expression());
            }

            expression = sb.toString();

        } else if (ELSE.equalsIgnoreCase(getName())) {
            StringBuilder sb = new StringBuilder(String.format(" else {"));

            // Eval body else-body here, appending each body method expression to sb.
            for (Method m : this.getBody()) {
                sb.append("\n\t\t\t").append(m.expression()).append(';');
            }
            sb.append("\n\t\t}");
            expression = sb.toString();

        } else if (PROC_DIV.equalsIgnoreCase(getName())) {
            expression = PROC_DIV;

        } else if ("DISPLAY".equalsIgnoreCase(getName())) {
            // if value is object array, enumerate/prints its elements, else just prints a passed simple string.
            expression = String.format("Display.display( %s )", getValue());

        } else if (MOVE.equalsIgnoreCase(getTypeName())) {
            expression = "// MOVE ...\n\t\t";
            expression += String.format("%s = %s;", Syntax.var(getName()), Syntax.val(getValue()));

        } else if (SET.equalsIgnoreCase(getTypeName())) {
            expression = "// SET ...\n\t\t";
            expression += String.format("%s = %s;", Syntax.var(getName()), Syntax.val(getValue()));

        } else if (CALL.equalsIgnoreCase(getTypeName())) {
            expression = "// PERFORM ...\n\t\t";
            expression += String.format("%s();", Syntax.method(getName()));

        } else if (EXIT.equalsIgnoreCase(getTypeName())) {
            expression = "// EXIT ...\n\t\t";
            expression += "System.exit(0);";

        } else if (GOBACK.equalsIgnoreCase(getTypeName())) {
            expression = "// GOBACK ...\n\t\t";
            expression += "return;";
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
