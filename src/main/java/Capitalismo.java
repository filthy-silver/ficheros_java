import java.io.*;
import java.util.Scanner;

public class Capitalismo {
    public static void main(String[] args) {
        File archivo = new File("src/main/resources/capitalizar.txt");
        if (!archivo.exists()) {
            System.out.println("El archivo no existe.");
            return;
        }
        capitalizarArchivo(archivo);
    }

    public static void capitalizarArchivo(File archivo) {
        File archivoTemp = new File(archivo.getParent(),archivo.getName().replace(".txt", "_temp.txt"));
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(archivoTemp));
            Scanner lector = new Scanner(archivo);

            while (lector.hasNext()) {
                String palabra = lector.next();
                String palabraCapitalizada = palabra.substring(0, 1).toUpperCase() + palabra.substring(1);
                writer.write(palabraCapitalizada + " ");
            }

            writer.close();
            lector.close();

            if (archivo.delete()) {
                if (archivoTemp.renameTo(archivo)) {
                    System.out.println("Archivo capitalizado correctamente.");
                } else {
                    System.out.println("Error al renombrar el archivo temporal.");
                }
            } else {
                System.out.println("Error al eliminar el archivo original.");
                archivoTemp.delete();
            }

        } catch (IOException e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
        }
    }
}

