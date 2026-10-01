import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Cliente {
    int id;
    String nombre;
    String tipoHabitacion;

    public Cliente(int id, String nombre, String tipoHabitacion) {
        this.id = id;
        this.nombre = nombre;
        this.tipoHabitacion = tipoHabitacion;
    }
}

class Habitacion {
    int numero;
    String tipo;
    double tarifa;
    Cliente cliente;

    public Habitacion(int numero, String tipo, double tarifa) {
        this.numero = numero;
        this.tipo = tipo;
        this.tarifa = tarifa;
    }

    public boolean estaDisponible() {
        return cliente == null;
    }

    public void asignarCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void liberar() {
        this.cliente = null;
    }
}

class Hotel {
    List<Habitacion> habitaciones;
    int siguienteIdCliente = 1;

    public Hotel() {
        habitaciones = new ArrayList<>();
        habitaciones.add(new Habitacion(101, "Individual", 50.0));
        habitaciones.add(new Habitacion(102, "Doble", 80.0));
        habitaciones.add(new Habitacion(201, "Suite", 150.0));
        habitaciones.add(new Habitacion(202, "Suite", 150.0));
    }

    public Cliente registrarCliente(String nombre, String tipoHabitacion) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.estaDisponible() && habitacion.tipo.equalsIgnoreCase(tipoHabitacion)) {
                Cliente cliente = new Cliente(siguienteIdCliente++, nombre, tipoHabitacion);
                habitacion.asignarCliente(cliente);
                return cliente;
            }
        }
        return null;
    }

    public void liberarHabitacion(int clienteId) {
        for (Habitacion habitacion : habitaciones) {
            if (!habitacion.estaDisponible() && habitacion.cliente.id == clienteId) {
                habitacion.liberar();
                return;
            }
        }
    }

    public void mostrarHabitacionesLibres() {
        boolean hayLibres = false;
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.estaDisponible()) {
                System.out.println("Habitación " + habitacion.numero + " (" + habitacion.tipo + ") está libre. Tarifa: $" + habitacion.tarifa);
                hayLibres = true;
            }
        }
        if (!hayLibres) {
            System.out.println("No hay habitaciones libres.");
        }
    }

    public void listarClientes() {
        for (Habitacion habitacion : habitaciones) {
            if (!habitacion.estaDisponible()) {
                System.out.println("Cliente: " + habitacion.cliente.nombre + ", ID: " + habitacion.cliente.id + ", Tipo de habitación: " + habitacion.tipo);
            }
        }
    }
}

public class GestionHotel {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú de Gestión del Hotel:");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Liberar habitación");
            System.out.println("3. Mostrar habitaciones libres");
            System.out.println("4. Listar clientes");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Tipo de habitación (Individual/Doble/Suite): ");
                    String tipoHabitacion = scanner.nextLine();
                    Cliente nuevoCliente = hotel.registrarCliente(nombre, tipoHabitacion);
                    if (nuevoCliente != null) {
                        System.out.println("Cliente registrado con ID: " + nuevoCliente.id);
                    } else {
                        System.out.println("No hay habitaciones disponibles para el tipo solicitado.");
                    }
                    break;

                case 2:
                    System.out.print("Introduce el ID del cliente para liberar la habitación: ");
                    int clienteId = scanner.nextInt();
                    hotel.liberarHabitacion(clienteId);
                    System.out.println("Habitación liberada.");
                    break;

                case 3:
                    System.out.println("Habitaciones disponibles:");
                    hotel.mostrarHabitacionesLibres();
                    break;

                case 4:
                    System.out.println("Clientes registrados:");
                    hotel.listarClientes();
                    break;

                case 0:
                    System.out.println("Saliendo de la aplicación.");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}