/**
 * Pruebas de la clase Calculadora sin librerías externas.
 * Mismo esquema que JUnit (preparar, ejecutar, comprobar), pero con un mini ejecutor propio.
 * Se ejecuta con: java CalculadoraTest
 */
public class CalculadoraTest {
    private static int pasadas = 0;
    private static int falladas = 0;

    interface Prueba {
        void ejecutar() throws Exception;
    }

    static void prueba(String nombre, Prueba p) {
        try {
            p.ejecutar();
            pasadas++;
            System.out.println("[OK]    " + nombre);
        } catch (Throwable e) {
            falladas++;
            System.out.println("[FALLO] " + nombre + " -> " + e.getMessage());
        }
    }

    static void assertIgual(Object esperado, Object obtenido) {
        if (!esperado.equals(obtenido)) {
            throw new AssertionError("esperado " + esperado + " pero fue " + obtenido);
        }
    }

    static <T extends Throwable> void assertLanza(Class<T> tipo, Prueba p) {
        try {
            p.ejecutar();
        } catch (Throwable e) {
            if (tipo.isInstance(e)) {
                return;
            }
            throw new AssertionError("se esperaba " + tipo.getSimpleName() + " pero fue " + e);
        }
        throw new AssertionError("se esperaba " + tipo.getSimpleName() + " y no hubo excepción");
    }

    public static void main(String[] args) {
        Calculadora c = new Calculadora();

        prueba("sumar positivos", () -> assertIgual(7, c.sumar(3, 4)));
        prueba("sumar con negativos", () -> assertIgual(-1, c.sumar(-3, 2)));
        prueba("restar", () -> assertIgual(5, c.restar(9, 4)));
        prueba("multiplicar por cero", () -> assertIgual(0, c.multiplicar(8, 0)));
        prueba("dividir con decimales", () -> assertIgual(2.5, c.dividir(5, 2)));
        prueba("dividir entre cero lanza excepcion", () -> assertLanza(ArithmeticException.class, () -> c.dividir(1, 0)));
        prueba("el 2 es primo", () -> assertIgual(true, c.esPrimo(2)));
        prueba("el 1 no es primo", () -> assertIgual(false, c.esPrimo(1)));
        prueba("el 97 es primo", () -> assertIgual(true, c.esPrimo(97)));
        prueba("el 100 no es primo", () -> assertIgual(false, c.esPrimo(100)));
        prueba("factorial de 0", () -> assertIgual(1L, c.factorial(0)));
        prueba("factorial de 5", () -> assertIgual(120L, c.factorial(5)));
        prueba("factorial negativo lanza excepcion", () -> assertLanza(IllegalArgumentException.class, () -> c.factorial(-1)));

        System.out.println();
        System.out.println("Pasadas: " + pasadas + "  Falladas: " + falladas);
        if (falladas > 0) {
            System.exit(1);
        }
    }
}
