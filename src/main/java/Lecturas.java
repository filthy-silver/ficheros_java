import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Lecturas {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.print("Introduce una palabra a buscar:\n > ");
        buscarPalabra(sc.nextLine());

    }

    private static void buscarPalabra(String palabra){
        try {
            BufferedReader lector = new BufferedReader(new FileReader("src/main/resources/datos.txt"));
            String linea;

            int contador = 0;

            while ((linea = lector.readLine()) != null) {
                linea = linea.toLowerCase();
                int indice = 0;
                while ((indice = linea.indexOf(palabra.toLowerCase(), indice)) != -1) {
                    contador++;
                    indice += palabra.length();
                }
            }

            if (contador == 0) {
                System.out.println("La palabra '" + palabra + "' no se encontró en el archivo.");
            } else System.out.println("La palabra '" + palabra + "' se encontró " + contador + " veces en el archivo.");

            lector.close();

        } catch (IOException e) {
            System.out.println(e.getStackTrace());
            throw new RuntimeException(e);
        }
    }



}