import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[20];
        int count = 0;
        int suma = 0;

        System.out.println("Introduce números positivos (termina con un número negativo):");
        while (count < 20) {
            int num = sc.nextInt();
            if (num < 0) break;
            numeros[count++] = num;
            suma += num;
        }

        if (count == 0) {
            System.out.println("No se introdujeron números.");
            return;
        }

        double media = (double) suma / count;
        System.out.println("Media: " + media);

        int sumaMayores = 0;
        System.out.print("Números mayores a la media: ");
        for (int i = 0; i < count; i++) {
            if (numeros[i] > media) {
                System.out.print(numeros[i] + " ");
                sumaMayores += numeros[i];
            }
        }
        System.out.println("\nSuma de números mayores a la media: " + sumaMayores);
    }
}
