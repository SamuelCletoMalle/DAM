import java.util.Random;
import java.util.Scanner;

public class Ahorcado {
    static final String[] PALABRAS = {
        "programacion", "variable", "herencia", "polimorfismo", "interfaz",
        "excepcion", "compilador", "algoritmo", "recursividad", "coleccion"
    };
    static final int INTENTOS_MAXIMOS = 6;

    static char[] ocultar(String palabra) {
        char[] resultado = new char[palabra.length()];
        for (int i = 0; i < resultado.length; i++) {
            resultado[i] = '_';
        }
        return resultado;
    }

    /** Descubre todas las apariciones de la letra y devuelve cuántas había */
    static int descubrir(String palabra, char[] oculta, char letra) {
        int aciertos = 0;
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra && oculta[i] == '_') {
                oculta[i] = letra;
                aciertos++;
            }
        }
        return aciertos;
    }

    static boolean completa(char[] oculta) {
        for (char c : oculta) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    static void dibujar(int fallos) {
        char brazoIzq = '/';
        char brazoDer = (char) 92;
        System.out.println("  +---+");
        System.out.println("  |   " + (fallos >= 1 ? "O" : ""));
        System.out.println("  |  " + (fallos >= 2 ? brazoIzq : ' ') + (fallos >= 3 ? "|" : "") + (fallos >= 4 ? brazoDer : ""));
        System.out.println("  |  " + (fallos >= 5 ? brazoIzq : ' ') + " " + (fallos >= 6 ? brazoDer : ""));
        System.out.println("======");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palabra = PALABRAS[new Random().nextInt(PALABRAS.length)];
        char[] oculta = ocultar(palabra);
        StringBuilder usadas = new StringBuilder();
        int fallos = 0;

        while (fallos < INTENTOS_MAXIMOS && !completa(oculta)) {
            System.out.println();
            System.out.println("Palabra: " + new String(oculta));
            System.out.println("Letras usadas: " + usadas + "  Fallos: " + fallos + "/" + INTENTOS_MAXIMOS);
            System.out.print("Letra: ");
            String entrada = sc.nextLine().trim().toLowerCase();
            if (entrada.length() != 1 || !Character.isLetter(entrada.charAt(0))) {
                System.out.println("Escribe solo una letra");
                continue;
            }
            char letra = entrada.charAt(0);
            if (usadas.indexOf(String.valueOf(letra)) >= 0) {
                System.out.println("Esa letra ya la has probado");
                continue;
            }
            usadas.append(letra);
            if (descubrir(palabra, oculta, letra) == 0) {
                fallos++;
                dibujar(fallos);
            }
        }

        System.out.println();
        if (completa(oculta)) {
            System.out.println("¡Ganaste! La palabra era " + palabra);
        } else {
            System.out.println("Has perdido. La palabra era " + palabra);
        }
    }
}
