import java.io.*;

public class ClinicaVeterinaria {
    Teclado t = new Teclado(); // Instancia de la clase Teclado para leer entradas del usuario
    final static String NOMBREFICHERO = "FichClinicaVet.dat"; // Nombre del archivo donde se almacenan los datos de los clientes

    public static void main(String[] args) throws IOException {
        ClinicaVeterinaria cv = new ClinicaVeterinaria(); // Crear una instancia de ClinicaVeterinaria
        cv.menu(); // Llamar al método menu para iniciar la aplicación
    }

    private void menu() throws IOException {
        int opc = 0; // Variable para almacenar la opción seleccionada por el usuario
        do {
            // Mostrar las opciones del menú
            System.out.println("1. Alta cliente");
            System.out.println("2. Modificación cliente");
            System.out.println("3. Baja cliente");
            System.out.println("4. Consultas clientes ");
            System.out.println("5. Listar clientes");
            System.out.println("6. Atender Cliente");
            System.out.println("7. Estadísticas");
            System.out.println("0. Salir");
            System.out.println("Dar opc");
            opc = t.leerInt(); // Leer la opción seleccionada por el usuario
            // Ejecutar la opción correspondiente
            switch (opc) {
                case 1 -> alta(); // Alta de cliente
                case 2 -> modificacion(); // Modificación de cliente
                case 3 -> baja(); // Baja de cliente
                case 4 -> consulta(); // Consulta de cliente
                case 5 -> listarClientes(); // Listar todos los clientes
                case 6 -> atender(); // Atender a un cliente
                case 7 -> estadisticas(); // Mostrar estadísticas
            }
        } while (opc != 0); // Continuar hasta que el usuario elija salir
    }

    private void estadisticas() {
        int gastos[] = new int[11]; // Array para contar los gastos en rangos de 100
        for (int g : gastos) // Inicializar el array a 0
            g = 0;
        int contClientes = 0; // Contador de clientes
        int totGastos = 0; // Total de gastos
        try (RandomAccessFile f = new RandomAccessFile(NOMBREFICHERO, "r")) { // Abrir el archivo en modo lectura
            Cliente c = new Cliente(); // Crear una instancia de Cliente
            boolean hayDatos = c.leer(f); // Leer el primer cliente
            while (hayDatos) { // Mientras haya datos
                if (!c.borrado()) { // Si el cliente no está borrado
                    gastos[(int) (c.gasto / 100)]++; // Incrementar el contador de gastos en el rango correspondiente
                }
                hayDatos = c.leer(f); // Leer el siguiente cliente
            }
            // Escribir las estadísticas en un archivo
            try (BufferedWriter bf = new BufferedWriter(new FileWriter("estadisticas.txt"))) {
                for (int i = 0; i < gastos.length; i++) {
                    String linea = i * 100 + ":" + (i + 1) * 100 + "->" + gastos[i]; // Formato de la línea
                    bf.write(String.valueOf(linea)); // Escribir la línea en el archivo
                    bf.newLine(); // Nueva línea
                }
            }
        } catch (IOException e) {
            System.out.println("Error lectura fichero"); // Manejo de errores
        }
    }

    private void atender() {
        try (RandomAccessFile f = new RandomAccessFile(NOMBREFICHERO, "rw")) { // Abrir el archivo en modo lectura y escritura
            System.out.println("Dar id cliente"); // Solicitar ID del cliente
            int idCliente = t.leerInt(); // Leer el ID del cliente
            if (esValido(idCliente, f)) { // Verificar si el ID es válido
                Cliente c = new Cliente(); // Crear una instancia de Cliente
                irAPosicion(idCliente, f); // Ir a la posición del cliente en el archivo
                boolean hayDatos = c.leer(f); // Leer los datos del cliente
                System.out.println(c); // Mostrar los datos del cliente
                if (!c.borrado()) { // Si el cliente no está borrado
                    c.gasto += 50; // Incrementar el gasto del cliente
                    irAPosicion(idCliente, f); // Ir a la posición del cliente en el archivo
                    c.escribir(f); // Escribir los datos actualizados en el archivo
                }
            } else System.out.println("ID no válido"); // Mensaje de error si el ID no es válido
        } catch (IOException e) {
            System.out.println("Error en el fichero"); // Manejo de errores
        }
    }

