import java.io.*;
import java.util.Scanner;

public class Combinador {

    public static void main(String[] args) {
        File impar = new File("src/main/resources/impar.txt");
        File par = new File("src/main/resources/par.txt");
        File combinados = new File("src/main/resources/combinados.txt");

        combinarArchivos(impar, par, combinados);
    }

    public static void combinarArchivos(File impar, File par, File combinados) {
        try (
                Scanner scImpar = new Scanner(impar);
                Scanner scPar = new Scanner(par);
                PrintWriter writer = new PrintWriter(new FileWriter(combinados))) {

            while (scPar.hasNext() && scImpar.hasNext()) {
                writer.print(scImpar.next() + " " + scPar.next() + " ");
                System.out.println("Documento combinado, par e impar.");
            }
            while (scImpar.hasNext() | scPar.hasNext()) {
                if       (scImpar.hasNext()) {
                    writer.print(scImpar.next() + " ");
                    System.out.println("Documento impar.");
                }
                if (scPar.hasNext()) {
                    writer.print(scPar.next() + " ");
                    System.out.println("Documento par.");
                }
            }
            System.out.println("Los archivos se han combinado correctamente: " + combinados);

        } catch (IOException e) {
            System.out.println("Error al combinar los archivos: " + e.getMessage());
        }

    }
}
