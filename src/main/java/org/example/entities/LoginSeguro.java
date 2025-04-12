package org.example.entities;

import org.example.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginSeguro {

    public static boolean auth(User u) throws Exception{
        Connection conn = DBConnection.conn();

        String sql = "SELECT * FROM users WHERE login = ? AND pass = ?";

        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, u.getLogin());
        st.setString(2, u.getPass());

        ResultSet rs = st.executeQuery();
        return rs.next();

    }
}
