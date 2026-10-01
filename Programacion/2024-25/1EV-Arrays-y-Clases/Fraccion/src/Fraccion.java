public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Fraccion multiplicar(Fraccion otra) {
        int nuevoNumerador = this.numerador * otra.numerador;
        int nuevoDenominador = this.denominador * otra.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public boolean esMayorQue(Fraccion otra) {
        int numerador1 = this.numerador * otra.denominador;
        int numerador2 = otra.numerador * this.denominador;

        return numerador1 > numerador2;
    }

    public String mostrarFraccion() {
        return numerador + "/" + denominador;
    }

    public static void main(String[] args) {
        Fraccion fraccion1 = new Fraccion(2, 5);
        Fraccion fraccion2 = new Fraccion(4, 5);

        System.out.println("Fracción 1: " + fraccion1.mostrarFraccion());
        System.out.println("Fracción 2: " + fraccion2.mostrarFraccion());

        Fraccion resultadoMultiplicacion = fraccion1.multiplicar(fraccion2);
        System.out.println("Multiplicación: " + fraccion1.mostrarFraccion() + " * " + fraccion2.mostrarFraccion() + " = " + resultadoMultiplicacion.mostrarFraccion());

        if (fraccion1.esMayorQue(fraccion2)) {
            System.out.println(fraccion1.mostrarFraccion() + " es mayor que " + fraccion2.mostrarFraccion());
        } else {
            System.out.println(fraccion2.mostrarFraccion() + " es mayor o igual que " + fraccion1.mostrarFraccion());
        }
    }
}
