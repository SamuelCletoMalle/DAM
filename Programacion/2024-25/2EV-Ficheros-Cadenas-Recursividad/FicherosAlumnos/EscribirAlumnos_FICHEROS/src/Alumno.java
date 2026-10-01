import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Alumno {
    String nombre;
    float notaMedia;

    public Alumno(String nombre, float notaMedia) {
        this.nombre = nombre;
        this.notaMedia = notaMedia;
    }

    public void leer(DataInputStream fin) {
        try {
            this.nombre = fin.readUTF();
            this.notaMedia = fin.readFloat();
        } catch (IOException e) {
            System.out.println("Error de lectura");
        }
    }
    public void escribir(DataOutputStream fout) {
        try {
            fout.writeUTF(this.nombre);
            fout.writeFloat(this.notaMedia);
        } catch (IOException e) {
            System.out.println("Error de escritura");
        }
    }
}
