public class Seguro {
    boolean hombre;
    int agnosUltimoParte;
    char tipoCoche;

    public Seguro(boolean hombre, int agnosUltimoParte, char tipoCoche) {
        this.hombre = hombre;
        this.agnosUltimoParte = agnosUltimoParte;
        this.tipoCoche = tipoCoche;
    }


    public double calcularPrecio() {
        double precioBase = 0.0;
        double descuento = 0.0;


        switch (tipoCoche) {
            case 'p':
                precioBase = 400;
                if (agnosUltimoParte >= 5) {
                    descuento = 0.15;
                } else {
                    descuento = 0.10;
                }
                break;

            case 'm':
                precioBase = 600;
                if (!hombre) {
                    descuento = 0.16;
                } else if (agnosUltimoParte >= 3) {
                    descuento = 0.17;
                } else {
                    descuento = 0.10;
                }
                break;

            case 'g':
                precioBase = 900;
                if (agnosUltimoParte >= 7) {
                    descuento = 0.20;
                } else if (!hombre) {
                    descuento = 0.10;
                } else {
                    descuento = 0.08;
                }
                break;

            default:
                System.out.println("Tipo de coche no válido");
                return 0;
        }


        double precioFinal = precioBase * (1 - descuento);

        return precioFinal;
    }

    public static void main(String[] args) {



        Seguro seguro1 = new Seguro(true, 15, 'g');
        System.out.println("Precio del seguro : " + seguro1.calcularPrecio() + " €.");

    }
}
