import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

    public class LeerFicheroNotas {

        void leerFichero(String rutaBase) {

            double sumaMedias = 0;
            int numAlumnos = 0;

            String mejorAlumno = "";
            double mejorMedia = 0;

            try (BufferedReader br = new BufferedReader(new FileReader(rutaBase))) {

                br.readLine();

                String linea;
                while ((linea = br.readLine()) != null) {

                    String[] datos = linea.split(";");

                    String nombre = datos[0];
                    double sumaNotas = 0;
                    int numNotas = 0;

                    for (int i = 1; i < datos.length; i++) {
                        if (!datos[i].equals("")) {
                            sumaNotas += Integer.parseInt(datos[i]);
                            numNotas++;
                        }
                    }

                    double media = sumaNotas / numNotas;

                    sumaMedias += media;
                    numAlumnos++;

                    if (media > mejorMedia) {
                        mejorMedia = media;
                        mejorAlumno = nombre;
                    }
                }

                double mediaClase = sumaMedias / numAlumnos;

                System.out.println("Alumno con mejor nota media: " + mejorAlumno);
                System.out.println("Nota media más alta: " + mejorMedia);
                System.out.println("Media de la clase: " + mediaClase);

            } catch (IOException e) {
                System.out.println("Error leyendo el fichero");
            }
        }
    public static void main(String[] args) {
        LeerFicheroNotas lf = new LeerFicheroNotas();
        lf.leerFichero("notasAlumnos.csv");
    }
}

