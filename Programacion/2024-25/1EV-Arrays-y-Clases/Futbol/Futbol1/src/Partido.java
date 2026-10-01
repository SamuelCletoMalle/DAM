public class Partido {
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int golesLocal;
    private int golesVisitante;

    public Partido(Equipo local, Equipo visitante) {
        this.equipoLocal = local;
        this.equipoVisitante = visitante;
        this.golesLocal = 0;
        this.golesVisitante = 0;
    }

    private int generarGoles() {
        return (int) (Math.random() * 5);
    }

    public void jugarPartido() {
        golesLocal = generarGoles();
        golesVisitante = generarGoles();


        actualizarEstadisticas();
    }

    public void jugarPartidoPonderada() {

        golesLocal = (int) ((Math.random() * 5) * 1.5);
        golesVisitante = (int) ((Math.random() * 5) * 1.2);

        actualizarEstadisticas();
    }


    private void actualizarEstadisticas() {
        equipoLocal.setGolesFavor(equipoLocal.getGolesFavor() + golesLocal);
        equipoVisitante.setGolesFavor(equipoVisitante.getGolesFavor() + golesVisitante);

        equipoLocal.setGolesContra(equipoLocal.getGolesContra() + golesVisitante);
        equipoVisitante.setGolesContra(equipoVisitante.getGolesContra() + golesLocal);


        equipoLocal.setPuntuacion(equipoLocal.getPuntuacion() + (golesLocal > golesVisitante ? 3 : golesLocal == golesVisitante ? 1 : 0));
        equipoVisitante.setPuntuacion(equipoVisitante.getPuntuacion() + (golesVisitante > golesLocal ? 3 : golesLocal == golesVisitante ? 1 : 0));
    }


    public String getResultado() {
        return equipoLocal.getNombre() + " " + golesLocal + " - " + golesVisitante + " " + equipoVisitante.getNombre();
    }
}
