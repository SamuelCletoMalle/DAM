import java.io.*;
import java.util.Scanner;

public class EscribirAlumnos {

    public static void main(String[] args) {
        boolean fin = false;
        Scanner sc= new Scanner(System.in);
        String nombre;
        float nota;
        Alumno a;
        try (DataOutputStream fout = new DataOutputStream(new FileOutputStream("alumnos.dat"))){
            do {
                System.out.println("Dame el nombre del alumno: (usa: Fin --> para finalizar)");
                nombre= sc.nextLine();
                if (nombre.equals("Fin"))
                    fin = true;
                else {
                    System.out.println("Dame la nota media:");
                    nota = Float.parseFloat(sc.nextLine());
                    a = new Alumno(nombre, nota);
                    a.escribir(fout);
                }
            }while (!fin);
        } catch (FileNotFoundException e) {
            System.out.println("El fichero alumnos.dat no existe");
        } catch (IOException e) {
            System.out.println("Error de lectura/   escritura");
        }
    }
}
