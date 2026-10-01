import java.util.Scanner; // Importar la clase Scanner para leer la entrada del usuario

public class E1_Palindroma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Crear un objeto Scanner para leer la entrada del usuario
        System.out.println("Introduce una cadena de caracteres"); // Solicitar al usuario que introduzca una cadena
        String cadena = sc.nextLine(); // Leer la cadena ingresada por el usuario

        // Convertir la cadena a minúsculas y eliminar espacios en blanco
        cadena = cadena.toLowerCase().replaceAll("\\s+", "");
        int longcadena = cadena.length(); // Obtener la longitud de la cadena
        boolean palindroma = true; // Inicializar la variable que indica si la cadena es palíndroma

        // Comprobar si la cadena es palíndroma
        for (int i = 0; i <= longcadena / 2 && palindroma; i++) {
            // Comparar los caracteres desde el inicio y el final de la cadena
            if (cadena.charAt(i) != cadena.charAt(longcadena - 1 - i)) {
                palindroma = false; // Si hay una diferencia, no es palíndroma
            }
        }

        // Mostrar el resultado
        if (palindroma) {
            System.out.println("La cadena es palíndroma"); // Mensaje si es palíndroma
        } else {
            System.out.println("La cadena no es palíndroma"); // Mensaje si no es palíndroma
        }
    }
}
