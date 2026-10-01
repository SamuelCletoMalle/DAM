import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[10];
        System.out.println("Introduce 10 números para el array:");
        for (int i = 0; i < 10; i++) {
            array[i] = sc.nextInt();
        }

        System.out.print("Introduce el número de posiciones a rotar: ");
        int k = sc.nextInt();
        k = k % 10; // En caso de que k sea mayor que 10

        int[] rotated = new int[10];
        for (int i = 0; i < 10; i++) {
            rotated[(i + k) % 10] = array[i];
        }

        System.out.println("Array rotado:");
        for (int num : rotated) {
            System.out.print(num + " ");
        }
    }
}
