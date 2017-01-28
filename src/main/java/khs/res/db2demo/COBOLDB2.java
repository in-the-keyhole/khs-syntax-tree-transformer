package khs.res.db2demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import khs.cobol.transformer.runtime.Display;
import khs.cobol.transformer.runtime.Database;
import khs.cobol.transformer.runtime.InItem;
import khs.cobol.transformer.runtime.OutItem;

/**
 * Java source, file COBOLDB2.java generated from Cobol source, COBOLDB2.cbl
 *
 * @version 0.0.2
 * @author Keyhole Software LLC
 */
public class COBOLDB2   {
    private static Logger Log = LoggerFactory.getLogger("COBOLDB2");

 	// SQLCA
	public int sqlcode;

 	// Level 05
	public String ws_empno;

	// Level 05
	public String ws_last_name;

	// Level 05
	public String ws_first_name;

	// Level 01
	public InItem[] ws_employee_record = new InItem[]{ () -> ws_empno, () -> ws_last_name, () -> ws_first_name };

    public static void main(String[] args) {
        try {
            COBOLDB2 instance = new COBOLDB2();
            instance.procDiv();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void procDiv () throws Exception {
        String sql = "SELECT EMPNO, LASTNAME, FIRSTNME FROM EMPLOYEE WHERE EMPNO=200310";

		OutItem[] outFields = new OutItem[]{
			s -> ws_empno = (String)s,
			s -> ws_last_name = (String)s,
			s -> ws_first_name = (String)s
		};

		sqlcode = Database.getInstance().selectInto( sql, outFields );

        if ( sqlcode == 0 ) {
			Display.display( ws_employee_record );
		} else {
			Display.display( "Error" );
		}
    }
}
