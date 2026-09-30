import java.util.ArrayList;

public class Cliente {

    String nombre;
    String password;

    ArrayList<Producto> carrito = new ArrayList<>();
    ArrayList<Producto> compras = new ArrayList<>();

    public Cliente(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }

    public void anadirAlCarrito(Producto p) {
        carrito.add(p);
    }

    public double calcularTotalCarrito() {
        double total = 0;
        for (Producto p : carrito) {
            total += p.getPrecio();
        }
        return total;
    }

    public void realizarCompra() {
        compras.addAll(carrito);
        carrito.clear();
    }
}
