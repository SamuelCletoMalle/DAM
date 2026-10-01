import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Inventario inv = new Inventario();
        try {
            inv.cargar("articulos.csv");
        } catch (IOException e) {
            System.out.println("No se pudo leer articulos.csv: " + e.getMessage());
            return;
        }

        System.out.println("=== INVENTARIO ===");
        inv.listar();

        System.out.println("\nVendemos 3 monitores de 27 pulgadas: " + inv.vender("A004", 3));
        System.out.println("Intentamos vender 2 más: " + inv.vender("A004", 2));

        System.out.println("\n=== SIN STOCK ===");
        inv.sinStock().forEach(System.out::println);

        System.out.println("\n=== STOCK BAJO (menos de 10) ===");
        inv.stockBajo(10).forEach(System.out::println);

        System.out.println("\n=== VALOR POR CATEGORÍA ===");
        inv.valorPorCategoria().forEach((cat, v) -> System.out.printf("%-12s %9.2f €%n", cat, v));

        inv.masCaro().ifPresent(a -> System.out.println("\nArtículo más caro: " + a.getNombre()));
        System.out.printf("Valor total del almacén: %.2f €%n", inv.valorTotal());
    }
}
