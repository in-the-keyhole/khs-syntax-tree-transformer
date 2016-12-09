package khs.example;

public class Program   {

 	//Level 77
	private Double CONST_PI = 0.0;  
 	//Level 77
	private Double WORK_1 = 0.0;  
 	//Level 77
	private Double WORK_2 = 0.0;  
 	//Level 77
	private Double WORK_3 = 0.0;  
 	//Level 05
	private Double EDT_ID = "ABCDE";
	
	//Level 05
	private Double EDT_3_15_CIR = 0.0;
	
	//Level 05
	private Double EDT_3_15_RAD = 0.0;
	
	//Level 05
	private Double EDT_1_15_PI = 0.0;
	//Level 01
	Object[] PRINT_LINE = new Object[]{EDT_ID," Perimeter ",EDT_3_15_CIR," Radius ",EDT_3_15_RAD," Pi ",EDT_1_15_PI,};  
    
 public static void main(String[] args) {
	 Program job = new Program ();
     job.A_PARA ();
  }   
    
 public void A_PARA () {
    WORK_1 = 123.46;
    WORK_2 = WORK_2+2;
    WORK_3 = WORK_2*3;
    C_PARA();
   }
   public void B_PARA () {
    CONST_PI = Math.PI;;
    EDT_ID = 0.0;
   }
   public void C_PARA () {
    System.out.println("PI IS: " + CONST_PI);
    B_PARA();
   }
      
}