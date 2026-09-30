import java.util.Scanner;

public class testes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String senhas10 = "Telegram";
        String senhas11 = "elvilong";
        String senhas12 = "uilweby87one";


//        String temp = input.nextLine();
        System.out.println("Nome atual: " +senhas10);
        System.out.print("Novo nome: ");
        String new_title = input.nextLine();
        System.out.println("Username atual: " +senhas11);
        System.out.print("Novo username: ");
        String new_username = input.nextLine();
        System.out.println("Password atual: " +senhas12);
        System.out.print("Nova password: ");
        String new_password = input.nextLine();

        if (new_title.isEmpty()) new_title = senhas10;
        if (new_username.isEmpty()) new_username = senhas11;
        if (new_password.isEmpty()) new_password = senhas12;
        senhas10 = new_title;
        senhas11 = new_username;
        senhas12 = new_password;

        System.out.println("««««««««««««««««««««");
        System.out.println("T. Senha: " +senhas10);
        System.out.println("Username: " +senhas11);
        System.out.println("Password: " +senhas12);
    }
}
