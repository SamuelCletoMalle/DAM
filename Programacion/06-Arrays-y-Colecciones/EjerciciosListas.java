import java.util.Arrays;
import java.util.List;

public class EjerciciosListas {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1, 22, 3, 44, 15, 6, 27, 28, 19, 10);

        System.out.println("Mostrando lista");
        imprimirTodos(lista);

        System.out.println("Mostrando numeros pares:");
        imprimirPares(lista);

        System.out.println("Mostrando numeros pares ordenados:");
        imprimirParesOrdenados(lista);

        System.out.println("Suma de numeros de 2 dígitos:");
        sumarDosDigitos(lista);

        System.out.println("Conteo de numeros de 2 dígitos: ");
        contarDosDigitos(lista);
    }


    public static void imprimirTodos(List<Integer> lista) {
        lista.forEach(n -> System.out.print(n + " "));
        System.out.println();
    }


    public static void imprimirPares(List<Integer> lista) {
        lista.stream()
                .filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
    }


    public static void imprimirParesOrdenados(List<Integer> lista) {
        lista.stream()
                .filter(n -> n % 2 == 0)
                .sorted()
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
    }


    public static void sumarDosDigitos(List<Integer> lista) {
        int suma = lista.stream()
                .filter(n -> (n >= 10 && n <= 99) || (n <= -10 && n >= -99))
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("La suma es: " + suma);
    }


    public static void contarDosDigitos(List<Integer> lista) {
        long conteo = lista.stream()
                .filter(n -> (n >= 10 && n <= 99) || (n <= -10 && n >= -99))
                .count();
        System.out.println("Cantidad de números con 2 dígitos: " + conteo);
    }
}
