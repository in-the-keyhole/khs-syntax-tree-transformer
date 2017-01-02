package khs.example;

public class BABYSTEPS   {

 	//Level 77
	private Double CONST_PI = 0.0;  
 	//Level 77
	private Double WORK_1 = 0.0;  
 	//Level 77
	private Double WORK_2 = 0.0;  
 	//Level 77
	private Double WORK_3 = 0.0;  
 	//Level 05
	private String EDT_ID = "ABCDE";
	
	//Level 05
	private Double EDT_3_15_CIR = 0.0;
	
	//Level 05
	private Double EDT_3_15_RAD = 0.0;
	
	//Level 05
	private Double EDT_1_15_PI = 0.0;
	//Level 01
	Object[] PRINT_LINE = new Object[]{EDT_ID," Perimeter ",EDT_3_15_CIR," Radius ",EDT_3_15_RAD," Pi ",EDT_1_15_PI,};  
    
 public static void main(String[] args) {
	 BABYSTEPS job = new BABYSTEPS ();
     job.A_PARA ();
  }   
    
 public void A_PARA () {
    WORK_1 = 123.46;
    WORK_2 = WORK_2+2;
    WORK_3 = WORK_2*3;
    C_PARA();
   }
   public void B_PARA () {
    CONST_PI = Math.PI;
    EDT_ID = "HELLO";
   }
   public void C_PARA () {
    B_PARA();
    System.out.println("PI IS: "+CONST_PI);
    ;
    System.out.print(EDT_ID);
	System.out.print(" Perimeter ");
	System.out.print(EDT_3_15_CIR);
	System.out.print(" Radius ");
	System.out.print(EDT_3_15_RAD);
	System.out.print(" Pi ");
	System.out.print(EDT_1_15_PI);
	;
   }
      
}