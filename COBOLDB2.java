package khs.res.db2demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;


public class COBOLDB2   {

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
        selectInto();
        if ( sqlcode == 0 ) {
			System.out.println(ws_employee_record);
		} else {
			System.out.println("Error");
		}
    }
    
    


    private static final Logger Log = LoggerFactory.getLogger("DB2DEMO");

    private static final String DB_DRIVER = "com.ibm.db2.jcc.DB2Driver";
    private static final String DB_PORT = "50000";
    private static final String DB_HOST = "0.0.0.0";
    private static final String DB_NAME = "sample";
    private static final String DB_USER = "db2inst1";
    private static final String DB_PASSWORD = "db2inst1-pwd";

    private static final String DB_JDBC_URL = String.format("jdbc:db2://%s:%s/%s", DB_HOST, DB_PORT, DB_NAME);

    private int sqlcode = -1;

    // Baby-step-pattern for template-generated DB2 select into method
    private boolean selectInto( String empNo ) {

        Connection dbConnection = null;

        try {
            sqlcode = -1;
            dbConnection = getDBConnection();

            String sql = "SELECT EMPNO, LASTNAME, FIRSTNME FROM EMPLOYEE WHERE EMPNO=?";
            //                "INTO :WS_EMPNO, :WS_LAST_NAME, :WS_FIRST_NAME FROM EMPLOYEE " +

            PreparedStatement pstm = dbConnection.prepareStatement(sql);
            pstm.setString(1, empNo);

            System.out.println(String.format("%6s %12s %15s", "EMP NO", "  FIRST NAME", "      LAST NAME"));
            System.out.println(String.format("%6s %12s %15s", "------", "------------", "---------------"));

            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                ws_empno = rs.getString("EMPNO");
                ws_first_name = rs.getString("FIRSTNME");
                ws_last_name = rs.getString("LASTNAME");

                System.out.println(String.format("%6s %12s %15s", ws_empno, ws_first_name, ws_last_name));
            }

            rs.close();
            pstm.close();
            sqlcode = 0;
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                dbConnection.close();
            } catch (SQLException e) {
                Log.error(e.getMessage());
            }

        }
    }

    private static Connection getDBConnection() {

        Connection dbConnection = null;

        try {
            Class.forName(DB_DRIVER);
            Log.info(DB_JDBC_URL);
            dbConnection = DriverManager.getConnection(DB_JDBC_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            Log.error(e.getMessage());
        } catch (SQLException e) {
            Log.error(e.getMessage());
        }

        return dbConnection;
    }
}


