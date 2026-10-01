public class SaldoInsuficienteException extends Exception {
    private final double faltante;

    public SaldoInsuficienteException(double faltante) {
        super("Saldo insuficiente, faltan " + String.format("%.2f", faltante) + " euros");
        this.faltante = faltante;
    }

    public double getFaltante() {
        return faltante;
    }
}
