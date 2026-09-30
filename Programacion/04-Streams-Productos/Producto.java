public class Producto {
    int identificador;
    String nombre;
    double precio;
    int cantidad;

    public Producto(int id, String nombre, double precio, int cantidad) {
        this.identificador = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String toString() {
        return identificador + ";" + nombre + ";" + precio + ";" + cantidad;
    }
}
