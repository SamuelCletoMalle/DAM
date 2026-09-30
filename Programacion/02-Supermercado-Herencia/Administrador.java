import java.time.LocalDateTime;
import java.util.ArrayList;

public class Administrador {

    ArrayList<Producto> productos = new ArrayList<>();

    public void anadirProducto(Producto p) {
        productos.add(p);
    }

    public void productosPorCaducar() {
        for (Producto p : productos) {
            if (p instanceof ProductoCaducable) {
                ProductoCaducable pc = (ProductoCaducable) p;
                if (pc.fechaCaducidad.isBefore(LocalDateTime.now().plusWeeks(1))) {
                    System.out.println(pc.nombre + " caduca pronto!");
                }
            }
        }
    }
}
