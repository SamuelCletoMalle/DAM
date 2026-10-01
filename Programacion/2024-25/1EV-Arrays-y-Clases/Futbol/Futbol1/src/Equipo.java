public class Equipo {
    private String nombre;
    private int puntuacion;
    private int golesFavor;
    private int golesContra;

    // Constructor
    public Equipo(String nombre) {
        this.nombre = nombre;
        this.puntuacion = 0;
        this.golesFavor = 0;
        this.golesContra = 0;
    }


    public String getNombre() { return nombre; }
    public int getPuntuacion() { return puntuacion; }
    public int getGolesFavor() { return golesFavor; }
    public int getGolesContra() { return golesContra; }

    public void setPuntuacion(int puntuacion) { this.puntuacion = puntuacion; }
    public void setGolesFavor(int golesFavor) { this.golesFavor = golesFavor; }
    public void setGolesContra(int golesContra) { this.golesContra = golesContra; }
}


