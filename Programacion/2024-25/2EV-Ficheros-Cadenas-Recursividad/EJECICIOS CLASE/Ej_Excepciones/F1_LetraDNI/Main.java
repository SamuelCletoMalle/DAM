import java.util.Scanner;

public class Main {
    // Método para verificar la validez de un DNI
    boolean verificarDNI(String dni) throws Exception {
        char letra = 'A'; // Variable para almacenar la letra del DNI
        String numeroDNI = ""; // Variable para almacenar los números del DNI
        char[] letrasPosicion = new char[23]; // Array para las letras válidas según la posición
        String letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE"; // Letras válidas para el DNI

        // EXCEPCIONES
        Exception numeroCasillasExcepcion = new Exception("Número de dígitos incorrecto");
        Exception PrimerosOchoNumerosExcepcion = new Exception("Cantidad de dígitos numéricos incorrectos");
        Exception letraUltimoCaracterExcepcion = new Exception("Caracter para el último dígito incorrecto. Debe ser una letra");
        Exception letraIncorrectaDNI = new Exception("La letra es incorrecta para este DNI");

        // VERIFICAR QUE LA CADENA TIENE 9 CARACTERES
        if (dni.length() != 9) {
            throw numeroCasillasExcepcion; // Lanzar excepción si la longitud no es 9
        }

        // COMPROBAR QUE TIENE 8 NÚMEROS EN LOS 8 PRIMEROS CARACTERES
        for (int i = 0; i < 8; i++) {
            if (dni.charAt(i) >= '0' && dni.charAt(i) <= '9') {
                numeroDNI = numeroDNI + dni.charAt(i); // Concatenar los números
            } else {
                throw PrimerosOchoNumerosExcepcion; // Lanzar excepción si no es un número
            }
        }

        // COMPROBAR QUE TIENE UNA LETRA EN EL ÚLTIMO CARÁCTER
        if (!(dni.charAt(8) >= 'A' && dni.charAt(8) <= 'Z')) {
            throw letraUltimoCaracterExcepcion; // Lanzar excepción si el último carácter no es una letra
        } else {
            letra = dni.charAt(8); // Asignar la letra del DNI
        }

        // COMPROBAR QUE LA LETRA ES CORRECTA
        int numeroIntDNI = Integer.parseInt(numeroDNI); // Convertir los números a entero
        int resto = numeroIntDNI % 23; // Calcular el resto para obtener la letra correcta

        char letraCorrecta = letrasPosicion[resto]; // Obtener la letra correcta según el resto
        if (letraCorrecta != letra) {
            throw letraIncorrectaDNI; // Lanzar excepción si la letra no coincide
        } else {
            return true; // Retornar true si el DNI es válido
        }
    }

    public static void main(String[] args) {
        Main main = new Main(); // Crear una instancia de Main
        Scanner sc = new Scanner(System.in); // Crear un escáner para leer la entrada del usuario

        boolean resultado = false; // Variable para almacenar el resultado de la verificación
        do {
            System.out.println("TU DNI: "); // Solicitar al usuario que ingrese su DNI
            String dni = sc.nextLine(); // Leer el DNI ingresado
            try {
                resultado = main.verificarDNI(dni); // Verificar el DNI
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage()); // Mostrar el mensaje de error si hay una excepción
            }
        } while (!resultado); // Repetir hasta que el DNI sea válido
        System.out.println("✅ DNI: " + resultado); // Mostrar que el DNI es válido
    }
}