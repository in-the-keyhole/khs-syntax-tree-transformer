package khs.transformer.model;

public class Method {

	public static String MOVE = "MOVE";
	public static String ADD = "ADD";
	public static String MULTI = "MULTI";
	public static String CALL = "CALL";
	public static String DISPLAY = "DISPLAY";

	private String name;
	private String typeName;

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

		if (this.getType().getTypeName() == null) {
			return expression;
		}

		if (this.getType().getTypeName().equalsIgnoreCase(MOVE)) {

			expression = Syntax.var(this.getType().getVarName()) + " = " + Syntax.val(this.getType().getValue());
		}

		if (this.getType().getTypeName().equalsIgnoreCase(ADD)) {

			if (this.getType().getVar2() == null) {
				expression = Syntax.var(this.getType().getVar1()) + " = " + Syntax.var(this.getType().getVar1()) + "+"
						+ this.getType().getValue();
				;
			} else {

				expression = Syntax.var(this.getType().getVar2()) + " = " + Syntax.var(this.getType().getVar1()) + "+"
						+ this.getType().getValue();

			}

		}

		if (this.getType().getTypeName().equalsIgnoreCase(MULTI)) {

			if (this.getType().getVar2() == null) {
				expression = Syntax.var(this.getType().getVar1()) + " = " + Syntax.var(this.getType().getVar1()) + "*"
						+ this.getType().getValue();
				;
			} else {
				expression = Syntax.var(this.getType().getVar2()) + " = " + Syntax.var(this.getType().getVar1()) + "*"
						+ this.getType().getValue();
				;

			}

		}

		if (this.getType().getTypeName().equalsIgnoreCase(CALL)) {

			expression = Syntax.var(this.getType().getName()) + "()";

		}

		if (this.getType().getTypeName().equalsIgnoreCase(DISPLAY)) {

			expression = "System.out.println(" + Syntax.var(this.getType().getValue()) + ")";

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
