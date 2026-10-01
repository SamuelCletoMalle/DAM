import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class UsoFiguras {
    private ArrayList<ItfFigura> figuras;
 //   Figura vFiguras[]= new Figura[15];
    private static final int MAX_FIGURAS = 10;
    private Random random = new Random();
    public UsoFiguras() {
        figuras = new ArrayList<>();
    }

    public void agregarFigura() {
        if (figuras.size() >= MAX_FIGURAS) {
            System.out.println("No se pueden agregar más figuras.");
        }else {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Elige el tipo de figura: 1. Cuadrado, 2. Círculo, 3. Triángulo");
	        int opcion = sc.nextInt();
	        int grosor = random.nextInt(5) + 1;  // Grosor entre 1 y 5
	
	        switch (opcion) {
	            case 1: 
	                Punto esquina1 = new Punto(random.nextDouble() * 10, random.nextDouble() * 10);
	                Punto esquina2 = new Punto(random.nextDouble() * 10, random.nextDouble() * 10);
                  Punto esquina3 = new Punto(random.nextDouble() * 10, random.nextDouble() * 10);
                  Punto esquina4 = new Punto(random.nextDouble() * 10, random.nextDouble() * 10);
                  //Podría ser una referencia de tipo Cuadrado
	                Figura cuadrado = new Cuadrado( esquina1, esquina2, esquina3, esquina4);
	                figuras.add(cuadrado);
	                System.out.println("Figura añadida: " + cuadrado);
	                break;
	            case 2: 
	                Punto centro = new Punto(random.nextDouble() * 10, random.nextDouble() * 10);
                  double radio = Math.random()*10;
	                Punto puntoCircunferencia = new Punto(random.nextDouble() * 10, random.nextDouble() * 10);
	                Circulo circulo = new Circulo( centro, radio);
	                figuras.add(circulo);
	                System.out.println("Figura añadida: " + circulo);
	                break;
	            case 3: 
                	Punto p1 = new Punto(random.nextDouble() * 10, random.nextDouble() * 10);
                	Punto p2 = new Punto(random.nextDouble() * 10, random.nextDouble() * 10);
                	Punto p3 = new Punto(random.nextDouble() * 10, random.nextDouble() * 10);
                	Triangulo triangulo = new Triangulo(grosor, p1, p2, p3);
                	figuras.add(triangulo);
                	System.out.println("Figura añadida: " + triangulo);
                	break;
            	default:
            		System.out.println("Opción no válida.");
        	}
        }
    }

    public void listarFiguras() {
        if (figuras.isEmpty()) {
            System.out.println("No hay figuras añadidas.");
            return;
        }
        System.out.println("Listado de Figuras:");
        for (ItfFigura figura : figuras) {
            System.out.println(figura.toString());
        }
    }
    public void listarPerimetros() {
        if (figuras.isEmpty()) {
            System.out.println("No hay figuras añadidas.");
            return;
        }

        double sumaPerimetros = 0;
        System.out.println("Perímetros de las Figuras:");
        for (ItfFigura figura : figuras) {
            double perimetro = figura.calcularPerimetro();
            System.out.println(figura + " - Perímetro: " + perimetro);
            sumaPerimetros += perimetro;
        }

        System.out.println("Suma de todos los perímetros: " + sumaPerimetros);
    }

    public void modificarGrosor() {
        if (figuras.isEmpty()) {
            System.out.println("No hay figuras para modificar.");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nuevo grosor para todas las figuras:");
        int nuevoGrosor = sc.nextInt();

        for (ItfFigura figura : figuras) {
            figura.setGrosor(nuevoGrosor);
        }

        System.out.println("El grosor ha sido modificado para todas las figuras.");
    }

    public static void main(String[] args) {
        UsoFiguras usoFiguras = new UsoFiguras();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menu:");
            System.out.println("1. Añadir figura");
            System.out.println("2. Listar figuras");
            System.out.println("3. Listar perímetros");
            System.out.println("4. Modificar grosor");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    usoFiguras.agregarFigura();
                    break;
                case 2:
                    usoFiguras.listarFiguras();
                    break;
                case 3:
                    usoFiguras.listarPerimetros();
                    break;
                case 4:
                    usoFiguras.modificarGrosor();
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}