package khs.cobol.transformer.model;

public class WorkingStorage {
	
		
	static String EDT_ID = " hello ";
    static double EDT_3_15_CIR = 100.00; 
 	
	
	static Object[] print_line = new Object[]{EDT_ID," Perimeter ",EDT_3_15_CIR};

	public static void main(String[] args) {
		
		for (Object o : print_line) {
			System.out.print(o);
		}
		
	}
	
	
}
