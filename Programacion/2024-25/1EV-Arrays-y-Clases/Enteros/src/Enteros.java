import java.util.Scanner;

public class Enteros {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Indique el primer número entero: ");
        int n1 = scanner.nextInt();
        System.out.print("Indique el segundo número entero: ");
        int n2 = scanner.nextInt();
        System.out.print("Indique el tercer número entero: ");
        int n3 = scanner.nextInt();

        int mayor = encontrarMayor(n1, n2, n3);


        scanner.close();
    }


    public static int encontrarMayor(int n1, int n2, int n3) {
        int mayor = n1;

        if (n2 > mayor) {
            mayor = n2;
        }

        if (n3 > mayor) {
            mayor = n3;
        }

        return mayor;
    }
}
