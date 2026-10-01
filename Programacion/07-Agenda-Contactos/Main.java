import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Agenda agenda = new Agenda("agenda.txt");
        try {
            agenda.cargar();
        } catch (IOException e) {
            System.out.println("No se pudo leer la agenda: " + e.getMessage());
        }

        int opcion;
        do {
            System.out.println("\n===== AGENDA =====");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Buscar por nombre");
            System.out.println("3. Buscar por prefijo");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Listar (orden alfabético)");
            System.out.println("0. Guardar y salir");
            System.out.print("Opción: ");
            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine().trim();
                    System.out.print("Teléfono (9 dígitos): ");
                    String tel = sc.nextLine().trim();
                    System.out.print("Email: ");
                    String email = sc.nextLine().trim();
                    System.out.println(agenda.anadir(new Contacto(nombre, tel, email))
                            ? "Contacto añadido" : "No se pudo añadir (repetido o teléfono no válido)");
                    break;
                case 2:
                    System.out.print("Nombre: ");
                    Contacto c = agenda.buscar(sc.nextLine().trim());
                    System.out.println(c != null ? c : "No existe ese contacto");
                    break;
                case 3:
                    System.out.print("Prefijo: ");
                    List<Contacto> encontrados = agenda.buscarPorPrefijo(sc.nextLine().trim());
                    encontrados.forEach(System.out::println);
                    System.out.println(encontrados.size() + " resultado(s)");
                    break;
                case 4:
                    System.out.print("Nombre a eliminar: ");
                    System.out.println(agenda.eliminar(sc.nextLine().trim()) ? "Eliminado" : "No existe ese contacto");
                    break;
                case 5:
                    agenda.listar();
                    break;
                case 0:
                    try {
                        agenda.guardar();
                        System.out.println("Agenda guardada (" + agenda.size() + " contactos). ¡Hasta pronto!");
                    } catch (IOException e) {
                        System.out.println("Error al guardar: " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }
}
