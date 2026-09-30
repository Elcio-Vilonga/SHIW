import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class App1 {
    public static void main(String[] args) {
        int op;
        String path = "C:\\Users\\Pc\\Documents\\protopsi\\SHIW\\shiw.elcv";
        //String data = readFile(path);
        menu();

        do{
            switch (op = 0) {
                case 1:
                    //Registrar lista
                    writeFile(path);
                    break;
                case 2:
                    //Listar
                    System.out.println("========================");
                    readFile(path);
                    break;
                case 3:
                    //rr
                    break;
                case 4:
                    //rr
                    break;
                default:
                    //s
            }
        }while(true);
    }

//    public static String getFile(String path) {
//        String data = "";
//        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
//            do{
//                data = reader.readLine();
//                data +="\n";
//
//                if(data.equals("stop\n")) break;
//                fw.write(data);
//            }while(true);
//        } catch(Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return data;
//    }

    public static void writeFile(String path) {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileWriter fw = new FileWriter(path)) {
            System.out.println("Entre com seu texto: ");
            String data;
            do{
                data = reader.readLine();
                data +="\n";

                if(data.equals("stop\n")) break;
                fw.write(data);
            }while(true);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readFile(String path) {
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String data;
            while((data = reader.readLine()) != null){
                System.out.println(data);
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void menu() {
        System.out.println("====================");
        System.out.println("1 | Registrar");
        System.out.println("2 | Listar");
        System.out.println("3 | Editar");
        System.out.println("4 | Pesquisar");
        System.out.println("0 | Sair");
        System.out.println("====================");
    }
}
