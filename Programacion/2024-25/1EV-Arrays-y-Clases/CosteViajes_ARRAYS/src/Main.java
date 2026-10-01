import java.util.ArrayList;
import java.util.HashMap;

class CosteViajes {
    private String[] destinos = {"Madrid", "Londres", "Roma", "París", "Berlín"};
    private double[][] costes = {
            {0, 33, 34, 66, 76},
            {100, 0, 43, 45, 99},
            {96, 100, 0, 34, 87},
            {54, 123, 145, 0, 54},
            {125, 78, 13, 68, 0}
    };

    public int[] viajeMasCaroIdaVuelta() {
        double maxCosto = 0;
        int origenMax = -1, destinoMax = -1;

        for (int i = 0; i < destinos.length; i++) {
            for (int j = 0; j < destinos.length; j++) {
                double idaVuelta = costes[i][j] + costes[j][i];
                if (idaVuelta > maxCosto) {
                    maxCosto = idaVuelta;
                    origenMax = i;
                    destinoMax = j;
                }
            }
        }

        return new int[]{origenMax, destinoMax};
    }
}

class Viaje {
    private int origen, destino;
    private double coste;

    public Viaje(int origen, int destino, double coste) {
        this.origen = origen;
        this.destino = destino;
        this.coste = coste;
    }

    public double getCoste() {
        return coste;
    }
}

class Viajero {
    private ArrayList<Viaje> viajes = new ArrayList<>();
    private int identificador;

    public Viajero(int identificador) {
        this.identificador = identificador;
    }

    public void contratarViaje(int origen, int destino, double coste) {
        viajes.add(new Viaje(origen, destino, coste));
    }

    public double totalGastado() {
        return viajes.stream().mapToDouble(Viaje::getCoste).sum();
    }

    public int totalViajes() {
        return viajes.size();
    }

    public int getIdentificador() {
        return identificador;
    }
}

class AgenciaViajes {
    private HashMap<Integer, Viajero> clientes = new HashMap<>();
    private CosteViajes costes = new CosteViajes();

    public void altaCliente(int identificador) {
        if (!clientes.containsKey(identificador)) {
            clientes.put(identificador, new Viajero(identificador));
            System.out.println("Cliente dado de alta.");
        } else {
            System.out.println("Cliente ya registrado.");
        }
    }

    public void contratarViaje(int identificador, int origen, int destino) {
        if (clientes.containsKey(identificador)) {
            double coste = costes.getCostes()[origen][destino];
            clientes.get(identificador).contratarViaje(origen, destino, coste);
        }
    }
}
