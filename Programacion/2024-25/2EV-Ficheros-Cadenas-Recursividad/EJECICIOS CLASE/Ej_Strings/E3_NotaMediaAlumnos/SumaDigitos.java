public class SumaDigitos {
    public static void main(String[] args) {
        String cadena = "Juan gana 244, y Ana 823";
        int suma = 0;
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            //if (caracter >= '0' && caracter <= '9')
            if (Character.isDigit(caracter)) {
                suma += Character.getNumericValue(caracter);
             //   suma+=Integer.parseInt(caracter+"");
            }
        }
        System.out.println("La suma de los dígitos en la cadena es: " + suma);
    }
}