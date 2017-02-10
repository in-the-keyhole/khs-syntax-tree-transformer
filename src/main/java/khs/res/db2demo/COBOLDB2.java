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
 * @version 0.0.3
 * @author Keyhole Software LLC
 */
public class COBOLDB2   {
    private static Logger Log = LoggerFactory.getLogger("COBOLDB2");
 	// SQLCA
	private int sqlcode;

 	// Level 05
	private String v_ws_empno;

	// Level 05
	private String v_ws_last_name;

	// Level 05
	private String v_ws_first_name;

	// Level 01
	private InItem[] v_ws_employee_record = new InItem[]{ () -> v_ws_empno, () -> v_ws_last_name, () -> v_ws_first_name };
    // Procedure division entry:
    public static void main(String[] args) {
        try {
            COBOLDB2 instance = new COBOLDB2();
            instance.m_procdiv();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void m_procdiv () throws Exception {
        final String sql = "SELECT EMPNO, LASTNAME, FIRSTNME FROM EMPLOYEE WHERE EMPNO=200310";

		final OutItem[] into = new OutItem[]{
			s -> v_ws_empno = (String)s,
			s -> v_ws_last_name = (String)s,
			s -> v_ws_first_name = (String)s
		};

		sqlcode = Database.getInstance().selectInto( sql, into );

        if ( sqlcode == 0 ) {
			Display.display( v_ws_employee_record );
		} else {
			Display.display( "Error" );
		}
        // EXIT ...
		System.exit(0);
    }

}
