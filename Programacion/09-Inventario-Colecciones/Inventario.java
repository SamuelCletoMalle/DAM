import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Inventario {
    private final Map<String, Articulo> articulos = new LinkedHashMap<>();

    void cargar(String fichero) throws IOException {
        for (String linea : Files.readAllLines(Paths.get(fichero))) {
            if (!linea.isBlank()) {
                Articulo a = Articulo.desdeCsv(linea);
                articulos.put(a.getCodigo(), a);
            }
        }
    }

    boolean vender(String codigo, int unidades) {
        Articulo a = articulos.get(codigo);
        if (a == null || a.getStock() < unidades) {
            return false;
        }
        a.setStock(a.getStock() - unidades);
        return true;
    }

    List<Articulo> sinStock() {
        return articulos.values().stream()
                .filter(a -> a.getStock() == 0)
                .collect(Collectors.toList());
    }

    List<Articulo> stockBajo(int limite) {
        return articulos.values().stream()
                .filter(a -> a.getStock() > 0 && a.getStock() < limite)
                .sorted(Comparator.comparingInt(Articulo::getStock))
                .collect(Collectors.toList());
    }

    Map<String, Double> valorPorCategoria() {
        return articulos.values().stream()
                .collect(Collectors.groupingBy(Articulo::getCategoria, TreeMap::new,
                        Collectors.summingDouble(Articulo::valorEnAlmacen)));
    }

    Optional<Articulo> masCaro() {
        return articulos.values().stream().max(Comparator.comparingDouble(Articulo::getPrecio));
    }

    double valorTotal() {
        return articulos.values().stream().mapToDouble(Articulo::valorEnAlmacen).sum();
    }

    void listar() {
        articulos.values().forEach(System.out::println);
    }
}
