import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        generarFicheros();

        System.out.println("Contenido de la carpeta pep.");
        File directorio2 = new File("pep/.");

        String[] archivos = directorio2.list();

        if (archivos != null && archivos.length > 0){
            for (String a : archivos){
                System.out.println(a);
            }
        }else{
            System.out.println("No hay archivos en la carpeta");
        }

        System.out.println("-----------------------------------");
        listarCarpeta("pep");
        System.out.println("-----------------------------------");
        listarCarpeta("pep", "pdf");
        System.out.println("-----------------------------------");
        listarCarpeta("pep", "svg");
        System.out.println("-----------------------------------");
        listarCarpeta("pep", "jpeg");


        /*
        File archivo = new File("src/main/resources/prueba.txt");

        try{
            if (archivo.createNewFile()){
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
                System.out.println("El archivo " + archivo.getName() + " ya existe.");
            }
        } catch (Exception e) {
            System.out.println("Ha habido un error al crear el archivo.");
            e.printStackTrace();
        }

        File fichero = new File("src/main/resources/ejemplo1.txt");
        if(!fichero.exists())
            try{
                if (fichero.createNewFile()){
                    System.out.println("Archivo creado: " + fichero.getName());
                }
            } catch (Exception e) {
                System.out.println("Ha habido un error al crear el archivo.");
                e.printStackTrace();
            } else {
                System.out.println("El fichero " + fichero.getName() + " existe");
        }

        System.out.println("Nombre: " + fichero.getName());
        System.out.println("Longitud: " + fichero.length());
        System.out.println("Ruta absoluta: " + fichero.getAbsolutePath());

        // ejemplo carpeta
        File carpeta = new File("src/main/resources");
        if(carpeta.exists()) System.out.println("La carpeta " + carpeta.getName() + " existe");
        else System.out.println("La carpeta " + carpeta.getName() + " no existe");
        System.out.println("Nombre: " + carpeta.getName());
        System.out.println("Longitud: " + carpeta.length());
        System.out.println("Ruta absoluta: " + carpeta.getAbsolutePath());

        //Crear y borrar ficheros y carpetas

        File archivito = new File("nuevoArchivo.txt");
        try {
            if (archivito.createNewFile())  System.out.println("Archivo creado");
            else  System.out.println("El archivo ya existe");
        } catch (IOException e) {     e.printStackTrace();   }

        File directorio = new File("nuevoDirectorio");
        if (directorio.mkdir())  System.out.println("Directorio creado");
        else  System.out.println("No se pudo crear el directorio");

        File archivoBorrar = new File("archivoParaEliminar.txt");
        if (archivoBorrar.delete())  System.out.println("Archivo eliminado");
        else  System.out.println("No se pudo eliminar el archivo");
        */

    }

    public static void generarFicheros() {
        int cantidad = 0;
        String ruta = "";
        System.out.println(" > ¿Cuántos ficheros quieres generar?");
        do {
            if (sc.hasNextInt()) cantidad = sc.nextInt();
            else System.out.println(" > Debes introducir un número entero.");
            if (cantidad <= 0)System.out.println(" > El número debe ser mayor que 0.");
        } while (cantidad <= 0);

        System.out.println(" > ¿Cómo se llamará la carpeta?");

        sc.nextLine();

        do {
            if (sc.hasNextLine()) ruta = sc.nextLine();
            if (ruta.isEmpty()) System.out.println(" > El nombre de la carpeta no puede estar vacío.");
        } while (ruta.trim().isEmpty());

        for (int n = 1; n <= cantidad; n++) {
            crearFichero(ruta, n);
        }

    }

    private static void crearFichero(String ruta, int n) {
        File directorio = new File(ruta);
        File ficheros = new File(ruta+"/"+"fichero("+n+").txt");
        if (!ficheros.exists()) {
            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter(ruta+"/"+"fichero("+n+").txt"));
                if (!directorio.exists()) directorio.mkdirs();
                if (ficheros.createNewFile()) {
                    System.out.println(
                            " > Creando fichero: " + ficheros.getName() + "\n" +
                                    " > Ruta: " + ficheros.getAbsolutePath() + "."
                    );
                } else System.out.println(" > El fichero " + ficheros.getName() + " ya existe.");
                if (ficheros.exists()) {
                    writer.write("Este es el fichero " + ficheros.getName() + ".");
                    writer.close();
                }

            } catch (IOException e){
                System.out.println(" > Ha habido un error al crear el fichero: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private static void listarCarpeta(String carpeta){
        carpeta = carpeta;
        File directorio = new File(carpeta);
        if (directorio.isDirectory()){
            File[] archivos = directorio.listFiles();
            if (archivos != null && archivos.length > 0) {
                System.out.println(" > Archivos txt en la carpeta " + carpeta + ":");
                for (File a : archivos) {
                    if (a.toString().endsWith(".txt")) System.out.println("• " + a);
                }
            } else {
                System.out.println(" > No hay archivos en la carpeta " + carpeta);
            }
        } else {
            System.out.println(" > La ruta especificada no es una carpeta válida.");
        }
    }
    private static void listarCarpeta(String carpeta, String extension){
        carpeta = carpeta;
        File directorio = new File(carpeta);
        if (directorio.isDirectory()){
            File[] archivos = directorio.listFiles();
            if (archivos != null && archivos.length > 0) {
                System.out.println(" > Archivos " + extension.toLowerCase() + " en la carpeta " + carpeta + ":");
                for (File a : archivos) {
                    if (a.toString().endsWith("." + extension.toLowerCase())) System.out.println("• " + a);
                }
            } else {
                System.out.println(" > No hay archivos en la carpeta " + carpeta);
            }
        } else {
            System.out.println(" > La ruta especificada no es una carpeta válida.");
        }
    }
}
