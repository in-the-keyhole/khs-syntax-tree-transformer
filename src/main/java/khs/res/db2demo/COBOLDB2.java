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
            String sql = "SELECT EMPNO, LASTNAME, FIRSTNME FROM EMPLOYEE WHERE EMPNO='200310'";
            String[] sqlArgs = new String[]{ "ws_empno", "ws_last_name", "ws_first_name" };
            selectInto( ws_employee_record, sql, sqlArgs );
                // Display the record
                if ( sqlcode == 0 ) {
                        // Array: display this way:
                        for (Object item : ws_employee_record) {
                                System.out.print(String.format("%s ", item));
                        }
                        System.out.println();
                } else {
                        // Scalar: display this way;
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
        private boolean selectInto( Object[] rec, String sql, String[] slqArgs ) {

                Connection dbConnection = null;

                try {
                        sqlcode = -1;
                        dbConnection = getDBConnection();

                        PreparedStatement pstm = dbConnection.prepareStatement(sql);

                        ResultSet rs = pstm.executeQuery();
                        if (rs.next()) {
                            int i = 0;
                            for (Object item : rec ) {
                                rec[i++] = rs.getObject(i);
                            }
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


