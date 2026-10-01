public class CifradoCesar {

    public static void main(String[] args) {

        String texto = "Hola zana";

        int codigo = 3;


        String textoEncriptado = encriptar(texto, codigo);
        System.out.println("Texto encriptado: " + textoEncriptado);


        String textoDesencriptado = desencriptar(textoEncriptado, codigo);
        System.out.println("Texto desencriptado: " + textoDesencriptado);
    }


    public static String encriptar(String cadena, int codigo) {
        String resultado = "";

        String alfabeto = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";


        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);

            int index = alfabeto.indexOf(c);


            if (index != -1) {

                int nuevoIndex = (index + codigo) % 52;

                resultado += alfabeto.charAt(nuevoIndex);
            } else {

                resultado += c;
            }
        }

        return resultado;
    }


    public static String desencriptar(String cadena, int codigo) {

        return encriptar(cadena, 52 - (codigo % 52));
    }
}