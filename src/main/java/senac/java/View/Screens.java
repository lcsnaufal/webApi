package senac.java.View;

import senac.java.Domain.Salesperson;
import senac.java.Domain.Users;
import senac.java.Services.ExitProgram;


import java.util.Scanner;

public class Screens {
    static Scanner sc = new Scanner(System.in);
    static Users user = new Users();
    static Salesperson salesperson = new Salesperson();
    public static void StartScreen(){
        int response = 0;
        System.out.println("Bem-Vindo ao programa de cadastros!");
        System.out.println("1. Cadastrar Vendedor");
        System.out.println("2. Cadastrar Cliente");
        System.out.println("3. Cadastrar Produto");
        System.out.println("4. Sair");
        response = sc.nextInt();

        if(response == 0){
            ExitProgram.exit();
        }
    }

    public static void sellerScreen(){
        System.out.println("Insira seu nome");
        salesperson.name = sc.nextLine();
        System.out.println("Insira seu sobrenome");
        salesperson.lastName = sc.nextLine();
        System.out.println("Insira seu número de celular");
        salesperson.phoneNumber = sc.nextLine();
        System.out.println("Insira seu cpf");
        salesperson.cpf = sc.nextLine();
        System.out.println("Insira seu email");
        salesperson.email

    }
}

// user.name = sc.nextLine();    variavel global pode ser usada de qualquer lugar do código
