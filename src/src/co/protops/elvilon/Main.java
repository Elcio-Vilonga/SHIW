package co.protops.elvilon;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PrintBeauty formato = new PrintBeauty();
        List<Password> senhas = new ArrayList<>();
        int id = 0;
        int option = 0;
//        /*
//        so para gerar ja algumas senhas//////////////////////////////////////////////
        for (int i = 0; i < 5; i++) {
            Password actual = new Password(i, "senha"+i,"user"+i,"pass");
            senhas.add(actual);
        }
//        */

        do {
//     ⚠⚠⚠⚠⚠⚠️       remover depois
            for (Password senha : senhas)
                System.out.println(senha.toString());
            menu();
//            System.out.println(PasswordManager.geradorId(senhas));

            option = input.nextInt();
            switch (option) {
                case 1:
                    System.out.println("= 1 -   Registrar    =");
                    senhas.add(PasswordManager.registrar());
//                    ??melhorar essa parte: se apgr um objt e criar um nv, os 2 ultm terao o msm id
//                    int last_item = senhas.size() - 1;
//                    int last_item = senhas.getLast().getId() + 1;

                    int last_item = PasswordManager.geradorId(senhas);
                    senhas.get(last_item).setId(last_item); // incrementa um id na senha criada
                    System.out.println("Password registrada com sucesso!");
                    break;
                case 2:
                    System.out.println("= 2 -   Listar       =");
                    PasswordManager.listar(senhas);
                    break;
                case 3:
                    System.out.println("= 3 -   Abrir        =");
                    id = PasswordManager.buscarId(senhas);
                    PasswordManager.abrir(senhas, id);
                    break;
                case 4:
                    System.out.println("========== EDITAR ==========");
                    id = PasswordManager.buscarId(senhas);
                    PasswordManager.editar(senhas.get(id));
                    System.out.println("Senha editada com sucesso!");
                    break;
                case 5:
                    System.out.println("= 5 -   Remover      =");
                    PasswordManager.remover(senhas);
                    System.out.println("Senha removida com sucesso!");
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
