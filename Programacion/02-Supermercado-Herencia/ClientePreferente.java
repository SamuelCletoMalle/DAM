public class ClientePreferente extends Cliente {

    double descuento = 0.10; // 10%

    public ClientePreferente(String nombre, String password) {
        super(nombre, password);
    }

    @Override
    public double calcularTotalCarrito() {
        double total = super.calcularTotalCarrito();
        return total - (total * descuento);
    }
}
