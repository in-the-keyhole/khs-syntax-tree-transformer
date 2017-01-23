package khs.res.db2demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import khs.cobol.transformer.runtime.Display;
import khs.cobol.transformer.runtime.Database;

/**
 * Java source, file COBOLDB2.java generated from Cobol source, COBOLDB2.cbl.
 *
 * @version 0.0.1
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
    public String[] ws_employee_record = new String[]{ "ws_empno", "ws_last_name", "ws_first_name" };

    public static void main(String[] args) {
        try {
            COBOLDB2 instance = new COBOLDB2();
            instance.procDiv();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void procDiv () throws Exception {
        String sql = " SELECT EMPNO, LASTNAME, FIRSTNME FROM EMPLOYEE WHERE EMPNO=200310 ";
        String[] sqlArgs = new String[]{ "ws_empno", "ws_last_name", "ws_first_name" };

        sqlcode = Database.getInstance().selectInto( sql, sqlArgs, this );

        if ( sqlcode == 0 ) {
            Display.display(ws_employee_record, this);
        } else {
            Display.display("Error", this);
        }
    }
}
