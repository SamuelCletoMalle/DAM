import java.io.File; // Importar la clase File para manejar archivos y directorios
import java.util.Scanner; // Importar la clase Scanner para leer la entrada del usuario

public class EjerG1File {
    // Método para calcular el tamaño total de un directorio
    static long tamanoDirectorio(String nomDirectorio) throws Exception {
        long tamano = 0; // Inicializar el tamaño total a 0
        File d = new File(nomDirectorio); // Crear un objeto File para el directorio especificado
        if (d.isDirectory()) { // Verificar si el objeto es un directorio
            String[] list = d.list(); // Obtener la lista de archivos y subdirectorios en el directorio
            for (int i = 0; i < list.length; i++) { // Iterar sobre cada elemento en la lista
                File faux = new File(d, list[i]); // Crear un objeto File para cada elemento
                tamano += faux.length(); // Sumar el tamaño del archivo o directorio al total
            }
        } else {
            throw new Exception("El directorio no existe"); // Lanzar una excepción si no es un directorio
        }
        return tamano; // Retornar el tamaño total del directorio
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Crear un objeto Scanner para leer la entrada del usuario
        System.out.println("Dar nombre del directorio"); // Solicitar al usuario que ingrese el nombre del directorio
        String nomDirectorio = sc.nextLine(); // Leer el nombre del directorio
        try {
            long tamano = tamanoDirectorio(nomDirectorio); // Llamar al método para calcular el tamaño del directorio
            System.out.println("El tamaño del directorio es: " + tamano); // Mostrar el tamaño total
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Manejar excepciones y mostrar el mensaje de error
        }
    }
}