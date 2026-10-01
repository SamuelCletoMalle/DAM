import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class LeerAlumnos {
    public static void main(String[] args) {
        float sumaNotas = 0;
        int contador = 0;

        try (DataInputStream fin = new DataInputStream(new FileInputStream("alumnos.dat"))) {
            while (true) {
                Alumno alumno = new Alumno("", 0);
                alumno.leer(fin);
                System.out.println("Nombre: " + alumno.nombre + ", Nota Media: " + alumno.notaMedia);
                sumaNotas += alumno.notaMedia;
                contador++;
            }
        } catch (IOException e) {

            System.out.println("Fin de la lectura de alumnos.");
        }

        if (contador > 0) {
            float notaMediaClase = sumaNotas / contador;
            System.out.println("La nota media de la clase es: " + notaMediaClase);
        } else {
            System.out.println("No se han registrado alumnos.");
        }
    }
}