import java.io.BufferedReader; // Para leer texto de manera eficiente
import java.io.BufferedWriter; // Para escribir texto de manera eficiente
import java.io.FileReader; // Para leer archivos
import java.io.FileWriter; // Para escribir archivos
import java.io.IOException; // Para manejar excepciones de entrada/salida
import java.util.ArrayList; // Para almacenar las notas en una lista
import java.util.List; // Para manejar listas
import java.util.Scanner; // Para leer la entrada del usuario

// Clase que representa una nota de un estudiante
class Nota {
    private String nombreEstudiante; // Nombre del estudiante
    private double nota; // Nota del estudiante

    // Constructor
    public Nota(String nombreEstudiante, double nota) {
        this.nombreEstudiante = nombreEstudiante;
        this.nota = nota;
    }

    // Getters
    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public double getNota() {
        return nota;
    }

    // Método para representar la nota como una cadena
    @Override
    public String toString() {
        return nombreEstudiante + "," + nota; // Formato: nombre,nota
    }
}

public class GestionNotas {
    private static final String NOMBRE_ARCHIVO = "notas.txt"; // Nombre del archivo donde se almacenarán las notas

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Crear un objeto Scanner para leer la entrada del usuario
        int opcion;

        // Bucle principal del menú
        do {
            // Mostrar opciones al usuario
            System.out.println("1. Agregar nota");
            System.out.println("2. Modificar nota");
            System.out.println("3. Listar notas");
            System.out.println("4. Eliminar nota");
            System.out.println("5. Buscar nota");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt(); // Leer la opción seleccionada
            scanner.nextLine(); // Limpiar el buffer

            // Ejecutar la opción seleccionada
            switch (opcion) {
                case 1:
                    agregarNota(scanner); // Agregar una nueva nota
                    break;
                case 2:
                    modificarNota(scanner); // Modificar una nota existente
                    break;
                case 3:
                    listarNotas(); // Listar todas las notas
                    break;
                case 4:
                    eliminarNota(scanner); // Eliminar una nota específica
                    break;
                case 5:
                    buscarNota(scanner); // Buscar una nota por el nombre del estudiante
                    break;
                case 0:
                    System.out.println("Saliendo..."); // Mensaje de salida
                    break;
                default:
                    System.out.println("Opción no válida."); // Mensaje de error para opción no válida
            }
        } while (opcion != 0); // Continuar hasta que el usuario elija salir
        scanner.close(); // Cerrar el escáner
    }

    // Método para agregar una nota
    private static void agregarNota(Scanner scanner) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))) { // Abrir el archivo en modo append
            System.out.print("Ingrese el nombre del estudiante: ");
            String nombre = scanner.nextLine(); // Leer el nombre del estudiante
            double nota = 0;
            boolean entradaValida = false;

            // Validar la entrada de la nota
            while (!entradaValida) {
                System.out.print("Ingrese la nota: ");
                try {
                    nota = Double.parseDouble(scanner.nextLine()); // Leer la nota
                    if (nota < 0 || nota > 10) { // Validar que la nota esté en el rango de 0 a 10
                        System.out.println("La nota debe estar entre 0 y 10. Intente de nuevo.");
                    } else {
                        entradaValida = true; // Entrada válida
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Por favor, ingrese un número."); // Manejo de excepciones
                }
            }

            writer.write(new Nota(nombre, nota).toString()); // Escribir la nota en el archivo
            writer.newLine(); // Agregar un salto de línea
            System.out.println("Nota agregada."); // Mensaje de confirmación
        } catch (IOException e) {
            System.out.println("Error al agregar nota: " + e.getMessage()); // Manejo de excepciones
        }
    }

    // Método para modificar una nota
    private static void modificarNota(Scanner scanner) {
        List<Nota> notas = cargarNotas(); // Cargar las notas desde el archivo
        if (notas.isEmpty()) {
            System.out.println("No hay notas para modificar."); // Mensaje si no hay notas
            return;
        }

        // Listar las notas actuales
        System.out.println("Notas actuales:");
        for (int i = 0; i < notas.size(); i++) {
            System.out.println((i + 1) + ". " + notas.get(i)); // Mostrar cada nota con su número
        }

        // Pedir al usuario que seleccione una nota para modificar
        System.out.print("Seleccione el número de la nota a modificar: ");
        int numeroNota = scanner.nextInt(); // Leer el número de la nota a modificar
        scanner.nextLine(); // Limpiar el buffer

        // Verificar si el número de nota es válido
        if (numeroNota < 1 || numeroNota > notas.size()) {
            System.out.println("Número de nota no válido."); // Mensaje de error si el número es inválido
            return;
        }

        // Pedir al usuario que ingrese la nueva nota
        System.out.print("Ingrese el nuevo nombre del estudiante: ");
        String nuevoNombre = scanner.nextLine(); // Leer el nuevo nombre
        double nuevaNota = 0;
        boolean entradaValida = false;

        // Validar la entrada de la nueva nota
        while (!entradaValida) {
            System.out.print("Ingrese la nueva nota: ");
            try {
                nuevaNota = Double.parseDouble(scanner.nextLine()); // Leer la nueva nota
                if (nuevaNota < 0 || nuevaNota > 10) { // Validar que la nueva nota esté en el rango de 0 a 10
                    System.out.println("La nota debe estar entre 0 y 10. Intente de nuevo.");
                } else {
                    entradaValida = true; // Entrada válida
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número."); // Manejo de excepciones
            }
        }

        // Modificar la nota seleccionada
        notas.set(numeroNota - 1, new Nota(nuevoNombre, nuevaNota)); // Reemplazar la línea correspondiente

        // Escribir las notas actualizadas en el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO))) { // Abrir el archivo en modo escritura
            for (int i = 0; i < notas.size(); i++) { // Usar un bucle for tradicional
                writer.write(notas.get(i).toString()); // Escribir cada nota en el archivo
                writer.newLine(); // Agregar un salto de línea
            }
            System.out.println("Nota modificada."); // Mensaje de confirmación
        } catch (IOException e) {
            System.out.println("Error al modificar nota: " + e.getMessage()); // Manejo de excepciones
        }
    }

    // Método para cargar las notas desde el archivo
    private static List<Nota> cargarNotas() {
        List<Nota> notas = new ArrayList<>(); // Lista para almacenar las notas
        try (BufferedReader reader = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) { // Abrir el archivo en modo lectura
            String linea;
            while ((linea = reader.readLine()) != null) { // Leer cada línea del archivo
                String[] partes = linea.split(","); // Dividir la línea en partes
                if (partes.length == 2) { // Verificar que haya dos partes (nombre y nota)
                    String nombreEstudiante = partes[0]; // Obtener el nombre del estudiante
                    double nota = Double.parseDouble(partes[1]); // Obtener la nota
                    notas.add(new Nota(nombreEstudiante, nota)); // Agregar la nota a la lista
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar notas: " + e.getMessage()); // Manejo de excepciones
        }
        return notas; // Devolver la lista de notas
    }

    // Método para listar todas las notas
    private static void listarNotas() {
        List<Nota> notas = cargarNotas(); // Cargar las notas desde el archivo
        if (notas.isEmpty()) {
            System.out.println("No hay notas para mostrar."); // Mensaje si no hay notas
            return;
        }

        // Listar las notas actuales
        System.out.println("Notas actuales:");
        for (int                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       