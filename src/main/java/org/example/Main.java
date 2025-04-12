package org.example;

import org.example.entities.User;
import org.example.entities.UserDAO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Escolha uma opcão: ");
        System.out.println("1 - Fazer login");
        System.out.println("2 - Cadastrar novo usuário");
        System.out.println("3 - Alterar senha");

        switch (sc.nextInt()){
            case 2:
                System.out.println("Digite seu usuário: ");
                String user = sc.nextLine();
                System.out.println("Digite sua senha: ");
                String pass = sc.nextLine();
                User user1 = new User(user, pass);
                UserDAO userDAO = new UserDAO();
                userDAO.cadastrar(user1);

            case 3:
                System.out.print("Digite a nova senha:");
                String newPass = sc.nextLine();

        }

    }
}