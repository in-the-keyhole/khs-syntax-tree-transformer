package khs.res.db2demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import khs.cobol.transformer.runtime.Display;
import khs.cobol.transformer.runtime.Database;


public class COBOLDB2   {
    private static Logger Log = LoggerFactory.getLogger("COBOLDB2");

 	// SQLCA
	private Object sqlca;

 	// Level 05
	private String ws_empno;

	// Level 05
	private String ws_last_name;

	// Level 05
	private String ws_first_name;

	//Level 01
	Object[] ws_employee_record = new Object[]{ws_empno,ws_last_name,ws_first_name,};

    public static void main(String[] args) {
        COBOLDB2 job = new COBOLDB2();
        job.procDiv();
    }

    public void procDiv () {
        Object[] rec = ws_employee_record;
		String sql = " SELECT EMPNO, LASTNAME, FIRSTNME FROM EMPLOYEE WHERE EMPNO=200310 ";
		Object[] sqlArgs = new Object[]{ws_empno, ws_last_name, ws_first_name};
;
		int sqlcode = Database.getInstance().selectInto( rec, sql, sqlArgs );

        if ( sqlcode == 0 ) {
			Display.display(ws_employee_record);
		} else {
			Display.display("Error");
		}
    }
}
