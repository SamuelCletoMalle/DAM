public class Paciente {
    private String nombre;
    private int gravedad;
    private long tiempoIngreso;

    public Paciente(String nombre, int gravedad) {
        this.nombre = nombre;
        this.gravedad = gravedad;
        this.tiempoIngreso = System.currentTimeMillis(); // para controlar antigüedad
    }

    public String getNombre() {
        return nombre;
    }

    public int getGravedad() {
        return gravedad;
    }

    public long getTiempoIngreso() {
        return tiempoIngreso;
    }

    @Override
    public String toString() {
        return nombre + " (Gravedad: " + gravedad + ")";
    }
}
