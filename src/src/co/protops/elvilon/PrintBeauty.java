package co.protops.elvilon;

public class PrintBeauty {
    public void format(String text, String object) {
        int qtd = text.length();

        cabecalhoRodape(object,qtd);
        System.out.print("\n" +object+ " " +text+ " " +object+ "\n");
        cabecalhoRodape(object, qtd);
        System.out.println("");
    }

    public static void cabecalhoRodape(String theObject, int qtd){
        for (int i = 0; i < qtd + 4; i++) {
            System.out.print(theObject);
        }
    }
}
