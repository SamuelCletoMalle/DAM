public class TestPartido {
    public static void main(String[] args) {

        Equipo equipo1 = new Equipo("Rayo Vallecano");
        Equipo equipo2 = new Equipo("C.D Leganés");
        Equipo equipo3 = new Equipo("Atlético Madrid");


        Partido partido1 = new Partido(equipo1, equipo2);
        Partido partido2 = new Partido(equipo1, equipo3);
        Partido partido3 = new Partido(equipo2, equipo3);
        Partido partido4 = new Partido(equipo3, equipo1);


        partido1.jugarPartido();
        partido2.jugarPartidoPonderada();
        partido3.jugarPartido();
        partido4.jugarPartidoPonderada();


        System.out.println(partido1.getResultado());
        System.out.println(partido2.getResultado());
        System.out.println(partido3.getResultado());
        System.out.println(partido4.getResultado());


        mostrarEstadisticas(equipo1);
        mostrarEstadisticas(equipo2);
        mostrarEstadisticas(equipo3);
    }

    public static void mostrarEstadisticas(Equipo equipo) {
        System.out.println("Equipo: " + equipo.getNombre());
        System.out.println("Puntuación: " + equipo.getPuntuacion());
        System.out.println("Goles a favor: " + equipo.getGolesFavor());
        System.out.println("Goles en contra: " + equipo.getGolesContra());
        System.out.println();
    }
}
