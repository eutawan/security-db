package org.example.entities;

import org.example.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    private static Connection conn = null;

    public boolean loginExiste(String userLogin) throws Exception {

        conn = DBConnection.conn();

        String sql = "SELECT * FROM users WHERE login = ?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, userLogin);

        ResultSet rs = st.executeQuery();

        return rs.next();
    }

    public void cadastrar(User u) throws Exception {

        if (loginExiste(u.getLogin())) {
            System.out.println("Este login já está em uso");
        }
        else {
            conn = DBConnection.conn();

            String sql = "INSERT INTO users (login, pass) VALUES (?, ?)";

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, u.getLogin());
            st.setString(2, u.getPass());

            int rows = st.executeUpdate();

            if (rows > 0) {
                System.out.println("Usuário cadastrado com sucesso");
            } else {
                System.out.println("Erro ao executar");
            }
        }
    }

    public void atualizar(User u) throws Exception {
        conn = DBConnection.conn();

        if (loginExiste(u.getLogin())){

            String sql = "UPDATE users set pass = ? where login = ?";

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, u.getPass());
            st.setString(2, u.getLogin());

            st.executeUpdate();
            System.out.println("Usuário " + u.getLogin() + " atualizado com sucesso");
        }
        else {
            System.out.println("Esse usuário não existe");
        }
    }
}
