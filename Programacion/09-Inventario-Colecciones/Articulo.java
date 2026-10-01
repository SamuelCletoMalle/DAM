public class Articulo {
    private final String codigo;
    private final String nombre;
    private final String categoria;
    private int stock;
    private final double precio;

    Articulo(String codigo, String nombre, String categoria, int stock, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.stock = stock;
        this.precio = precio;
    }

    String getCodigo() { return codigo; }
    String getNombre() { return nombre; }
    String getCategoria() { return categoria; }
    int getStock() { return stock; }
    double getPrecio() { return precio; }

    void setStock(int stock) { this.stock = stock; }

    double valorEnAlmacen() {
        return stock * precio;
    }

    static Articulo desdeCsv(String linea) {
        String[] p = linea.split(";");
        return new Articulo(p[0], p[1], p[2], Integer.parseInt(p[3]), Double.parseDouble(p[4]));
    }

    @Override
    public String toString() {
        return String.format("%-6s %-22s %-12s stock:%3d  %7.2f €", codigo, nombre, categoria, stock, precio);
    }
}
