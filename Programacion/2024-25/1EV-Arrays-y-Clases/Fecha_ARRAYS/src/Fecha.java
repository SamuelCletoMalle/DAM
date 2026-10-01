public class Fecha {
    private int dia, mes, año;

    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    public boolean esBisiesto() {
        return (año % 4 == 0 && año % 100 != 0) || (año % 400 == 0);
    }

    public Fecha diaSiguiente() {
        int[] diasMes = {31, esBisiesto() ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (dia < diasMes[mes - 1]) {
            return new Fecha(dia + 1, mes, año);
        } else if (mes < 12) {
            return new Fecha(1, mes + 1, año);
        } else {
            return new Fecha(1, 1, año + 1);
        }
    }

    public static int diferenciaDias(Fecha fecha1, Fecha fecha2) {
        int dias = 0;
        Fecha menor = fecha1.año < fecha2.año || (fecha1.año == fecha2.año && fecha1.mes < fecha2.mes) ||
                (fecha1.año == fecha2.año && fecha1.mes == fecha2.mes && fecha1.dia <= fecha2.dia) ? fecha1 : fecha2;
        Fecha mayor = (menor == fecha1) ? fecha2 : fecha1;

        while (!menor.equals(mayor)) {
            menor = menor.diaSiguiente();
            dias++;
        }

        return dias;
    }

    public boolean equals(Fecha otra) {
        return dia == otra.dia && mes == otra.mes && año == otra.año;
    }

    public static void main(String[] args) {
        Fecha fecha1 = new Fecha(30, 12, 2021);
        Fecha fecha2 = new Fecha(30, 1, 2023);
        System.out.println("Diferencia de días: " + diferenciaDias(fecha1, fecha2));
    }
}
