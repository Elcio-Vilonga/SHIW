import java.util.List;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class testes {
    static Scanner input = new Scanner(System.in);

    public static void main() {
        List<String> caixa = new ArrayList<>();
        String caminho = "C:\\Users\\Pc\\Desktop\\SHIW\\src\\shiw.elcv";

        /*carrega os dados ao abrir*/
        load(caixa, caminho);

        int op;
        do {
            System.out.println("1.Gravar\n2.Listar\n3.Remover\n4.Editar\n0.Sair");
            System.out.print("$:> ");
            op = input.nextInt();
            switch (op) {
                case 0: System.out.println("saindo..."); break;
                case 1: save(caixa, caminho); break;
                case 2: listar(caixa); break;
                case 3: remove(caixa); break;
                case 4: editar(caixa); break;
                default: System.out.println("INVALID!");
            }
        } while (op != 0);

        /*grava um ‘backup’ ao fechar programa*/
        save(caixa,"backupShiw.elcv");
    }

    public static void save(List<String> lista, String caminho) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(caminho))) {
            for (String item : lista) {
                escritor.write(item);
                escritor.newLine();
            }
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void load(List<String> lista,String caminho) {
        try (BufferedReader leitor = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
//                String[] dados = linha.split(";");
//                lista.add(dados);
                lista.add(linha);
            }
            System.out.println("Dados carregados com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro: " +e.getMessage());
        }
    }

    public static void listar(List<String> lista) {
        if (lista.isEmpty()) {
            System.out.println("Sem dados a exibir!");
        }else {
            int i = 0;
            for (String linha : lista)
                System.out.println(i++ +"| "+ linha);
        }
    }

    public static void remove(List<String> lista) {
        System.out.print("Linha a eliminar: ");
        int linha = Integer.parseInt(input.nextLine());
        if (linha < 0 || linha >= lista.size()) {
            System.out.println("Linha nao encontrada!");
        } else {
            String copia_linha = lista.get(linha);
            lista.remove(linha);
            System.out.println("{" +copia_linha+ "}");
            System.out.println("Linha removida com sucesso!");
        }
    }

    public static void editar(List<String> lista) {
        System.out.print("Linha a editar: ");
        int linha = Integer.parseInt(input.nextLine());
        if (linha < 0 || linha >= lista.size()) {
            System.out.println("Linha nao encontrada!");
        } else {
            System.out.println("Actual: " +lista.get(linha));
            System.out.print("Nova texto: ");
            String nova = input.nextLine();

            if (nova.isEmpty()) return;
            lista.set(linha, nova); //substitute
            System.out.println("Linha editada com sucesso!");
        }
    }
}
