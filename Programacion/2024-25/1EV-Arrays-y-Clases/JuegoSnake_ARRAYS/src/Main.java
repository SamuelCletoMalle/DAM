import java.util.Scanner;
import java.util.Random;

public class SnakeGame {
    public static void main(String[] args) {
        final int TAMANIO = 10; // Tamaño del tablero
        char[][] tablero = new char[TAMANIO][TAMANIO]; // Tablero de juego
        int[] cabeza = {TAMANIO / 2, TAMANIO / 2}; // Posición inicial de la cabeza de la serpiente
        int[][] cuerpo = new int[TAMANIO * TAMANIO][2]; // Coordenadas del cuerpo de la serpiente
        int longitud = 1; // Longitud inicial de la serpiente
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        // Colocar la serpiente inicial
        cuerpo[0] = cabeza.clone();
        colocarComida(tablero, random);

        boolean juegoTerminado = false;

        while (!juegoTerminado) {
            imprimirTablero(tablero, cuerpo, longitud);
            System.out.print("Introduce movimiento (W: Arriba, A: Izquierda, S: Abajo, D: Derecha): ");
            char movimiento = sc.next().toUpperCase().charAt(0);

            // Calcular nueva posición de la cabeza
            int nuevaFila = cabeza[0];
            int nuevaColumna = cabeza[1];
            switch (movimiento) {
                case 'W': nuevaFila--; break; // Arriba
                case 'A': nuevaColumna--; break; // Izquierda
                case 'S': nuevaFila++; break; // Abajo
                case 'D': nuevaColumna++; break; // Derecha
                default:
                    System.out.println("Movimiento no válido. Intenta nuevamente.");
                    continue;
            }

            // Verificar colisión
            if (nuevaFila < 0 || nuevaFila >= TAMANIO || nuevaColumna < 0 || nuevaColumna >= TAMANIO) {
                System.out.println("¡Chocaste contra el borde! Fin del juego.");
                juegoTerminado = true;
                break;
            }
            for (int i = 0; i < longitud; i++) {
                if (cuerpo[i][0] == nuevaFila && cuerpo[i][1] == nuevaColumna) {
                    System.out.println("¡Chocaste contra ti mismo! Fin del juego.");
                    juegoTerminado = true;
                    break;
                }
            }
            if (juegoTerminado) break;

            // Mover la serpiente
            cabeza[0] = nuevaFila;
            cabeza[1] = nuevaColumna;

            // Verificar si come comida
            if (tablero[nuevaFila][nuevaColumna] == 'C') {
                longitud++;
                colocarComida(tablero, random);
            } else {
                // Mover el cuerpo
                for (int i = longitud - 1; i > 0; i--) {
                    cuerpo[i] = cuerpo[i - 1].clone();
                }
            }
            cuerpo[0] = cabeza.clone(); // Actualizar cabeza
        }
        System.out.println("¡Gracias por jugar!");
    }

    // Método para imprimir el tablero
    private static void imprimirTablero(char[][] tablero, int[][] cuerpo, int longitud) {
        // Limpiar tablero
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = ' ';
            }
        }

        // Dibujar comida y serpiente
        tablero[cuerpo[0][0]][cuerpo[0][1]] = 'O'; // Cabeza de la serpiente
        for (int i = 1; i < longitud; i++) {
            tablero[cuerpo[i][0]][cuerpo[i][1]] = 'o'; // Cuerpo de la serpiente
        }

        // Imprimir tablero
        System.out.println("Tablero:");
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print("|" + tablero[i][j]);
            }
            System.out.println("|");
        }
    }

    // Método para colocar comida aleatoriamente
    private static void colocarComida(char[][] tablero, Random random) {
        int fila, columna;
        do {
            fila = random.nextInt(tablero.length);
            columna = random.nextInt(tablero[0].length);
        } while (tablero[fila][columna] != ' '); // Evitar colocar comida donde ya hay cuerpo
        tablero[fila][columna] = 'C'; // C: Comida
    }
}
