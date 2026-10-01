public class CuentaCorriente extends Cuenta {
    private static final double COMISION_MANTENIMIENTO = 2.5;
    private final double descubiertoMaximo;

    CuentaCorriente(String titular, double saldoInicial, double descubiertoMaximo) {
        super(titular, saldoInicial);
        this.descubiertoMaximo = descubiertoMaximo;
    }

    @Override
    double saldoDisponible() {
        return saldo + descubiertoMaximo;
    }

    @Override
    void cierreDeMes() {
        saldo -= COMISION_MANTENIMIENTO;
        movimientos.add("Comisión de mantenimiento: " + COMISION_MANTENIMIENTO);
    }
}
