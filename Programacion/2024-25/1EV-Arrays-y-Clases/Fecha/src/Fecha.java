public class Fecha {

    int dia;
    int mes;
    int agno;


    public Fecha(int d, int m, int a) {
        dia = d;
        mes = m;
        agno = a;
    }

    public static void main(String[] args) {

        Fecha fecha = new Fecha(28, 2, 2023);


        boolean esBisiesto;
        if ((fecha.agno % 4 == 0 && fecha.agno % 100 != 0) || (fecha.agno % 400 == 0)) {
            esBisiesto = true;
            System.out.println("El año es bisiesto");
        } else {
            esBisiesto = false;
            System.out.println("El año no es bisiesto");
        }


        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


        int diasEnMes;
        if (fecha.mes == 2 && esBisiesto) {
            diasEnMes = 29;
        } else {
            diasEnMes = diasPorMes[fecha.mes - 1];
        }


        int nuevoDia = fecha.dia + 1;
        int nuevoMes = fecha.mes;
        int nuevoAgno = fecha.agno;

        if (nuevoDia > diasEnMes) {
            nuevoDia = 1;
            nuevoMes = fecha.mes + 1;
            if (nuevoMes > 12) {
                nuevoMes = 1;
                nuevoAgno += 1;
            }
        }


        System.out.println("Fecha actual: " + String.format("%02d/%02d/%d", fecha.dia, fecha.mes, fecha.agno));
        System.out.println("Fecha siguiente: " + String.format("%02d/%02d/%d", nuevoDia, nuevoMes, nuevoAgno));
    }
}
