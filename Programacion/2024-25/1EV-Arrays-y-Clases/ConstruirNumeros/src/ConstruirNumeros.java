import java.util.Scanner;

public class ConstruirNumeros {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nOrden = 0;
        int nInverso = 0;
        int digito;



        System.out.println("Introduce dígitos de un solo dígito. Introduce 0 para terminar:");

        while (true) {
            digito = scanner.nextInt();


            if (digito == 0) break;


            nOrden = nOrden * 10 + digito;


            nInverso = digito + nInverso * 10;
        }

        scanner.close();


        System.out.println("Número en orden de entrada: " + nOrden);
        System.out.println("Número en orden inverso: " + nInverso);
    }
}
