package co.protops.elvilon;

import java.lang.Integer; //para usar o Integer.parseInt() -> converte de String para int
import java.util.List;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;

public class PasswordStorage {
//    public static String caminho = "C:\\Users\\Pc\\Desktop\\SHIW\\src\\shiw.elcv";
//    private static String caminho = "C:\\Users\\Pc\\Desktop\\SHIW\\src\\shiw.elcv";
//    private static String caminho;
//
//    public void setCaminho (String caminho) { PasswordStorage.caminho = caminho; }
//    public String getCaminho () { return caminho; }

    //trata da leitura
    public void load(List<Password> lista, String caminho) {
        try (BufferedReader leitor = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] dados = linha.split(";");
                Password senha = new Password(Integer.parseInt(dados[0]), dados[1], dados[2], dados[3]);
                lista.add(senha);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    //trata da escrita
    public void save(List<Password> lista, String caminho) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(caminho))) {
            for (Password password : lista) {
                String linha = password.toString();
                escritor.write(linha);
                escritor.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
