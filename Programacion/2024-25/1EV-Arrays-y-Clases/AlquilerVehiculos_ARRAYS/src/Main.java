import java.util.Scanner;

class Vehiculo {
    private String matricula;
    private String modelo;
    private double precioPorDia;
    private int vecesAlquilado;

    public Vehiculo(String matricula, String modelo, double precioPorDia) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.precioPorDia = precioPorDia;
        this.vecesAlquilado = 0;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getPrecioPorDia() {
        return precioPorDia;
    }

    public void incrementarAlquiler() {
        vecesAlquilado++;
    }

    public int getVecesAlquilado() {
        return vecesAlquilado;
    }

    public String getModelo() {
        return modelo;
    }
}

class Cliente {
    private int id;
    private int numeroDeAlquileres;

    public Cliente(int id) {
        this.id = id;
        this.numeroDeAlquileres = 0;
    }

    public int getId() {
        return id;
    }

    public void incrementarAlquileres() {
        numeroDeAlquileres++;
    }

    public int getNumeroDeAlquileres() {
        return numeroDeAlquileres;
    }
}

class EmpresaAlquiler {
    private Vehiculo[] vehiculos = new Vehiculo[100];
    private Cliente[] clientes = new Cliente[100];
    private int numVehiculos = 0;
    private int numClientes = 0;

    public void altaVehiculo(String matricula, String modelo, double precioPorDia) {
        for (int i = 0; i < numVehiculos; i++) {
            if (vehiculos[i].getMatricula().equals(matricula)) {
                System.out.println("El vehículo ya está registrado.");
                return;
            }
        }
        vehiculos[numVehiculos++] = new Vehiculo(matricula, modelo, precioPorDia);
        System.out.println("Vehículo registrado con éxito.");
    }

    public void altaCliente(int id) {
        for (int i = 0; i < numClientes; i++) {
            if (clientes[i].getId() == id) {
                System.out.println("El cliente ya está registrado.");
                return;
            }
        }
        clientes[numClientes++] = new Cliente(id);
        System.out.println("Cliente registrado con éxito.");
    }

    public void registrarAlquiler(int idCliente, String matricula, int dias) {
        Cliente cliente = null;
        Vehiculo vehiculo = null;

        for (int i = 0; i < numClientes; i++) {
            if (clientes[i].getId() == idCliente) {
                cliente = clientes[i];
                break;
            }
        }
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        for (int i = 0; i < numVehiculos; i++) {
            if (vehiculos[i].getMatricula().equals(matricula)) {
                vehiculo = vehiculos[i];
                break;
            }
        }
        if (vehiculo == null) {
            System.out.println("Vehículo no encontrado.");
            return;
        }

        double coste = vehiculo.getPrecioPorDia() * dias;
        cliente.incrementarAlquileres();
        vehiculo.incrementarAlquiler();
        System.out.println("Alquiler registrado: Cliente " + idCliente + " ha alquilado el vehículo " + matricula +
                " (" + vehiculo.getModelo() + ") por " + dias + " días. Coste total: " + coste + "€.");
    }

    public void clienteConMasAlquileres() {
        Cliente maxCliente = null;
        int maxAlquileres = 0;

        for (int i = 0; i < numClientes; i++) {
            if (clientes[i].getNumeroDeAlquileres() > maxAlquileres) {
                maxAlquileres = clientes[i].getNumeroDeAlquileres();
                maxCliente = clientes[i];
            }
        }

        if (maxCliente != null) {
            System.out.println("Cliente con más alquileres: ID " + maxCliente.getId() +
                    " con " + maxAlquileres + " alquileres.");
        } else {
            System.out.println("No hay clientes registrados.");
        }
    }

    public void vehiculoMasAlquilado() {
        Vehiculo maxVehiculo = null;
        int maxVeces = 0;

        for (int i = 0; i < numVehiculos; i++) {
            if (vehiculos[i].getVecesAlquilado() > maxVeces) {
                maxVeces = vehiculos[i].getVecesAlquilado();
                maxVehiculo = vehiculos[i];
            }
        }

        if (maxVehiculo != null) {
            System.out.println("Vehículo más alquilado: Matrícula " + maxVehiculo.getMatricula() +
                    " (" + maxVehiculo.getModelo() + ") con " + maxVeces + " alquileres.");
        } else {
            System.out.println("No hay vehículos registrados.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        EmpresaAlquiler empresa = new EmpresaAlquiler();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Alta Vehículo");
            System.out.println("2. Alta Cliente");
            System.out.println("3. Registrar Alquiler");
            System.out.println("4. Cliente con más alquileres");
            System.out.println("5. Vehículo más alquilado");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Matrícula: ");
                    String matricula = sc.next();
                    System.out.print("Modelo: ");
                    String modelo = sc.next();
                    System.out.print("Precio por día: ");
                    double precio = sc.nextDouble();
                    empresa.altaVehiculo(matricula, modelo, precio);
                    break;
                case 2:
                    System.out.print("ID Cliente: ");
                    int idCliente = sc.nextInt();
                    empresa.altaCliente(idCliente);
                    break;
                case 3:
                    System.out.print("ID Cliente: ");
                    idCliente = sc.nextInt();
                    System.out.print("Matrícula del vehículo: ");
                    matricula = sc.next();
                    System.out.print("Días de alquiler: ");
                    int dias = sc.nextInt();
                    empresa.registrarAlquiler(idCliente, matricula, dias);
                    break;
                case 4:
                    empresa.clienteConMasAlquileres();
                    break;
                case 5:
                    empresa.vehiculoMasAlquilado();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
        sc.close();
    }
}
