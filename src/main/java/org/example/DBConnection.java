package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection conn = null;

    public static Connection conn() throws Exception{
        String url = "jdbc:postgresql://localhost:5432/security_db";
        String user = "postgres";
        String pass = "tawandev";

        return DriverManager.getConnection(url, user, pass);
    }

    public static void closeConn() throws SQLException {
        try {
            if (conn != null) {
                conn.close();
            }
        }
        catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
}
