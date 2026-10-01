import java.io.File;

public class SumaTamañoFicheros {

    public static void main(String[] args) {
        // Especificar el directorio que se desea analizar
        File directorio = new File("E:\\SMA\\Cositas");

        // Variable para almacenar el tamaño total
        long tamanoTotal = 0;

        // Obtener la lista de archivos en el directorio
        File[] ficheros = directorio.listFiles();

        // Verificar si el directorio contiene archivos
        if (ficheros != null) {
            // Usar un bucle for tradicional
            for (int i = 0; i < ficheros.length; i++) {
                // Comprobar si es un archivo (no un directorio)
                if (ficheros[i].isFile()) {
                    // Sumar el tamaño del archivo al total
                    tamanoTotal += ficheros[i].length();
                }
            }
        } else {
            System.out.println("El directorio no contiene archivos o no existe.");
        }

        // Mostrar el tamaño total de los archivos
        System.out.println("El tamaño total de los ficheros es: " + tamanoTotal + " bytes");
    }
}

