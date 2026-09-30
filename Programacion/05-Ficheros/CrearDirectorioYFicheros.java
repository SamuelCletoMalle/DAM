import java.io.File;
import java.io.IOException;

public class CrearDirectorioYFicheros {
    public static void main(String[] args) throws IOException {

        Teclado t = new Teclado();
        System.out.print("Introduce la ruta donde se guardará el directorio: ");
        String rutaBase = t.leerString();

        File dir1 = new File(rutaBase, "dir1");

        if (dir1.exists() || dir1.mkdir()) {
            System.out.println("Directorio dir1 listo");

            File f1 = new File(dir1, "f1.txt");
            File f2 = new File(dir1, "f2.txt");

            if (!f1.exists() && !f2.exists()) {
                try {
                    f1.createNewFile();
                    f2.createNewFile();
                    System.out.println("Archivos f1 y f2 creados");
                } catch (Exception e) {
                    System.out.println("Error al crear f1 o f2");
                    return;
                }
            }

            File dir1a = new File(dir1, "dir1a");

            if (dir1a.exists() || dir1a.mkdir()) {
                System.out.println("Subdirectorio dir1a listo");

                File f1a = new File(dir1a, "f1a.txt");
                File f2a = new File(dir1a, "f2a.txt");

                try {
                    f1a.createNewFile();
                    f2a.createNewFile();
                    System.out.println("Archivos f1a y f2a creados");
                    System.out.println("Estructura creada correctamente");
                } catch (Exception e) {
                    System.out.println("Error al crear f1a o f2a");
                }

            } else {
                System.out.println("No se pudo crear el subdirectorio dir1a");
            }

        } else {
            System.out.println("No se pudo crear el directorio dir1");
        }
    }
}
