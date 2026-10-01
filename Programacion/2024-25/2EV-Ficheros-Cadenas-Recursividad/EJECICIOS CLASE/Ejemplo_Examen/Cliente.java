import java.io.IOException;
import java.io.RandomAccessFile;

public class Estudiante {
    private int id;
    private String nombre;
    private int[] calificaciones;
    private boolean eliminado; // Para marcar si el estudiante está eliminado

    // Constructor
    public Estudiante(int id, String nombre, int[] calificaciones) {
        this.id = id;
        this.nombre = nombre;
        this.calificaciones = calificaciones;
        this.eliminado = false; // Por defecto, no está eliminado
    }

    // Métodos para leer y escribir en el archivo
    public void escribir(RandomAccessFile raf) throws IOException {
        raf.writeInt(id);
        raf.writeUTF(nombre);
        raf.writeInt(calificaciones.length);
        for (int calificacion : calificaciones) {
            raf.writeInt(calificacion);
        }
        raf.writeBoolean(eliminado);
    }

    public static Estudiante leer(RandomAccessFile raf) throws IOException {
        int id = raf.readInt();
        String nombre = raf.readUTF();
        int numCalificaciones = raf.readInt();
        int[] calificaciones = new int[numCalificaciones];
        for (int i = 0; i < numCalificaciones; i++) {
            calificaciones[i] = raf.readInt();
        }
        boolean eliminado = raf.readBoolean();
        Estudiante estudiante = new Estudiante(id, nombre, calificaciones);
        estudiante.eliminado = eliminado;
        return estudiante;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int[] getCalificaciones() {
        return calificaciones;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public double calcularMedia() {
        if (calificaciones.length == 0) return 0;
        int suma = 0;
        for (int calificacion : calificaciones) {
            suma += calificacion;
        }
        return (double) suma / calificaciones.length;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Calificaciones: " + java.util.Arrays.toString(calificaciones) + ", Eliminado: " + eliminado;
    }
}