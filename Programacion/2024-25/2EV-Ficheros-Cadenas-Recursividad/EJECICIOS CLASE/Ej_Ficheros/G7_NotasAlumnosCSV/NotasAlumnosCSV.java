import java.io.*;

public class NotasAlumnosCSV {
    public static void main(String[] args) {
        String archivoCSV = "notasAlumnos.csv"; // Nombre del archivo CSV de entrada
        String archivoTxT = "notasAlumnosYMedias.txt"; // Nombre del archivo de salida en formato TXT

        // Usar try-with-resources para manejar automáticamente el cierre de recursos
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV)); // BufferedReader para leer el archivo CSV
             BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTxT))) { // BufferedWriter para escribir en el archivo TXT

            String linea; // Variable para almacenar cada línea leída
            int sumaTotal = 0; // Suma total de todas las notas
            int notasTotales = 0; // Contador total de notas

            // Leer la primera línea (cabecera) y descartarla
            if ((linea = br.readLine()) != null) {
                // Leer cada línea del archivo CSV
                while ((linea = br.readLine()) != null) {
                    String[] datos = linea.split(";"); // Dividir la línea en partes usando ";" como delimitador
                    String nombre = datos[0]; // El primer elemento es el nombre del alumno
                    int sumaNotas = 0; // Suma de las notas del alumno
                    int cantidadNotas = 0; // Contador de notas del alumno

                    try {
                        // Iterar sobre las notas del alumno
                        for (int i = 1; i < datos.length; i++) {
                            if (!datos[i].isEmpty()) { // Verificar que la nota no esté vacía
                                sumaNotas += Integer.parseInt(datos[i]); // Sumar la nota
                                cantidadNotas++; // Incrementar el contador de notas
                            }
                        }
                    } catch (NumberFormatException e) { // Manejar el caso en que la conversión a entero falle
                        bw.write(nombre + ";" + "ERROR"); // Escribir el nombre y "ERROR" en el archivo de salida
                        bw.newLine(); // Nueva línea
                        cantidadNotas = 0; // Reiniciar el contador de notas
                    }

                    // Si hay notas válidas, calcular la media
                    if (cantidadNotas > 0) {
                        double mediaAlumno = (double) sumaNotas / cantidadNotas; // Calcular la media del alumno
                        sumaTotal += sumaNotas; // Sumar las notas del alumno a la suma total
                        notasTotales += cantidadNotas; // Incrementar el contador total de notas
                        bw.write(nombre + ";" + mediaAlumno); // Escribir el nombre y la media en el archivo de salida
                        bw.newLine(); // Nueva línea
                    }
                }

                // Calcular y mostrar la media del grupo si hay notas
                if (notasTotales > 0) {
                    double mediaGrupo = (double) sumaTotal / notasTotales; // Calcular la media del grupo
                    System.out.println("La media total del grupo es: " + mediaGrupo); // Imprimir la media del grupo
                }
            }
        } catch (FileNotFoundException e) { // Manejar el caso en que el archivo no se encuentra
            System.out.println("No se encontró el archivo");
        } catch (IOException e) { // Manejar errores de entrada/salida
            System.out.println("Error al leer el archivo");
        }
    }
}