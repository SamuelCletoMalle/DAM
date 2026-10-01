public class Ej3_NotaMedia {
    public static void main(String[] args) {
        // Cadena que contiene los datos de los alumnos y sus notas
        String cadena = "Juan: 3; 5; 7# Ana: 8;3#Pepe: 9;8;9";

        // Dividir la cadena en partes usando "#" como delimitador para obtener cada alumno
        String AlumnosStrings[] = cadena.split("#");

        // Iterar sobre cada cadena de alumno
        for (int i = 0; i < AlumnosStrings.length; i++) {
            // Crear un objeto Alumno a partir de la cadena correspondiente
            Alumno a = new Alumno(AlumnosStrings[i]);
            // Imprimir la representación del objeto Alumno, que incluye el nombre y la nota media
            System.out.println(a);
        }
    }
}