import java.util.Scanner;

public class BinarioADecimal {

    // Método para leer un número binario y almacenarlo en un array
    public static int[] leerBinario() {
        Scanner scanner = new Scanner(System.in);
        int[] binario = new int[10]; // Array para almacenar un máximo de 10 números
        int index = 0;

        System.out.println("Introduce números binarios (0 o 1). Introduce un número negativo para terminar:");

        while (index < 10) {
            int numero = scanner.nextInt();

            if (numero < 0) {
                break; // Finaliza si el número es negativo
            }

            if (numero == 0 || numero == 1) {
                binario[index] = numero; // Almacena el número válido
                index++;
            } else {
                System.out.println("Número inválido. Solo se permiten 0 y 1.");
            }
        }

        return binario;
    }

    // Método para convertir un número binario almacenado en un array a base 10
    public static int binarioADecimal(int[] binario) {
        int decimal = 0;
        int longitud = binario.length;

        for (int i = 0; i < longitud; i++) {
            decimal += binario[i] * Math.pow(2, longitud - 1 - i); // Convierte cada dígito binario
        }

        return decimal;
    }

    // Método principal
    public static void main(String[] args) {
        int[] binario = leerBinario();
        int decimal = binarioADecimal(binario);
        System.out.println("El número en base 10 es: " + decimal);
    }
}
