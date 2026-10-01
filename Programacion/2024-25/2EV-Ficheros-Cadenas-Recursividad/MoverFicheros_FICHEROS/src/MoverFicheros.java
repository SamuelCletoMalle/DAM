import java.io.File;
import java.util.Scanner;

public class MoverFicheros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        String directorioOrigen ="E:\\IES\\PRUEBA2" ;

        String directorioDestino = "E:\\IES\\PRUEBA1";


        File dirOrigen = new File(directorioOrigen);
        File dirDestino = new File(directorioDestino);


        if (!dirOrigen.exists() || !dirOrigen.isDirectory()) {
            System.out.println("El directorio de origen no existe o no es un directorio válido.");
            return;
        }


        if (!dirDestino.exists() || !dirDestino.isDirectory()) {
            System.out.println("El directorio de destino no existe o no es un directorio válido.");
            return;
        }


        String[] archivos = dirOrigen.list();
        if (archivos != null) {
            for (String nombreArchivo : archivos) {
                File archivoOrigen = new File(dirOrigen, nombreArchivo);
                File archivoDestino = new File(dirDestino, nombreArchivo);


                if (archivoDestino.exists()) {
                    System.out.println("El archivo " + nombreArchivo + " ya existe en el directorio de destino. No se moverá.");
                } else {

                    boolean exito = archivoOrigen.renameTo(archivoDestino);
                    if (exito) {
                        System.out.println("Moviendo " + nombreArchivo + " a " + dirDestino.getPath());
                    } else {
                        System.out.println("No se pudo mover " + nombreArchivo);
                    }
                }
            }
        } else {
            System.out.println("No hay archivos en el directorio de origen.");
        }

        scanner.close();
    }
}

//º