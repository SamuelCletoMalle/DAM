import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Main {

    public static void main(String[] args) {

        Vector<Producto> productos = new Vector<>();

        try {
            List<String> lineas = Files.readAllLines(Paths.get("productos.txt"));

            for (String linea : lineas) {
                String[] datos = linea.split(";");

                Producto p = new Producto(
                        Integer.parseInt(datos[0]),
                        datos[1],
                        Double.parseDouble(datos[2]),
                        Integer.parseInt(datos[3])
                );

                productos.add(p);
            }

        } catch (IOException e) {
            System.out.println("Error leyendo el fichero");
            return;
        }

        Vector<Producto> copia = new Vector<>(productos);
        Collections.sort(copia, (a, b) -> Double.compare(b.precio, a.precio));

        if (copia.size() >= 3)
            System.out.println("3er más caro: " + copia.get(2).nombre);

        List<Producto> baratos = productos.stream()
                .filter(p -> p.precio < 10)
                .toList();

        List<String> nombres = productos.stream()
                .filter(p -> p.cantidad < 10)
                .map(p -> p.nombre)
                .filter(n -> n.length() > 10)
                .toList();

        productos.forEach(p -> p.precio *= 1.10);

        Producto resultado = productos.stream()
                .filter(p -> p.nombre.toLowerCase().startsWith("a") && p.cantidad < 10)
                .findFirst()
                .orElse(new Producto(0, "NADA", 0, 0));

        boolean haySinStock = productos.stream()
                .anyMatch(p -> p.cantidad == 0);

        boolean todosConStock = productos.stream()
                .allMatch(p -> p.cantidad > 0);

        System.out.println("Baratos: " + baratos);
        System.out.println("Nombres largos: " + nombres);
        System.out.println("Resultado: " + resultado.nombre);
        System.out.println("Hay sin stock: " + haySinStock);
        System.out.println("Todos con stock: " + todosConStock);
    }
}
