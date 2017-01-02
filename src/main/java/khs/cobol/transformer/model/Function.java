package khs.cobol.transformer.model;

import java.util.List;

import khs.transformer.util.Syntax;

public class Function {
	
	private String name;

	private String typeName;
	
	private List<Method> methods;

	public String getName() {
		return Syntax.var(name);
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

	public List<Method> getMethods() {
		return methods;
	}

	public void setMethods(List<Method> methods) {
		this.methods = methods;
	}

	
}