    private void consulta() {
        try (RandomAccessFile f = new RandomAccessFile(NOMBREFICHERO, "r")) { // Abrir el archivo en modo lectura
            System.out.println("Dar id cliente"); // Solicitar ID del cliente
            int idCliente = t.leerInt(); // Leer el ID del cliente
            if (esValido(idCliente, f)) { // Verificar si el ID es válido
                Cliente c = new Cliente(); // Crear una instancia de Cliente
                irAPosicion(idCliente, f); // Ir a la posición del cliente en el archivo
                boolean hayDatos = c.leer(f); // Leer los datos del cliente
                if (!c.borrado()) // Si el cliente no está borrado
                    System.out.println(c); // Mostrar los datos del cliente
                else
                    System.out.println("Cliente borrado"); // Mensaje si el cliente está borrado
            } else System.out.println("ID no válido"); // Mensaje de error si el ID no es válido
        } catch (IOException e) {
            System.out.println("Error en el fichero"); // Manejo de errores
        }
    }

    private void baja() {
        try (RandomAccessFile f = new RandomAccessFile(NOMBREFICHERO, "rw")) { // Abrir el archivo en modo lectura y escritura
            System.out.println("Dar id cliente"); // Solicitar ID del cliente
            int idCliente = t.leerInt(); // Leer el ID del cliente
            if (esValido(idCliente, f)) { // Verificar si el ID es válido
                Cliente c = new Cliente(); // Crear una instancia de Cliente
                irAPosicion(idCliente, f); // Ir a la posición del cliente en el archivo
                boolean hayDatos = c.leer(f); // Leer los datos del cliente
                System.out.println(c); // Mostrar los datos del cliente
                System.out.println("Darlo de baja (1.si, 0.no)"); // Preguntar si desea dar de baja al cliente
                int baja = t.leerInt(); // Leer la respuesta
                if (baja == 0) { // Si la respuesta es 0 (no dar de baja)
                    c.idCliente = -1; // Marcar el cliente como borrado
                    irAPosicion(idCliente, f); // Ir a la posición del cliente en el archivo
                    c.escribir(f); // Escribir los datos actualizados en el archivo
                }
            } else System.out.println("ID no válido"); // Mensaje de error si el ID no es válido
        } catch (IOException e) {
            System.out.println("Error en el fichero"); // Manejo de errores
        }
    }

    private void listarClientes() {
        int contClientes = 0; // Contador de clientes
        int totGastos = 0; // Total de gastos
        try (RandomAccessFile f = new RandomAccessFile(NOMBREFICHERO, "r")) { // Abrir el archivo en modo lectura
            Cliente c = new Cliente(); // Crear una instancia de Cliente
            boolean hayDatos = c.leer(f); // Leer el primer cliente
            while (hayDatos) { // Mientras haya datos
                if (!c.borrado()) { // Si el cliente no está borrado
                    System.out.println(c); // Mostrar los datos del cliente
                    contClientes++; // Incrementar el contador de clientes
                    totGastos += c.gasto; // Sumar el gasto del cliente al total
                }
                hayDatos = c.leer(f); // Leer el siguiente cliente
            }
            // Calcular y mostrar la media de gastos
            if (contClientes > 0) {
                System.out.println("Media de gastos de todos los clientes: " + (totGastos / contClientes)); // Mostrar la media
            } else {
                System.out.println("No hay clientes registrados."); // Mensaje si no hay clientes
            }
        } catch (IOException e) {
            System.out.println("Error lectura fichero"); // Manejo de errores
        }
    }

