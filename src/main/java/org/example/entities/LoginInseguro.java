package org.example.entities;

import org.example.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginInseguro {

    public static boolean auth(User u) throws Exception {

        Connection conn = DBConnection.conn();

        String sql = "SELECT * FROM users WHERE login = '"
                + u.getLogin() + "'AND pass = '" + u.getPass() + "'";
        System.out.println("SQL gerada = " + sql);

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        return rs.next();
    }
}
