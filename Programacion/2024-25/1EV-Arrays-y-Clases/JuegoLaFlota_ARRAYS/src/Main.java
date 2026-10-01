import java.util.Scanner;
import java.util.Random;

public class FlotaDeBarcos {
    public static void main(String[] args) {
        final int TAMANIO = 5; // Tamaño del tablero
        int[][] tablero = new int[TAMANIO][TAMANIO];
        int barcosRestantes = 3; // Número de barcos a hundir
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        // Colocamos 3 barcos aleatoriamente en el tablero
        for (int i = 0; i < barcosRestantes; i++) {
            int fila, columna;
            do {
                fila = random.nextInt(TAMANIO);
                columna = random.nextInt(TAMANIO);
            } while (tablero[fila][columna] == 1); // Asegurarse de no colocar dos barcos en la misma posición
            tablero[fila][columna] = 1; // 1 representa un barco
        }

        System.out.println("¡Bienvenido a Flota de Barcos!");
        System.out.println("Debes hundir 3 barcos en un tablero de 5x5.");
        System.out.println("Introduce las coordenadas (fila y columna) para atacar.");

        int intentos = 0;

        while (barcosRestantes > 0) {
            System.out.print("Introduce la fila (0-4): ");
            int fila = sc.nextInt();
            System.out.print("Introduce la columna (0-4): ");
            int columna = sc.nextInt();

            // Verificar que las coordenadas sean válidas
            if (fila < 0 || fila >= TAMANIO || columna < 0 || columna >= TAMANIO) {
                System.out.println("¡Coordenadas fuera de rango! Intenta de nuevo.");
                continue;
            }

            // Verificar el resultado del disparo
            if (tablero[fila][columna] == 1) {
                System.out.println("¡Tocado! Hundiste un barco.");
                tablero[fila][columna] = -1; // Marcamos el barco como hundido
                barcosRestantes--;
            } else if (tablero[fila][columna] == -1) {
                System.out.println("¡Ya hundiste este barco! Intenta otro lugar.");
            } else {
                System.out.println("¡Agua! No había ningún barco allí.");
            }

            intentos++;
            System.out.println("Barcos restantes: " + barcosRestantes);
        }

        System.out.println("¡Felicidades! Hundiste todos los barcos en " + intentos + " intentos.");
    }
}
