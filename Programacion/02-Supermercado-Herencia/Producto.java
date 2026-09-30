import java.time.LocalDateTime;

public class Producto {

    String nombre;
    double precioOriginal;
    double precioOferta;
    LocalDateTime finOferta;
    int stock;

    public Producto(String nombre, double precioOriginal, int stock) {
        this.nombre = nombre;
        this.precioOriginal = precioOriginal;
        this.stock = stock;
        this.precioOferta = precioOriginal;
    }

    public double getPrecio() {
        if (finOferta != null && LocalDateTime.now().isBefore(finOferta)) {
            return precioOferta;
        }
        return precioOriginal;
    }

    public void ponerEnOferta(double nuevoPrecio, LocalDateTime finOferta) {
        this.precioOferta = nuevoPrecio;
        this.finOferta = finOferta;
    }
}
