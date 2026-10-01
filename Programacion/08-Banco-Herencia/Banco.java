import java.util.ArrayList;

public class Banco {
    private final ArrayList<Cuenta> cuentas = new ArrayList<>();

    void abrir(Cuenta c) {
        cuentas.add(c);
    }

    Cuenta buscar(int numero) {
        for (Cuenta c : cuentas) {
            if (c.getNumero() == numero) {
                return c;
            }
        }
        return null;
    }

    void transferir(int origen, int destino, double cantidad) throws SaldoInsuficienteException {
        Cuenta o = buscar(origen);
        Cuenta d = buscar(destino);
        if (o == null || d == null) {
            throw new IllegalArgumentException("Alguna de las cuentas no existe");
        }
        o.retirar(cantidad);
        d.ingresar(cantidad);
    }

    void cierreDeMes() {
        for (Cuenta c : cuentas) {
            c.cierreDeMes();
        }
    }

    double totalDepositado() {
        double total = 0;
        for (Cuenta c : cuentas) {
            total += c.getSaldo();
        }
        return total;
    }

    void listar() {
        for (Cuenta c : cuentas) {
            System.out.println(c);
        }
    }
}
