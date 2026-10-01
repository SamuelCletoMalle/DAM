import java.io.File; // Importar la clase File para manejar archivos y directorios
import java.util.Scanner; // Importar la clase Scanner para leer la entrada del usuario

public class Ej2 {
    // Método público que recibe la ruta de un directorio como String y llama al método privado
    public long tamanoDirectorio(String directorio) {
        return tamanoDirectoriov2(new File(directorio)); // Llamar al método privado con un objeto File
    }

    // Método privado que calcula el tamaño total de un directorio y su contenido
    private long tamanoDirectorio(File directorio) {
        long suma = 0; // Inicializar la suma a 0
        if (directorio.isDirectory()) { // Verificar si el objeto es un directorio
            String ficheros[] = directorio.list(); // Obtener la lista de archivos y subdirectorios
            for (int i = 0; i < ficheros.length; i++) { // Iterar sobre cada elemento
                File f = new File(directorio, ficheros[i]); // Crear un objeto File para cada elemento
                if (f.isFile()) { // Si es un archivo
                    suma += f.length(); // Sumar su tamaño
                } else if (f.isDirectory()) { // Si es un subdirectorio
                    suma += tamanoDirectorio(f); // Llamar recursivamente para sumar su tamaño
                }
            }
        } else {
            System.out.println("El directorio no existe"); // Mensaje de error si no es un directorio
        }
        return suma; // Retornar la suma total
    }

    // Método privado alternativo que utiliza listFiles() para obtener los archivos
    private long tamanoDirectoriov2(File directorio) {
        long suma = 0; // Inicializar la suma a 0
        if (directorio.isDirectory()) { // Verificar si el objeto es un directorio
            File ficheros[] = directorio.listFiles(); // Obtener la lista de archivos y subdirectorios como objetos File
            for (int i = 0; i < ficheros.length; i++) { // Iterar sobre cada elemento
                File f = ficheros[i]; // Obtener el objeto File
                if (f.isFile()) { // Si es un archivo
                    suma += f.length(); // Sumar su tamaño
                } else if (f.isDirectory()) { // Si es un subdirectorio
                    suma += tamanoDirectorio(f); // Llamar recursivamente para sumar su tamaño
                }
            }
        } else {
            System.out.println("El directorio no existe"); // Mensaje de error si no es un directorio
        }
        return suma; // Retornar la suma total
    }

    public static void main(String[] args) {
        Ej2 o = new Ej2(); // Crear una instancia de la clase Ej2
        System.out.println("Introduce el directorio"); // Solicitar al usuario que introduzca un directorio
        Scanner sc = new Scanner(System.in); // Crear un objeto Scanner para leer la entrada del usuario
        String fRuta = sc.nextLine(); // Leer la ruta del directorio
        sc.close(); // Cerrar el escáner
        File f = new File(fRuta); // Crear un objeto File con la ruta proporcionada
        // Imprimir el tamaño total del contenido del directorio
        System.out.println("El tamaño de todo el contenido del directorio " + f.getAbsolutePath() + " es de: " + o.tamanoDirectorio(fRuta));
    }
}