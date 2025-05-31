import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class LecturaScanner {
    static Scanner sc = new Scanner(System.in);
    static List<String> listaPalabras = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Introduce la palabra a buscar: ");
        buscarPalabra(sc.nextLine());
    }

    private static void buscarPalabra(String palabra) {
        int contador = 0;

        try {
            File archivo = new File("src/main/resources/datos.txt");
            Scanner lector = new Scanner(archivo);

            while (lector.hasNext()) {
                if (lector.next().equals(palabra)) contador++;
            }
            lector.close();

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
            e.printStackTrace();
        }
        System.out.println("La palabra " + palabra + " se ha encontrado " + contador + " veces.");
    }

}
