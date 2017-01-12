/*
 * Copyright (c) 2017. Keyhole Labs, LLC
 */

package khs.transformer.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Created by mauget on 1/10/17 10:37 AM.
 *
 * A utility app that smoke-tests a DB2 Express Docker container.
 * Displays the sample database org rows.
 */
public class CheckDb2Connection {
    private static final Logger Log = LoggerFactory.getLogger(CheckDb2Connection.class);

    private static final String DB_DRIVER = "com.ibm.db2.jcc.DB2Driver";
    private static final String DB_PORT = "50000";
    private static final String DB_HOST = "0.0.0.0";
    private static final String DB_NAME = "sample";
    private static final String DB_USER = "db2inst1";
    private static final String DB_PASSWORD = "db2inst1-pwd";

    private static final String DB_JDBC_URL = String.format("jdbc:db2://%s:%s/%s", DB_HOST, DB_PORT, DB_NAME);

    public static void main(String[] args) {
        new CheckDb2Connection().run();
    }

    public void run() {
        new CheckDb2Connection().selectOrg();
    }

    private void selectOrg() {
        try {
            Connection dbConnection = null;
            dbConnection = getDBConnection();

            PreparedStatement pstm = dbConnection.prepareStatement("SELECT * from ORG ORDER BY LOCATION");
            ResultSet rs = pstm.executeQuery();

            System.out.println(String.format("%2s %16s %3s %10s %15s", "D#", "DEPT NAME", "MGR", "DIV", "LOCATION"));
            System.out.println(String.format("%2s %16s %3s %10s %15s", "--", "---------", "---", "---", "--------"));
            while (rs.next()) {

                Long deptnumb = rs.getLong("DEPTNUMB");
                String deptName = rs.getString("DEPTNAME");
                Long manager = rs.getLong("MANAGER");
                String division = rs.getString("DIVISION");
                String location = rs.getString("LOCATION");

                String rec = String.format("%02d %16s %03d %10s %15s", deptnumb, deptName, manager, division, location);

                System.out.println(rec);

            }
            rs.close();
            pstm.close();
            dbConnection.close();;
        } catch (SQLException e) {
            e.printStackTrace();
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
