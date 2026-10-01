public class Main {
    // Método para mostrar los elementos de un array de cadenas
    static void mostrar(String vs[]) {
        for (int i = 0; i < vs.length; i++) { // Iterar sobre cada elemento del array
            System.out.println(":" + vs[i] + ":"); // Imprimir el elemento con dos puntos alrededor
        }
    }

    public static void main(String[] args) {
        String s = "44   23"; // Cadena de entrada con números separados por espacios
        StringBuffer sb = new StringBuffer(); // Crear un StringBuffer para construir la salida
        String vs[] = s.split(" "); // Dividir la cadena en un array usando el espacio como delimitador
        mostrar(vs); // Llamar al método mostrar para imprimir los elementos del array

        // Iterar sobre cada elemento del array
        for (int i = 0; i < vs.length; i++) {
            System.out.println(i + ":" + vs[i] + ":"); // Imprimir el índice y el elemento actual
            if (vs[i] != null && !vs[i].isEmpty()) { // Verificar que el elemento no sea nulo ni vacío
                double d = Integer.parseInt(vs[i]) / 2.0; // Convertir el elemento a entero y dividirlo por 2
                // Verificar si el resultado es un número entero
                if (d - (int) d == 0)
                    sb.insert(sb.length(), (int) d); // Si es entero, agregarlo como entero al StringBuffer
                else
                    sb.insert(sb.length(), d); // Si no es entero, agregarlo como double
            } else
                sb.insert(sb.length(), " "); // Si el elemento es nulo o vacío, agregar un espacio
        }

        String res = sb.toString(); // Convertir el StringBuffer a String
        System.out.println(res); // Imprimir el resultado final
    }
}