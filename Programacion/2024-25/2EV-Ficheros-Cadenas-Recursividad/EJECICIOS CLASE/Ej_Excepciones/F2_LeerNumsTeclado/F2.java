package F2; // Declaración del paquete

import java.util.Scanner; // Importar la clase Scanner para leer la entrada del usuario

public class F2 {

    // Método para leer dos números y devolver su suma
    public static int leerYSumarNumeros() {
        Scanner scanner = new Scanner(System.in); // Crear un objeto Scanner para leer la entrada del usuario
        int numero1 = 0; // Variable para almacenar el primer número
        int numero2 = 0; // Variable para almacenar el segundo número
        boolean correctos = false; // Variable para controlar la validez de los números ingresados

        // Bucle que se repite hasta que se ingresen dos números válidos
        while (!correctos) {
            try {
                System.out.print("Ingresa el primer número: "); // Solicitar el primer número
                String s1 = scanner.nextLine(); // Leer la entrada del usuario
                numero1 = Integer.parseInt(s1); // Intentar convertir la entrada a un entero
                System.out.print("Ingresa el segundo número: "); // Solicitar el segundo número
                String s2 = scanner.nextLine(); // Leer la entrada del usuario
                numero2 = Integer.parseInt(s2); // Intentar convertir la entrada a un entero
                correctos = true; // Si ambos números son válidos, cambiar el estado a verdadero
            } catch (NumberFormatException e) { // Capturar la excepción si la conversión falla
                System.out.println("Números no válidos."); // Informar al usuario que los números no son válidos
            }
        }
        return numero1 + numero2; // Retornar la suma de los dos números
    }

    public static void main(String[] args) {
        int resultado = F2.leerYSumarNumeros(); // Llamar al método para leer y sumar los números
        System.out.println("La suma de los números es: " + resultado); // Mostrar el resultado de la suma
    }
}
