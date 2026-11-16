package co.protops.elvilon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class testes {
    static Scanner input = new Scanner(System.in);

    public static void main() {
        List<Password> caixa = new ArrayList<>();
        String caminho = "C:\\Users\\Pc\\Desktop\\SHIW\\src\\shiw.elcv";

        /*carrega os dados ao abrir*/
        load(caixa, caminho);

        int op;
        do {
            System.out.println("1.Gravar\n2.Registrar\n3.Listar\n4.Remover\n5.Editar\n0.Sair");
            System.out.print("$:> ");
            op = input.nextInt();
            switch (op) {
                case 0: System.out.println("saindo..."); break;
                case 1: save(caixa, caminho); break;
                case 2: registrar(caixa); break;
                case 3: listar(caixa); break;
                case 4: remove(caixa); break;
                case 5: editar(caixa); break;
                default: System.out.println("INVALID!");
            }
        } while (op != 0);

        /*grava um ‘backup’ ao fechar programa*/
        save(caixa,"backupShiw.elcv");
    }

    public static void save(List<Password> lista, String caminho) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(caminho))) {
            for (Password senha : lista) {
                String linha = senha.toString();
                escritor.write(linha);
                escritor.newLine();
            }
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void load(List<Password> lista,String caminho) {
        try (BufferedReader leitor = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] dados = linha.split(";");
                Password senha = new Password(Integer.parseInt(dados[0]),dados[1],dados[2],dados[3]);
                lista.add(senha);
            }
            System.out.println("Dados carregados com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro: " +e.getMessage());
        }
    }

    public static void listar(List<Password> lista) {
        if (lista.isEmpty()) {
            System.out.println("Sem dados a exibir!");
        }else {
            int i = 0;
            for (Password senha : lista)
                System.out.println(senha.getId()+ "| " +senha.getTitle()+ " | " +senha.getUsername());
        }
    }

    public static void remove(List<Password> lista) {
        if (lista.isEmpty()) {
            System.out.println("Sem dados gravados!");
            return;
        }
        System.out.print("Linha a eliminar: ");
//        int linha = Integer.parseInt(input.nextLine());
        int linha = input.nextInt();
        input.nextLine();
        if (lista.isEmpty() || linha < 0 || linha >= lista.size()) {
            System.out.println("Linha nao encontrada!");
        } else {
            Password copia_linha = lista.get(linha);
            lista.remove(linha);
            System.out.println("{" +copia_linha+ "}");
            System.out.println("Linha removida com sucesso!");
        }
    }

    public static void editar(List<Password> lista) {
        System.out.print("Linha a editar: ");
//        int linha = Integer.parseInt(input.nextLine());
        int linha = input.nextInt();
        input.nextLine();
        if (linha < 0 || linha >= lista.size()) {
            System.out.println("Linha nao encontrada!");
        } else {
            PasswordManager.editar(lista.get(linha));

//            System.out.println("Actual: " +lista.get(linha));
//            System.out.print("Nova texto: ");
//            String nova = input.nextLine();
//
//            if (nova.isEmpty()) return;
//            lista.set(linha, nova); //substitute
//            System.out.println("Linha editada com sucesso!");
        }
    }

    public static void registrar(List<Password> lista) {
        Password senha = PasswordManager.registrar();
        lista.add(senha);
    }
}
