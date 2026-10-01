package Ej7_SumaReales; // Declaración del paquete

import java.util.regex.Matcher; // Importar la clase Matcher para trabajar con expresiones regulares
import java.util.regex.Pattern; // Importar la clase Pattern para definir expresiones regulares

public class Ej7_SumaReales {
    // Método que suma los números reales encontrados en una cadena
    double SumarReales(String cadena) {
        double suma = 0; // Inicializar la suma a 0
        // Definir el patrón para encontrar números reales (incluyendo negativos y decimales)
        Pattern patReal = Pattern.compile("-?\\d+(\\.\\d+)?");
        Matcher matReal = patReal.matcher(cadena); // Crear un matcher para la cadena dada
        int i = 0; // Contador para el número de coincidencias (opcional)

        // Buscar coincidencias en la cadena
        while (matReal.find()) {
            // Obtener el número encontrado y dividirlo por el símbolo de euro (si existe)
            String cadPartida[] = matReal.group().split("€");
            // Sumar el número a la suma total
            suma += Double.parseDouble(cadPartida[0]);
            i++; // Incrementar el contador de coincidencias
        }
        return suma; // Retornar la suma total
    }

    public static void main(String[] args) {
        Ej7_SumaReales o = new Ej7_SumaReales(); // Crear una instancia de la clase
        // Cadena de ejemplo con números reales
        String cadena = "Juan ha ganado, en enero 1200.02€, en febrero 1280.02€, en marzo nada, en abril 0€ y en junio 40€";
        // Imprimir la suma de los números reales encontrados en la cadena
        System.out.println(o.SumarReales(cadena));
    }
}