package khs.res.db2demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class COBOLDB2   {

 	//Level SQLCA
	private Double SQLCA ;
 	//Level 05
	private String wS_EMPNO ;
	//Level 05
	private String wS_LAST_NAME ;
	//Level 05
	private String wS_FIRST_NAME ;
	//Level 01
	Object[] WS_EMPLOYEE_REC = new Object[]{wS_EMPNO,wS_LAST_NAME,wS_FIRST_NAME,};

    public static void main(String[] args) {
        COBOLDB2 job = new COBOLDB2 ();
        job.procDiv ();
    }

    public void procDiv () {
        selectInto("200310");
    }

    private static final Logger Log = LoggerFactory.getLogger("DB2DEMO");

    private static final String DB_DRIVER = "com.ibm.db2.jcc.DB2Driver";
    private static final String DB_PORT = "50000";
    private static final String DB_HOST = "0.0.0.0";
    private static final String DB_NAME = "sample";
    private static final String DB_USER = "db2inst1";
    private static final String DB_PASSWORD = "db2inst1-pwd";

    private static final String DB_JDBC_URL = String.format("jdbc:db2://%s:%s/%s", DB_HOST, DB_PORT, DB_NAME);

    // Hard-coded baby-step-pattern for template-generated DB2 select into method
    private boolean selectInto(String empNo) {

        Connection dbConnection = null;

        try {
            dbConnection = getDBConnection();

            String sql = "SELECT EMPNO, LASTNAME, FIRSTNME FROM EMPLOYEE WHERE EMPNO=?";
            //                "INTO :WS_EMPNO, :WS_LAST_NAME, :WS_FIRST_NAME FROM EMPLOYEE " +

            PreparedStatement pstm = dbConnection.prepareStatement(sql);
            pstm.setString(1, empNo);

            System.out.println(String.format("%6s %12s %15s", "EMP NO", "  FIRST NAME", "      LAST NAME"));
            System.out.println(String.format("%6s %12s %15s", "------", "------------", "---------------"));

            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                wS_EMPNO = rs.getString("EMPNO");
                wS_FIRST_NAME = rs.getString("FIRSTNME");
                wS_LAST_NAME = rs.getString("LASTNAME");

                System.out.println(String.format("%6s %12s %15s", wS_EMPNO, wS_FIRST_NAME, wS_LAST_NAME));
            }

            rs.close();
            pstm.close();
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


