package org.example.entities;

import org.example.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

    public static void loginExiste(User u) {
        if (u.getLogin() != null){
            LoginSeguro loginSeguro = new LoginSeguro();

        }
    }

    public void cadastrar(User u) {

        try {
            Connection conn = DBConnection.conn();

            String sql = "INSERT INTO users (login, pass) VALUES (?, ?)";

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, u.getLogin());
            st.setString(2, u.getPass());

            st.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualizar(User u) {
        try {
            Connection conn = DBConnection.conn();

            String sql = "UPDATE users set pass = ? where login = ?";

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, u.getPass());
            st.setString(2, u.getLogin());

            st.executeUpdate();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
