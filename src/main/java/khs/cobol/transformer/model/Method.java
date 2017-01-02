package khs.cobol.transformer.model;

import khs.transformer.util.Syntax;

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
