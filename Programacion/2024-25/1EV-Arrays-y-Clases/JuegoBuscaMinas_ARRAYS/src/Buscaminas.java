import java.util.Scanner;
import java.util.Random;

public class Buscaminas {
    public static void main(String[] args) {
        final int TAMANIO = 5; // Tamaño del tablero
        final int NUM_MINAS = 5; // Número de minas en el tablero
        int[][] tablero = new int[TAMANIO][TAMANIO]; // 0: vacío, -1: mina
        boolean[][] descubierto = new boolean[TAMANIO][TAMANIO]; // True si la casilla fue descubierta
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        // Colocar minas aleatoriamente
        for (int i = 0; i < NUM_MINAS; i++) {
            int fila, columna;
            do {
                fila = random.nextInt(TAMANIO);
                columna = random.nextInt(TAMANIO);
            } while (tablero[fila][columna] == -1); // Evitar colocar más de una mina en la misma casilla
            tablero[fila][columna] = -1;

            // Incrementar números en casillas adyacentes
            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {
                    int nuevaFila = fila + x;
                    int nuevaColumna = columna + y;
                    if (nuevaFila >= 0 && nuevaFila < TAMANIO && nuevaColumna >= 0 && nuevaColumna < TAMANIO && tablero[nuevaFila][nuevaColumna] != -1) {
                        tablero[nuevaFila][nuevaColumna]++;
                    }
                }
            }
        }

        System.out.println("¡Bienvenido a Buscaminas!");
        System.out.println("Descubre todas las casillas sin tocar una mina.");
        int casillasPorDescubrir = (TAMANIO * TAMANIO) - NUM_MINAS;
        boolean juegoTerminado = false;

        while (casillasPorDescubrir > 0 && !juegoTerminado) {
            imprimirTablero(descubierto, tablero);
            System.out.print("Introduce la fila (0-4): ");
            int fila = sc.nextInt();
            System.out.print("Introduce la columna (0-4): ");
            int columna = sc.nextInt();

            // Verificar si la entrada es válida
            if (fila < 0 || fila >= TAMANIO || columna < 0 || columna >= TAMANIO) {
                System.out.println("¡Coordenadas fuera de rango! Intenta de nuevo.");
                continue;
            }

            // Verificar si la casilla ya fue descubierta
            if (descubierto[fila][columna]) {
                System.out.println("¡Ya descubriste esta casilla! Intenta otra.");
                continue;
            }

            // Descubrir la casilla
            descubierto[fila][columna] = true;

            if (tablero[fila][columna] == -1) {
                System.out.println("¡Pisaste una mina! Fin del juego.");
                juegoTerminado = true;
            } else {
                System.out.println("¡Casilla segura!");
                casillasPorDescubrir--;

                // Descubrir automáticamente casillas vacías adyacentes
                if (tablero[fila][columna] == 0) {
                    descubrirVacias(fila, columna, tablero, descubierto);
                }
            }
        }

        if (!juegoTerminado) {
            System.out.println("¡Felicidades! Descubriste todas las casillas sin minas.");
        }

        // Mostrar el tablero completo al final
        System.out.println("Tablero final:");
        imprimirTableroFinal(tablero);
    }

    // Método para imprimir el tablero durante el juego
    private static void imprimirTablero(boolean[][] descubierto, int[][] tablero) {
        System.out.println("Tablero:");
        for (int i = 0; i < descubierto.length; i++) {
            for (int j = 0; j < descubierto[i].length; j++) {
                if (descubierto[i][j]) {
                    if (tablero[i][j] == -1) {
                        System.out.print("* "); // Mina
                    } else {
                        System.out.print(tablero[i][j] + " "); // Número de minas cercanas
                    }
                } else {
                    System.out.print("? "); // Casilla sin descubrir
                }
            }
            System.out.println();
        }
    }

    // Método para imprimir el tablero completo al final
    private static void imprimirTableroFinal(int[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == -1) {
                    System.out.print("* "); // Mina
                } else {
                    System.out.print(tablero[i][j] + " "); // Número de minas cercanas
                }
            }
            System.out.println();
        }
    }

    // Método para descubrir casillas vacías y sus adyacentes
    private static void descubrirVacias(int fila, int columna, int[][] tablero, boolean[][] descubierto) {
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                int nuevaFila = fila + x;
                int nuevaColumna = columna + y;
                if (nuevaFila >= 0 && nuevaFila < tablero.length && nuevaColumna >= 0 && nuevaColumna < tablero[0].length && !descubierto[nuevaFila][nuevaColumna] && tablero[nuevaFila][nuevaColumna] != -1) {
                    descubierto[nuevaFila][nuevaColumna] = true;
                    if (tablero[nuevaFila][nuevaColumna] == 0) {
                        descubrirVacias(nuevaFila, nuevaColumna, tablero, descubierto);
                    }
                }
            }
        }
    }
}
