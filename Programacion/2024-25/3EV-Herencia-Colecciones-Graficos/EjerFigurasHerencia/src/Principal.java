 import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Pila pila = new Pila();
        Random random = new Random();

        // Insertar 2 Cuadrados y 1 Círculo
        ColorRGB color = new ColorRGB(255, 0, 0); // Color rojo para los cuadrados
        int grosor = 2; // Grosor para los cuadrados

        // Crear y agregar dos cuadrados
        Cuadrado cuadrado1 = new Cuadrado(new Punto(random.nextDouble() * 10, random.nextDouble() * 10),
                new Punto(random.nextDouble() * 10, random.nextDouble() * 10),
                new Punto(random.nextDouble() * 10, random.nextDouble() * 10),
                new Punto(random.nextDouble() * 10, random.nextDouble() * 10),
                grosor, color);
        pila.insertar(cuadrado1);

        Cuadrado cuadrado2 = new Cuadrado(new Punto(random.nextDouble() * 10, random.nextDouble() * 10),
                new Punto(random.nextDouble() * 10, random.nextDouble() * 10),
                new Punto(random.nextDouble() * 10, random.nextDouble() * 10),
                new Punto(random.nextDouble() * 10, random.nextDouble() * 10),
                grosor, color);
        pila.insertar(cuadrado2);

        // Crear y agregar un círculo
        Circulo circulo = new Circulo(new Punto(random.nextDouble() * 10, random.nextDouble() * 10),
                random.nextDouble() * 10,
                grosor, color);
        pila.insertar(circulo);

        // Extraer 2 elementos
        ItfFigura figura1 = pila.recuperar();
        ItfFigura figura2 = pila.recuperar();

        // Añadir un Triángulo
        Triangulo triangulo = new Triangulo(new Punto(random.nextDouble() * 10, random.nextDouble() * 10),
                new Punto(random.nextDouble() * 10, random.nextDouble() * 10),
                new Punto(random.nextDouble() * 10, random.nextDouble() * 10),
                grosor, color);
        pila.insertar(triangulo);

        // Sacar todos los elementos restantes y mostrarlos
        while (!pila.estaVacia()) {
            ItfFigura figura = pila.recuperar();
            System.out.println(figura.toString());
        }
    }
}{
}
