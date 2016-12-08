package khs.transformer.model;

public class Variable {
	
	private String name;
	private String typeName;
	
	private String value;
	private boolean isLocal;
	private boolean isWorking;
	private boolean isArray;
	private String fileLevel;
	//private String[] variables;
	
	
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
		
		return "ZERO".equals(this.getValue()) ? "0" : this.getValue();
	}
	
	
	public String expression() {
		
		String dataType = "Double";
		
		if ("SPACES".equals(this.getValue())) {
			
			dataType = "String";
		} 
		
		
		return "private "+dataType+" "+this.getName() +" = "+this.value() + ";";
	}

}
