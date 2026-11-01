package co.protops.elvilon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PasswordManager {
//    private List<Password> senhas = new ArrayList<>();

//    public void addSenha(Password senha) {
//        senhas.add(senha);
//    }

    static void main() {
        Scanner input = new Scanner(System.in);
        List<Password> senhas = new ArrayList<>();

        int id;
        for (int i = 0; i < 5; i++) {
            Password actual = new Password(i, "senha"+i,"user"+i,"pass");
            senhas.add(actual);
        }
    }

//    //    ??calma ai, vou te mexer mais tarde
//    public static boolean validarId(List<Password> senhas, int id) {
////        eh possivel o id ser maior que a lista, no caso,
////        o ultimo id serah sempre maior caso se eliminem outros
////        if (id >= 0 && id <= senhas.size() - 1) return true;
//        if (senhas.isEmpty()) return false;
//
//        return false;
//    }

    public static int geradorId(List<Password> senhas) {
        return senhas.getLast().getId() + 1;
    }

    //    ??este metodo deveria ser buscarId()
    public static int buscarId(List<Password> senhas, int id) {
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
    public static int buscarId(List<Password> senhas) {
        Scanner input = new Scanner(System.in);

        if (senhas.isEmpty()) { System.out.println("Nenhuma password registrada."); return -1;}

        System.out.print("Seleciona o id: ");
        int id = input.nextInt();
        return buscarId(senhas,id);
    }

    // ⚠⚠⚠⚠⚠⚠️ vai gerar as senha simplismente, e a senha serah colocada na lista no main,
// o id recebe lah mesmo (no main)
    public static Password registrar() {
        Scanner input = new Scanner(System.in);
//                    int id = count;
        String title;
        String username;
        String password;

        System.out.print("Nome: ");
        title = input.nextLine();
        System.out.print("Username: ");
        username = input.nextLine();
        System.out.print("Password: ");
        password = input.nextLine();

        return new Password(title, username,password);
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
                int id = buscarId(senhas, op);
                abrir(senhas, id);
            } while (op != 0);
        }
    }

    public static void abrir(List<Password> senhas, int id) {
        PrintBeauty formato = new PrintBeauty();
        Scanner input = new Scanner(System.in);
        int op = 0;

        if (id >= 0) {
            // exibe detalhes da password se id for valido
            formato.format(senhas.get(id).getTitle(),"#");
            System.out.println("Username: " +senhas.get(id).getUsername());
            System.out.println("Password: " +senhas.get(id).getPass()); //tera que colocar um PIN para ver a senha completa
            Main.submenu();
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
        Scanner input = new Scanner(System.in);
        System.out.println("Deseja realmente remover " +senhas.get(id).getTitle()+ "?");
        System.out.print("1 - Sim\t2 - Não\n$>: ");
        int op = input.nextInt();
        if (op == 2)
            return;
        senhas.remove(id);
        System.out.println("Senha removida com sucesso!");
    }
    public static void remover(List<Password> senhas) {
        int id = buscarId(senhas);
        if (id < 0) {
            System.out.println("Id INVALID");
            return;
        }
        remover(senhas,id);
    }
}
