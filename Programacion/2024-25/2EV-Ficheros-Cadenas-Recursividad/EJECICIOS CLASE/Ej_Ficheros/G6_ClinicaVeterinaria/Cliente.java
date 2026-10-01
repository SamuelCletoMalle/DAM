import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Cliente {
    int idCliente;   // Identificador del cliente. -1 si el registro está borrado.
    String nombreCliente; // Nombre del cliente
    String nombreMascota; // Nombre de la mascota
    int edadAnimal; // Edad de la mascota
    float gasto; // Gasto acumulado del cliente
    final static int TAMANONOMBRE = 20; // Tamaño máximo para los nombres

    // Método estático para obtener el tamaño del registro en bytes
    static int getTamanoRegistro() {
        return (4 + TAMANONOMBRE * 2 * 2 + 4 + 4); // Tamaño total del registro
        // 4 bytes para idCliente + (TAMANONOMBRE * 2 bytes por carácter Unicode) + 4 bytes para edadAnimal + 4 bytes para gasto
    }

    // Método para verificar si el cliente está borrado
    boolean borrado() {
        return idCliente == -1; // Retorna true si el idCliente es -1
    }

    // Constructor que inicializa un cliente con los datos proporcionados
    Cliente(int idCli, String nomCli, String nomMasc, int e) {
        idCliente = idCli;
        nombreCliente = nomCli;
        nombreMascota = nomMasc;
        edadAnimal = e;
        gasto = 0; // Inicializa el gasto a 0
    }

    // Constructor por defecto
    Cliente() {
        nombreCliente = "NADA"; // Nombre por defecto
        edadAnimal = 0; // Edad por defecto
    }

    // Método para rellenar un array de caracteres con el nombre
    char[] rellenarString(String nombre) {
        char nombreB[] = new char[TAMANONOMBRE]; // Crear un array de caracteres del tamaño máximo
        for (int i = 0; i < nombre.length() && i < TAMANONOMBRE; i++)
            nombreB[i] = nombre.charAt(i); // Rellenar el array con los caracteres del nombre
        for (int i = nombre.length(); i < TAMANONOMBRE; i++)
            nombreB[i] = (char) 0; // Rellenar el resto del array con caracteres nulos
        return nombreB; // Retornar el array de caracteres
    }

    // Método para escribir el registro del cliente en un archivo
    void escribir(RandomAccessFile f) throws IOException {
        char nombreB[];
        f.writeInt(idCliente); // Escribir el idCliente
        nombreB = rellenarString(nombreCliente); // Rellenar el nombre del cliente
        f.writeChars(String.valueOf(nombreB)); // Escribir el nombre del cliente en el archivo
        nombreB = rellenarString(nombreMascota); // Rellenar el nombre de la mascota
        f.writeChars(String.valueOf(nombreB)); // Escribir el nombre de la mascota en el archivo
        f.writeInt(edadAnimal); // Escribir la edad del animal
        f.writeFloat(gasto); // Escribir el gasto acumulado
    }

    // Método para leer el registro del cliente desde un archivo
    boolean leer(RandomAccessFile f) throws IOException {
        // Devuelve true si lee algo y false si no devuelve nada
        try {
            idCliente = f.readInt(); // Leer el idCliente
            String nombAux = getString(f); // Leer el nombre del cliente
            nombreCliente = nombAux; // Asignar el nombre del cliente
            nombAux = getString(f); // Leer el nombre de la mascota
            nombreMascota = nombAux; // Asignar el nombre de la mascota
            edadAnimal = f.readInt(); // Leer la edad del animal
            gasto = f.readFloat(); // Leer el gasto acumulado
            return true; // Retornar true si se ha leído correctamente
        } catch (EOFException e) {
            return false; // Retornar false si se alcanza el final del archivo
        }
    }

    // Método privado para obtener un string desde el archivo
    private static String getString(RandomAccessFile f) throws IOException {
        StringBuffer nombreB = new StringBuffer(TAMANONOMBRE); // Crear un StringBuffer para el nombre
        nombreB.setLength(TAMANONOMBRE); // Establecer la longitud del StringBuffer
        char car = 'a'; // Variable para almacenar caracteres
        int i = 0, tamanoString = 0; // Inicializar índices
        for (i = 0; i < TAMANONOMBRE; i++) {
            car = f.readChar(); // Leer un carácter del archivo
            nombreB.setCharAt(i, car); // Establecer el carácter en el StringBuffer
            if (car == '\0' && tamanoString == 0) // Si se encuentra un carácter nulo
                tamanoString = i; // Guardar la posición del primer carácter nulo
        }
        nombreB.setLength(tamanoString); // Ajustar la longitud del StringBuffer
        String nombAux = nombreB.toString(); // Convertir el StringBuffer a String
        return nombAux; // Retornar el nombre
    }

    // Método para representar el objeto como una cadena
    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", nombreMascota='" + nombreMascota + '\'' +
                ", edadAnimal=" + edadAnimal +
                ", gasto=" + gasto +
                '}';
    }

    // Método para mostrar información básica del cliente
    void mostrar() {
        System.out.println("nombre:" + nombreCliente + "  edad:" + edadAnimal);
    }

    // Método para mostrar un array de caracteres
    void mostrarArrayChar(char nombreB[]) {
        for (int i = 0; i < nombreB.length; i++)
            System.out.print(nombreB[i]); // Imprimir cada carácter del array
    }
}