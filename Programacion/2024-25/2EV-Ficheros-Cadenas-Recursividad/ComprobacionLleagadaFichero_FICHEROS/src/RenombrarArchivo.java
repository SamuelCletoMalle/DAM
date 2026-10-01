import java.io.File;

public class RenombrarArchivo {
    public static void main(String[] args) {

        String directorioPath = "C:\\Users\\Alumno\\Desktop\\Nueva carpeta";

        File directorio = new File(directorioPath);
        int contador = 1; //  contador para el nombre del archivo

        // verifica el archivo 60 veces (1 vez por segundo)
        for (int i = 0; i < 60; i++) {
            File archivoDatos = new File(directorio, "Datos.txt"); // Crea obj File "Datos.txt"

            // Verificacion
            if (archivoDatos.exists()) {
                // Nuevo nombre
                File nuevoArchivo = new File(directorio, "Datos" + contador + ".txt");

                // Intenta renombrar
                if (archivoDatos.renameTo(nuevoArchivo)) {
                    System.out.println("Renombrado a: " + nuevoArchivo.getName());
                    contador++; // Incrementa el contador para renombrado
                }
            }

            // Espera 1 segundo antes de volver a comprobar
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("El hilo fue interrumpido.");
            }
        }
    }
}

    }
}