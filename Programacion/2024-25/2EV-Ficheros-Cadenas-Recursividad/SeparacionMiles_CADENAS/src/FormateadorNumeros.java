public class FormateadorNumeros {

    public static String formatearNumeros(String texto) {
        String[] partes = texto.split(" ");
        for (int i = 0; i < partes.length; i++) {

            if (partes[i].matches("\\d+")) {

                partes[i] = formatearNumero(partes[i]);
            }
        }


        return String.join(" ", partes);
    }

    private static String formatearNumero(String numero) {
        int longitud = numero.length();
        String resultado = numero;


        for (int i = longitud - 3; i > 0; i -= 3) {
            resultado = resultado.substring(0, i) + "." + resultado.substring(i);
        }

        return resultado;
    }

    public static void main(String[] args) {
        String texto = "En esta cadena está el número 123456 y el 12456";
        String resultado = formatearNumeros(texto);
        System.out.println(resultado);
    }
}