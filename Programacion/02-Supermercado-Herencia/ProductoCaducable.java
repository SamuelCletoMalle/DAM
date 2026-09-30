import java.time.LocalDateTime;

public class ProductoCaducable extends Producto {

    LocalDateTime fechaCaducidad;

    public ProductoCaducable(String nombre, double precio, int stock, LocalDateTime fechaCaducidad) {
        super(nombre, precio, stock);
        this.fechaCaducidad = fechaCaducidad;
    }
}
