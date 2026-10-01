import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class RadarTramo {

    private static final int KM_INICIAL = 8;
    private static final int KM_FINAL = 28;
    private static final double VELOCIDAD_MAX_KMH = 100.0;
    private static final long SEGUNDOS_LIMPIEZA = 300;

    private static final Map<String, Long> radar1Pasos = new ConcurrentHashMap<>();
    private static final Map<String, Double> velocidadesSimuladas = new HashMap<>();
    private static final String FICHERO_MULTAS = "multas.properties";
    private static final Properties multasProperties = new Properties();

    // Simula paso por el radar 1
    public static void pasoPorRadar1(String matricula, double velocidadKmH) {
        long tiempoActual = System.currentTimeMillis() / 1000;
        radar1Pasos.put(matricula, tiempoActual);
        velocidadesSimuladas.put(matricula, velocidadKmH);
        System.out.println("🚗 Vehículo " + matricula + " entra a " + String.format("%.2f", velocidadKmH)
                + " km/h en el radar 1");
    }

    // Simula paso por el radar 2 (basado en velocidad simulada)
    public static void pasoPorRadar2(String matricula) {
        if (!radar1Pasos.containsKey(matricula)) {
            System.out.println("❌ Matrícula " + matricula + " no encontrada en radar1.");
            return;
        }

        long tiempo1 = radar1Pasos.get(matricula);
        double velocidadSimulada = velocidadesSimuladas.get(matricula);
        double distanciaKm = KM_FINAL - KM_INICIAL;

        // Calcular tiempo teórico de recorrido en segundos
        double tiempoTeoricoSegundos = (distanciaKm / velocidadSimulada) * 3600;
        long tiempo2 = tiempo1 + (long) tiempoTeoricoSegundos;

        // Calcular velocidad real a partir del tiempo simulado
        long tiempoTotal = tiempo2 - tiempo1;
        double velocidadReal = (distanciaKm / (double) tiempoTotal) * 3600;

        if (velocidadReal > VELOCIDAD_MAX_KMH) {
            int multa = calcularMulta(velocidadReal);
            multasProperties.setProperty(matricula, String.valueOf(multa));
            guardarMultasEnFichero();
            System.out.printf("🚨 ¡MULTA! %s iba a %.2f km/h → %d€%n", matricula, velocidadReal, multa);
        } else {
            System.out.printf("✅ OK: %s iba a %.2f km/h%n", matricula, velocidadReal);
        }

        radar1Pasos.remove(matricula);
        velocidadesSimuladas.remove(matricula);
    }

    // Elimina vehículos que pasaron hace más de "segundos" segundos
    public static void eliminarNoMultadosAntiguos(long segundos) {
        long ahora = System.currentTimeMillis() / 1000;
        radar1Pasos.entrySet().removeIf(e -> ahora - e.getValue() > segundos);
        System.out.println("🧹 Se eliminaron vehículos antiguos (>" + segundos + "s).");
    }

    // Cálculo de multa (según exceso)
    private static int calcularMulta(double velocidad) {
        double exceso = velocidad - VELOCIDAD_MAX_KMH;
        if (exceso <= 20) return 100;
        else if (exceso <= 30) return 300;
        else if (exceso <= 40) return 400;
        else if (exceso <= 50) return 500;
        else return 600;
    }

    // Guardar multas en fichero
    private static void guardarMultasEnFichero() {
        try (FileOutputStream out = new FileOutputStream(FICHERO_MULTAS)) {
            multasProperties.store(out, "Multas registradas por radar de tramo");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Generador de matrículas aleatorias
    public static String generarMatriculaAleatoria() {
        Random r = new Random();
        int numeros = r.nextInt(9000) + 1000;
        char letra1 = (char) (r.nextInt(26) + 'A');
        char letra2 = (char) (r.nextInt(26) + 'A');
        char letra3 = (char) (r.nextInt(26) + 'A');
        return numeros + "" + letra1 + letra2 + letra3;
    }

    // Generador de velocidades aleatorias (entre 80 y 160 km/h)
    public static double generarVelocidadAleatoria() {
        Random r = new Random();
        return 80 + r.nextDouble() * 80; // de 80 a 160 km/h
    }

    // MAIN de prueba con un coche cada 10 segundos
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String matricula = generarMatriculaAleatoria();
            double velocidad = generarVelocidadAleatoria();
            pasoPorRadar1(matricula, velocidad);
            pasoPorRadar2(matricula);

            try {
                ;
                Thread.sleep(5000); // 10 segundos reales
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        eliminarNoMultadosAntiguos(SEGUNDOS_LIMPIEZA);
    }
}
