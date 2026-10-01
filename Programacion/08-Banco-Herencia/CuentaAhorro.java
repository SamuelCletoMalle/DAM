public class CuentaAhorro extends Cuenta {
    private final double interesAnual;

    CuentaAhorro(String titular, double saldoInicial, double interesAnual) {
        super(titular, saldoInicial);
        this.interesAnual = interesAnual;
    }

    @Override
    double saldoDisponible() {
        return saldo;
    }

    @Override
    void cierreDeMes() {
        double interes = saldo * interesAnual / 100 / 12;
        saldo += interes;
        movimientos.add("Intereses: " + String.format("%.2f", interes));
    }
}
