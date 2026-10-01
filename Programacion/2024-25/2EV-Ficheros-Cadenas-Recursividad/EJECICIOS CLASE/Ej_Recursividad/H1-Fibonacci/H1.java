import java.util.Scanner;

public class H1 {

    // Método para calcular el n-ésimo término de la secuencia de Fibonacci
    int calcularTerminoNsimo(int n) {
        if (n <= 0) return 0; // Caso base para n = 0
        if (n == 1) return 1; // Caso base para n = 1

        int num1 = 0; // F(0)
        int num2 = 1; // F(1)
        int resultado = 0;

        // Calcular el n-ésimo término
        for (int i = 2; i <= n; i++) {
            resultado = num1 + num2; // F(n) = F(n-1) + F(n-2)
            num1 = num2; // Actualizar F(n-2)
            num2 = resultado; // Actualizar F(n-1)
        }
        return resultado; // Retornar el n-ésimo término
    }

    public static void main(String[] args) {
        H1 h1 = new H1(); // Crear una instancia de la clase H1
        Scanner sc = new Scanner(System.in); // Crear un objeto Scanner para leer la entrada del usuario
        System.out.println("Da un número: "); // Solicitar al usuario que ingrese un número
        int n = sc.nextInt(); // Leer el número ingresado
        System.out.println("El término n-ésimo de Fibonacci es: " + h1.calcularTerminoNsimo(n)); // Calcular y mostrar el término n-ésimo
    }
}