public class Palindroma {

    // Método que recibe una cadena de caracteres e indica si es o no palíndroma
    boolean esPalindroma(String s) {
        // Convertir la cadena a minúsculas y eliminar espacios
        String limpia = s.toLowerCase().replaceAll(" ", "");
        // Invertir la cadena limpia
        String reves = new StringBuilder(limpia).reverse().toString();
        // Comparar la cadena limpia con su versión invertida
        return limpia.equals(reves);
    }

    public static void main(String[] args) {
        Palindroma obj = new Palindroma(); // Crear una instancia de la clase Palindroma
        String s1 = new String("Dabale arroz a    la    zorra el abad"); // Cadena de ejemplo

        // Llamar al método esPalindroma y almacenar el resultado
        boolean s = obj.esPalindroma(s1);
        // Imprimir el resultado
        System.out.println(s1 + " es palíndroma: " + s);
    }
}