    // Supongo que el fichero ya está abierto
    void irAPosicion(int idCliente, RandomAccessFile f) throws IOException {
        f.seek(idCliente * Cliente.getTamanoRegistro()); // Ir a la posición del cliente en el archivo
    }

    // Supongo que el fichero ya está abierto
    boolean esValido(int idCliente, RandomAccessFile f) throws IOException {
        return ((int) (f.length()) / Cliente.getTamanoRegistro() > idCliente); // Verificar si el ID es válido
    }

    private void modificacion() {
        try (RandomAccessFile f = new RandomAccessFile(NOMBREFICHERO, "rw")) { // Abrir el archivo en modo lectura y escritura
            System.out.println("Dar id cliente"); // Solicitar ID del cliente
            int idCliente = t.leerInt(); // Leer el ID del cliente
            if (esValido(idCliente, f)) { // Verificar si el ID es válido
                Cliente c = new Cliente(); // Crear una instancia de Cliente
                irAPosicion(idCliente, f); // Ir a la posición del cliente en el archivo
                boolean hayDatos = c.leer(f); // Leer los datos del cliente
                System.out.println(c); // Mostrar los datos del cliente
                System.out.println("dar nueva edad"); // Solicitar nueva edad
                int edad = t.leerInt(); // Leer la nueva edad
                c.edadAnimal = edad; // Actualizar la edad del cliente
                irAPosicion(idCliente, f); // Ir a la posición del cliente en el archivo
                c.escribir(f); // Escribir los datos actualizados en el archivo
            } else System.out.println("ID no válido"); // Mensaje de error si el ID no es válido
        } catch (IOException e) {
            System.out.println("Error en el fichero"); // Manejo de errores
        }
    }

    private void alta() throws IOException {
        System.out.println("Dar nombreCliente"); // Solicitar nombre del cliente
        String nombre = t.leerString(); // Leer el nombre del cliente
        try (RandomAccessFile f = new RandomAccessFile(NOMBREFICHERO, "rw")) { // Abrir el archivo en modo lectura y escritura
            if (!buscarEnFichero(nombre, f)) { // Verificar si el cliente ya existe
                System.out.println("Dar nombre Mascota"); // Solicitar nombre de la mascota
                String nombreM = t.leerString(); // Leer el nombre de la mascota
                System.out.println("Edad"); // Solicitar edad de la mascota
                int edad = t.leerInt(); // Leer la edad de la mascota
                // Crear un nuevo cliente y escribirlo en el archivo
                Cliente c = new Cliente((int) (f.length() / Cliente.getTamanoRegistro()), nombre, nombreM, edad);
                f.seek(f.length()); // Ir al final del archivo
                c.escribir(f); // Escribir el nuevo cliente en el archivo
            }
        } catch (IOException e) {
            System.out.println("Error en el fichero"); // Manejo de errores al abrir o escribir en el archivo
        }
    }

    // Supongo que el fichero está abierto
    private boolean buscarEnFichero(String nombre, RandomAccessFile f) throws IOException {
        boolean encontrado = false; // Variable para indicar si se encontró el cliente
        Cliente c = new Cliente(); // Crear una instancia de Cliente
        File faux = new File(NOMBREFICHERO); // Crear un objeto File para verificar la existencia del archivo
        if (faux.exists()) { // Verificar si el archivo existe
            boolean hayDatos = c.leer(f); // Leer el primer cliente
            while (hayDatos && !encontrado) { // Mientras haya datos y no se haya encontrado el cliente
                if (nombre.equalsIgnoreCase(c.nombreCliente)) // Comparar el nombre ingresado con el nombre del cliente
                    encontrado = true; // Si coincide, marcar como encontrado
                else
                    hayDatos = c.leer(f); // Leer el siguiente cliente
            }
        }
        return encontrado; // Retornar si se encontró el cliente
    }
}
