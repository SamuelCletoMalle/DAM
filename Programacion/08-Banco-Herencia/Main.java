public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        CuentaAhorro ahorro = new CuentaAhorro("Lucía", 1500, 2.4);
        CuentaCorriente corriente = new CuentaCorriente("Pablo", 200, 300);
        banco.abrir(ahorro);
        banco.abrir(corriente);
        banco.listar();

        try {
            banco.transferir(corriente.getNumero(), ahorro.getNumero(), 450);
            System.out.println("Transferencia de 450 realizada (usa el descubierto)");
            banco.transferir(corriente.getNumero(), ahorro.getNumero(), 100);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }

        banco.cierreDeMes();
        banco.listar();
        ahorro.mostrarMovimientos();
        System.out.println("Total depositado: " + String.format("%.2f", banco.totalDepositado()));
    }
}
