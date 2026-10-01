import java.util.ArrayList;

public abstract class Cuenta {
    private static int contador = 1000;

    protected final int numero;
    protected final String titular;
    protected double saldo;
    protected final ArrayList<String> movimientos = new ArrayList<>();

    Cuenta(String titular, double saldoInicial) {
        this.numero = ++contador;
        this.titular = titular;
        this.saldo = saldoInicial;
        movimientos.add("Apertura con " + saldoInicial);
    }

    void ingresar(double cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser positiva");
        }
        saldo += cantidad;
        movimientos.add("Ingreso de " + cantidad);
    }

    void retirar(double cantidad) throws SaldoInsuficienteException {
        double disponible = saldoDisponible();
        if (cantidad > disponible) {
            throw new SaldoInsuficienteException(cantidad - disponible);
        }
        saldo -= cantidad;
        movimientos.add("Retirada de " + cantidad);
    }

    /** Cada tipo de cuenta decide cuánto se puede retirar */
    abstract double saldoDisponible();

    /** Se llama a fin de mes */
    abstract void cierreDeMes();

    double getSaldo() { return saldo; }
    int getNumero() { return numero; }

    void mostrarMovimientos() {
        System.out.println("Movimientos de la cuenta " + numero + ":");
        for (String m : movimientos) {
            System.out.println("  - " + m);
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + numero + " (" + titular + ") saldo: " + String.format("%.2f", saldo);
    }
}
