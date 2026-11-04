package co.protops.elvilon;

import java.util.List;

public class PrintBeauty {
    public void format(String text, char object) {
        int qtd = text.length();

        cabecalhoRodape(object,qtd);
        System.out.print("\n" +object+ " " +text+ " " +object+ "\n");
        cabecalhoRodape(object, qtd);
        System.out.println();
    }

    public static void cabecalhoRodape(char theObject, int qtd){
        for (int i = 0; i < qtd + 4; i++) {
            System.out.print(theObject);
        }
    }

    //essa brincadeira abaixo é para gerar uma tabela dinâmica,
    // que se adapta ao tamanho de cada elemento
    private int[] calcTabelas(List<Password> senhas) {
        int[] max_tmnh = new int[5]; // 0-> id |1-> nome |2-> user |3-> pass |4-> total

        for (Password senha : senhas) {
            if ((""+senha.getId()).length() > max_tmnh[0]) // ""+int -> retorna uma String
                max_tmnh[0] = Integer.toString(senha.getId()).length(); // Integer.toString(str) -> retorna uma String
            if (senha.getTitle().length() > max_tmnh[1])
                max_tmnh[1] = senha.getTitle().length();
            if (senha.getUsername().length() > max_tmnh[2])
                max_tmnh[2] = senha.getUsername().length();
            if (senha.getPass().length() > max_tmnh[3])
                max_tmnh[3] = senha.getPass().length();
        }
        for (int x = 0; x < max_tmnh.length; x++)
            max_tmnh[x] += 2; // para ter espaço entre as celulas
        // total         id         |     nome       |   username    |     password
        max_tmnh[4] = max_tmnh[0] + 1 + max_tmnh[1] +1+ max_tmnh[2] +1+ max_tmnh[3];
        return max_tmnh;
    }
    private String bumbaTexto(String txt, int max_tmnh) {
        int ajuste = max_tmnh - txt.length();
        StringBuilder espaco = new StringBuilder();       //// cria uma String que nem um array
        for (int i = 0; i < ajuste-1; i++)
            espaco.append(" ");
        txt += espaco + "| ";
        return txt;
    }
    private void escreve(Password senha, int[] max_tmnh) {
        System.out.println(bumbaTexto(""+senha.getId(), max_tmnh[0]) +
                bumbaTexto(senha.getTitle(), max_tmnh[1]) +
                bumbaTexto(senha.getUsername(), max_tmnh[2]) +
                bumbaTexto(senha.getPass(), max_tmnh[3]));
    }
    public void mostraTabela(List<Password> senhas, char objct) {
        int[] max = calcTabelas(senhas);
        cabecalhoRodape(objct, max[4]);
        System.out.println();
        for (Password senha : senhas) {
            System.out.print("| ");
            escreve(senha, max);
        }
        cabecalhoRodape(objct, max[4]);
        System.out.println();
    }
}
