package co.protops.elvilon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PrintBeauty formato = new PrintBeauty();
        int id = 0;
        int option = 0;

//        /*
//        so para gerar ja algumas senhas//////////////////////////////////////////////
        for (int i = 0; i < 5; i++) {
            Password actual = new Password("senha"+i,"user"+i,"pass");
//            senhas.add(actual);
            PasswordManager.senhas.add(actual);
        }
//        */
        Password senha = new Password("telegram", "@rolotovski", "1234567");
        PasswordManager.senhas.add(senha);
        formato.mostraTabela(PasswordManager.senhas, '=');

        do {
            menu();
            option = input.nextInt();
            switch (option) {
                case 1:
                    System.out.println("= 1 -   Registrar    =");
                    PasswordManager.senhas.add(PasswordManager.registrar());
                    System.out.println("Password registrada com sucesso!");
                    break;
                case 2:
                    System.out.println("= 2 -   Listar       =");
                    formato.mostraTabela(PasswordManager.senhas, '=');
//                    PasswordManager.listar(PasswordManager.senhas);
                    break;
                case 3:
                    System.out.println("= 3 -   Abrir        =");
                    id = PasswordManager.buscarId(PasswordManager.senhas);
                    PasswordManager.abrir(PasswordManager.senhas, id);
                    break;
                case 4:
                    System.out.println("========== EDITAR ==========");
                    id = PasswordManager.buscarId(PasswordManager.senhas);
                    PasswordManager.editar(PasswordManager.senhas.get(id));
                    System.out.println("Senha editada com sucesso!");
                    break;
                case 5:
                    System.out.println("= 5 -   Remover      =");
                    PasswordManager.remover(PasswordManager.senhas);
                    break;
                case 0: System.out.println("Encerrando o programa..."); break;
                default: System.out.println("INVALID OPTION...\n\tTry again.");
            }
        } while (option != 0);
    }


    public static void menu() {
        System.out.println("======================");
        System.out.println("= 1 -   Registrar    =");
        System.out.println("= 2 -   Listar       =");
        System.out.println("= 3 -   Abrir        =");
        System.out.println("= 4 -   Editar       =");
        System.out.println("= 5 -   Remover      =");
        System.out.println("= 0 -   Sair         =");
        System.out.println("======================");
        System.out.print("Escolha: ");
    }

    public static void submenu() {
        System.out.println("======================");
        System.out.println("= 1 -   Editar       =");
        System.out.println("= 2 -   Remover      =");
        System.out.println("= 3 -   Voltar       =");
        System.out.println("======================");
        System.out.print("Escolha: ");
    }
}
