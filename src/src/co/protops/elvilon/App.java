package co.protops.elvilon;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PrintBeauty formato = new PrintBeauty();
        List<Password> senhas = new ArrayList<>();
        int id = 0;
//        int count = 0;
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
            option = input.nextInt();
            switch (option) {
                case 1:
                    System.out.println("= 1 -   Registrar    =");
                    senhas.add(registrar());
//                    ??melhorar essa parte: se apgr um objt e criar um nv, os 2 ultm terao o msm id
                    int last_item = senhas.size() - 1;
                    senhas.get(last_item).setId(last_item); // incrementa um id na senha criada
                    System.out.println("Password registrada com sucesso!");
                    break;
                case 2:
                    System.out.println("= 2 -   Listar       =");
                    listar(senhas);
                    break;
                case 3:
                    System.out.println("= 3 -   Abrir        =");
                    id = buscarPorId(senhas);
                    abrir(senhas, id);
                    break;
                case 4:
                    System.out.println("========== EDITAR ==========");
                    id = buscarPorId(senhas);
                    editar(senhas.get(id));
                    System.out.println("Senha editada com sucesso!");
                    break;
                case 5:
                    System.out.println("= 5 -   Remover      =");
//                    id = buscarPorId(senhas);
//                    if (id < 0) {
//                        System.out.println("Id INVALID");
//                        break;
//                    }
//                    senhas.remove(id);
                    remover(senhas);
                    System.out.println("Senha removida com sucesso!");
                    break;
                case 0: System.out.println("Encerrando o programa..."); break;
                default: System.out.println("INVALID OPTION...\n\tTry again.");
            }
        } while (option != 0);
    }

    public static boolean validarId(List<Password> senhas, int id) {
//        eh possivel o id ser maior que a lista, no caso,
//        o ultimo id serah sempre maior caso se eliminem outros
//        if (id >= 0 && id <= senhas.size() - 1) return true;
        if (senhas.isEmpty()) return false;

        return false;
    }
//    ??este metodo deveria ser buscarId()
    public static int buscarPorId(List<Password> senhas, int id) {
        if (senhas.isEmpty()) { System.out.println("Nenhuma password registrada."); return -1;}

//        ??implementar validador
        if (id >= 0) {
//            ?? como o id pode ser diferente do indice do objecto no array,
//                entao ele percorre os objectos para encontrar o id
            for (Password senha : senhas) {
                if (id == senha.getId())
                    return senhas.indexOf(senha); // o id recebe a posicao
            }
        }
        return -1;
    }
    public static int buscarPorId(List<Password> senhas) {
        Scanner input = new Scanner(System.in);

        if (senhas.isEmpty()) { System.out.println("Nenhuma password registrada."); return -1;}
        System.out.print("Seleciona o id: ");
        int id = input.nextInt();
//        if (id >= 0 && id <= senhas.size() - 1) return id;
//        for (Password senha : senhas) {
//            if (id == senha.getId())
//                return id;
//        }
        if (id >= 0) {
            for (Password senha : senhas) {
                if (id == senha.getId())
                    return senhas.indexOf(senha); // o id recebe a posicao
            }
        }
        return -1;
    }

// ⚠⚠⚠⚠⚠⚠️ vai gerar as senha simplismente, e a senha serah colocada na lista no main,
// o id recebe lah mesmo (no main)
    public static Password registrar() {
        Scanner input = new Scanner(System.in);
//                    int id = count;
        String title;
        String username;
        String password;

//        input.nextLine();
        System.out.print("Nome: ");
        title = input.nextLine();
        System.out.print("Username: ");
        username = input.nextLine();
        System.out.print("Password: ");
        password = input.nextLine();

//        Password pass = new Password(id, title, username,password);
        Password senha = new Password(title, username,password);
//        senha.(pass);
//        int id = senhas.size()-1; //para evitar pegar o -1, o id eh implementado depois da incercao
//        senhas.get(id).setId(id); //id sera == a posicao
//        System.out.println("Password registrada com sucesso!");
//        count++;
        return senha;
    }

    public static void listar(List<Password> senhas) {
        Scanner input = new Scanner(System.in);
        int op = 0;
        String opt;
        if (senhas.isEmpty()) {
            System.out.println("Nenhuma password registrada.");
        }else{
            do {
                System.out.println("========== PASSWORDS ==========");
                for (Password senha : senhas)
                    System.out.println(senha.getId() +". "+ senha.getTitle());
                System.out.println("\nSelecionar ID: ");
                System.out.println("* - Voltar");
//          ⚠️           PRECISO MELHORAR A VALIDACAO DO opt PARA VOLTAR
                opt = input.next();
                if (opt.equals("*"))
                    break;
                op = Integer.parseInt(opt);
                int id = buscarPorId(senhas, op);
                abrir(senhas, id);
            } while (op != 0);
        }
    }

    public static void abrir(List<Password> senhas, int id) {
        PrintBeauty formato = new PrintBeauty();
        Scanner input = new Scanner(System.in);
        int op = 0;

//        id = buscarPorId(senhas, id);
        if (id >= 0) {
            // exibe detalhes da password se id for valido
            formato.format(senhas.get(id).getTitle(),"#");
            System.out.println("Username: " +senhas.get(id).getUsername());
            System.out.println("Password: " +senhas.get(id).getPass()); //tera que colocar um PIN para ver a senha completa
            submenu();
            op = input.nextInt();
            switch (op) {
                case 1: System.out.println("====== Editar ======"); editar(senhas.get(id)); break;
                case 2: System.out.println("====== Remover ======"); remover(senhas, id); break;
                case 3: System.out.println("====== Voltar ======"); break;
                default: System.out.println("INVALID");
            }
        }
        else
            System.out.println("Password não encontrada.");
    }

    public static void editar(Password senha) {
        Scanner input = new Scanner(System.in);

//        String temp = input.nextLine();
        System.out.println("Nome atual: " +senha.getTitle());
        System.out.print("Novo nome: ");
        String new_title = input.nextLine();
        System.out.println("Username atual: " +senha.getUsername());
        System.out.print("Novo username: ");
        String new_username = input.nextLine();
        System.out.println("Password atual: " +senha.getPass());
        System.out.print("Nova password: ");
        String new_password = input.nextLine();

        if (new_title.isEmpty()) new_title = senha.getTitle();
        if (new_username.isEmpty()) new_username = senha.getUsername();
        if (new_password.isEmpty()) new_password = senha.getPassword();
        senha.setTitle(new_title);
        senha.setUsername(new_username);
        senha.setPassword(new_password);
    }

    public static void remover(List<Password> senhas, int id) {
        senhas.remove(id);
        System.out.println("Senha removida com sucesso!");
    }
    public static void remover(List<Password> senhas) {
        int id = buscarPorId(senhas);
        if (id < 0) {
            System.out.println("Id INVALID");
            return;
        }
        senhas.remove(id);
        System.out.println("Senha removida com sucesso!");
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
