import java.io.File;
import java.io.IOException;

public class ListarContenidoDirectorio {

    File f1;

    public ListarContenidoDirectorio(String directorio) {
        f1 = new File(directorio);
    }

    boolean comprobarExistencia() {
        if (f1.exists() && f1.isDirectory()) {
            System.out.println("Directorio válido");
            return true;
        } else {
            System.out.println("Directorio NO válido");
            return false;
        }
    }

    void listarFicheros() {
        String[] listarFicheros = f1.list();

        if (listarFicheros != null) {
            for (int i = 0; i < listarFicheros.length; i++) {
                System.out.println(listarFicheros[i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Teclado t = new Teclado();

        System.out.println("Indique la ruta del directorio: ");
        String directorio = t.leerString();

        ListarContenidoDirectorio d1 = new ListarContenidoDirectorio(directorio);

        if (d1.comprobarExistencia()) {
            d1.listarFicheros();
            System.out.println("Tamaño completo del directorio: "+ directorio.length());
        }
    }
}
