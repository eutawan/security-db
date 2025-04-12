package org.example;

import org.example.entities.LoginSeguro;
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
            case 1:
                System.out.print("Digite seu usuário: ");
                sc.nextLine();
                String userLogin = sc.next();
                System.out.print("Digite sua senha: ");
                String passLogin = sc.next();

                User u = new User(userLogin, passLogin);
                if (LoginSeguro.auth(u)) {
                    System.out.println("\nLogin efetuado com sucesso!");
                }
                else {
                    System.out.println("\nUsuário ou senha inválidos.");
                }
                break;

            case 2:
                System.out.print("Digite seu usuário: ");
                sc.nextLine();
                String newUser = sc.nextLine();

                System.out.print("Digite sua senha: ");
                String newPass = sc.nextLine();

                User user1 = new User(newUser, newPass);
                UserDAO userDAO = new UserDAO();
                userDAO.cadastrar(user1);

                break;

            case 3:
                System.out.print("Digite seu nome de usuário: ");
                sc.nextLine();
                String user = sc.nextLine();

                System.out.print("Digite a nova senha: ");
                String passUpdate = sc.next();

                User user3 = new User(user, passUpdate);
                UserDAO userDAO2 = new UserDAO();

                userDAO2.atualizar(user3);

                break;

            default:
                System.out.println("\nOpção inválida, burro.");
        }

    }
}