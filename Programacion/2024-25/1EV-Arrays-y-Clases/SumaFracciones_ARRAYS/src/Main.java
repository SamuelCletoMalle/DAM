import java.util.Random;

class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public Fraccion sumar(Fraccion otra) {
        int nuevoNumerador = this.numerador * otra.denominador + otra.numerador * this.denominador;
        int nuevoDenominador = this.denominador * otra.denominador;
        return simplificar(new Fraccion(nuevoNumerador, nuevoDenominador));
    }

    private Fraccion simplificar(Fraccion fraccion) {
        int mcd = calcularMCD(fraccion.numerador, fraccion.denominador);
        return new Fraccion(fraccion.numerador / mcd, fraccion.denominador / mcd);
    }

    private int calcularMCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public void imprimir() {
        System.out.println(numerador + "/" + denominador);
    }
}

public class SumaFracciones {
    private Fraccion[] fracciones;

    public SumaFracciones() {
        fracciones = new Fraccion[10];
        Random random = new Random();

        for (int i = 0; i < fracciones.length; i++) {
            int numerador = random.nextInt(10) + 1;
            int denominador = random.nextInt(10) + 1;
            fracciones[i] = new Fraccion(numerador, denominador);
        }
    }

    public Fraccion sumarTodas() {
        Fraccion suma = new Fraccion(0, 1);
        for (Fraccion fraccion : fracciones) {
            suma = suma.sumar(fraccion);
        }
        return suma;
    }

    public static void main(String[] args) {
        SumaFracciones sumaFracciones = new SumaFracciones();

        System.out.println("Fracciones generadas:");
        for (Fraccion fraccion : sumaFracciones.fracciones) {
            fraccion.imprimir();
        }

        Fraccion resultado = sumaFracciones.sumarTodas();
        System.out.println("Suma total de las fracciones:");
        resultado.imprimir();
    }
}
