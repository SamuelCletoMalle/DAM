import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BuscarPalabras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce la palabra a buscar: ");
        String palabra = scanner.nextLine();

        System.out.print("Introduce la ruta completa del fichero (con extensión): ");
        String rutaFichero = scanner.nextLine();

        int contador = 0;

        try (Scanner fileScanner = new Scanner(new File(rutaFichero))) {
            while (fileScanner.hasNextLine()) {
                String linea = fileScanner.nextLine(); // Lee la línea
                String[] palabrasLinea = linea.split("\\W+"); // Divide la línea en palabras

                for (int i = 0; i < palabrasLinea.length; i++) { // Uso de for con índice
                    if (palabrasLinea[i].equalsIgnoreCase(palabra)) { // Ignora mayúsculas
                        contador++;
                    }
                }
            }
            System.out.println("La palabra '" + palabra + "' aparece " + contador + " veces en el fichero '" + rutaFichero + "'.");
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }

        scanner.close(); // Cerrar el scanner
    }
}
