package khs.transformer.model;

public class Syntax {

	// Validate variable syntax
	public static String var(String value) {

		String validated = value.replace('-', '_');
		return validated;
	}
	
	// Validate literal value syntax
	public static String val(String value) {
        String validated = value;
		if (value != null) {
	  	   validated = value.replace('\'', '"');
        }
		
		if (value == null) {
			validated = "0.0";
		}
		
		if ("ZERO".equals(value)) {
			validated = "0.0";
		}
		
		if ("0".equalsIgnoreCase(value)) {
			validated = "0.0";
		}
		

		if ("PI".equalsIgnoreCase(value)) {
			validated = "Math.PI";
		}
		
		
		
		
		return validated;
	}	
	
	
	
	

}
