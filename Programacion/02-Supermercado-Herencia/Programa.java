import java.time.LocalDateTime;

public class Programa {

    public static void main(String[] args) {

        Administrador admin = new Administrador();

        Producto leche = new ProductoCaducable(
                "Leche",
                1.50,
                10,
                LocalDateTime.now().plusDays(5)
        );

        Producto arroz = new Producto("Arroz", 2.00, 20);

        admin.anadirProducto(leche);
        admin.anadirProducto(arroz);

        arroz.ponerEnOferta(1.50, LocalDateTime.now().plusDays(2));

        ClientePreferente cliente = new ClientePreferente("Juan", "1234");

        cliente.anadirAlCarrito(leche);
        cliente.anadirAlCarrito(arroz);

        double total = cliente.calcularTotalCarrito();
        System.out.println("Total a pagar: " + total);

        cliente.realizarCompra();
    }
}
