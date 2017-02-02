package khs.transformer.util;

public class Syntax {

	//Source templates
	public static String Signature = "public %s %s(){\n";
	public static String Body = "\t %s \n";
	public static String Result = "\treturn %s;\n }\n";


	public static String strip(char c,String s) {

		return s.replace(c,' ');
	}

	public static String method(String value){
		String validated = var(value);
		if (null != validated) {
			validated = "m_" + validated.toLowerCase();
		}
		return validated;
	}

	// Validate variable syntax
	public static String var(String value) {
		String validated = value != null ? value.replace('-', '_') : value;
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
