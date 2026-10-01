import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array1 = new int[10];
        int[] array2 = new int[10];
        System.out.println("Introduce 10 números para el primer array:");
        for (int i = 0; i < 10; i++) {
            array1[i] = sc.nextInt();
        }

        System.out.println("Introduce 10 números para el segundo array:");
        for (int i = 0; i < 10; i++) {
            array2[i] = sc.nextInt();
        }

        ArrayList<Integer> comunes = new ArrayList<>();
        ArrayList<Integer> unicosArray1 = new ArrayList<>();
        ArrayList<Integer> unicosArray2 = new ArrayList<>();

        for (int num1 : array1) {
            boolean esComun = false;
            for (int num2 : array2) {
                if (num1 == num2) {
                    esComun = true;
                    if (!comunes.contains(num1)) comunes.add(num1);
                }
            }
            if (!esComun && !unicosArray1.contains(num1)) unicosArray1.add(num1);
        }

        for (int num2 : array2) {
            boolean esComun = false;
            for (int num1 : array1) {
                if (num2 == num1) {
                    esComun = true;
                }
            }
            if (!esComun && !unicosArray2.contains(num2)) unicosArray2.add(num2);
        }

        System.out.println("Elementos comunes: " + comunes);
        System.out.println("Únicos en Array 1: " + unicosArray1);
        System.out.println("Únicos en Array 2: " + unicosArray2);
    }
}
