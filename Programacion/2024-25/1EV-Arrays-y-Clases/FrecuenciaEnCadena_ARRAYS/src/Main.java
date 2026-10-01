import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una cadena: ");
        String cadena = sc.nextLine();

        HashMap<Character, Integer> frecuencia = new HashMap<>();
        for (char c : cadena.toCharArray()) {
            if (c != ' ') {
                frecuencia.put(c, frecuencia.getOrDefault(c, 0) + 1);
            }
        }

        System.out.println("Frecuencia de caracteres:");
        for (char c : frecuencia.keySet()) {
            System.out.println(c + ": " + frecuencia.get(c));
        }
    }
}
