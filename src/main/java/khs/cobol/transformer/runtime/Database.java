package khs.cobol.transformer.runtime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Created by mauget on 1/22/17 9:50 AM.
 */
public class Database {

    private static final Logger Log = LoggerFactory.getLogger("DB2DEMO");

    private static final String DB_DRIVER = "com.ibm.db2.jcc.DB2Driver";
    private static final String DB_PORT = "50000";
    private static final String DB_HOST = "0.0.0.0";
    private static final String DB_NAME = "sample";
    private static final String DB_USER = "db2inst1";
    private static final String DB_PASSWORD = "db2inst1-pwd";

    private static final String DB_JDBC_URL = String.format("jdbc:db2://%s:%s/%s", DB_HOST, DB_PORT, DB_NAME);

    private static final int RC_ERROR = -1;
    private static final int RC_OK = 0;
    private int sqlcode = RC_ERROR;

    private static Database instance;
    public static Database getInstance(){
        if (null == instance){
            instance = new Database();
        }
        return instance;
    }

    private Database() {
    }

    // Baby-step  DB2 select-into
    public int selectInto( String sql, OutItem[] outFields) {

        Connection dbConnection = null;
        sqlcode = RC_ERROR;

        try {

            dbConnection = getDBConnection();

            PreparedStatement pstm = dbConnection.prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                // Store result values to output fields
                int i = 0;
                for( OutItem item : outFields){
                    item.put(rs.getObject(++i));
                }
            }

            rs.close();
            pstm.close();
            sqlcode = RC_OK;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                dbConnection.close();
            } catch (SQLException e) {
                Log.error(e.getMessage());
            }

        }
        return sqlcode;
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
