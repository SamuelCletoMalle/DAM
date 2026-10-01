public class Alumno {
    String nombre; // Nombre del alumno
    int notas[]; // Array para almacenar las notas del alumno

    // Constructor que recibe una cadena con el nombre y las notas
    Alumno(String s) {
        String nombreyNotas[] = s.split(":"); // Dividir la cadena en nombre y notas usando ":" como delimitador
        nombre = nombreyNotas[0].trim(); // Asignar el nombre, eliminando espacios en blanco
        String[] notasString = nombreyNotas[1].split(";"); // Dividir la parte de las notas usando ";" como delimitador
        notas = new int[notasString.length]; // Inicializar el array de notas con la longitud correspondiente
        for (int i = 0; i < notas.length; i++)
            notas[i] = Integer.parseInt(notasString[i].trim()); // Convertir cada nota a entero y almacenarla en el array
    }

    // Método para calcular la nota media del alumno
    double notaMedia() {
        double media = 0; // Inicializar la media a 0
        for (int i = 0; i < notas.length; i++)
            media += notas[i]; // Sumar todas las notas
        media = media / notas.length; // Calcular la media dividiendo por el número de notas
        return media; // Retornar la media calculada
    }

    // Método para representar el objeto como una cadena
    public String toString() {
        return nombre + " -> " + notaMedia(); // Retornar el nombre y la nota media en un formato legible
    }
}