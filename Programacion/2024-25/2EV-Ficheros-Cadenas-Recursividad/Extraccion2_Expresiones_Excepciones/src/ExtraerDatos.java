import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ExtraerDatos {

    public static void main(String[] args) {
        String texto = "Nombre José Manuel. DNI:50255541N Tlf: 685949943. email: jper@gakk.es";

        String DNIreference = "DNI:(\\d{8}[A-Z])"; // Captura 8 dígitos seguidos de una letra
        String dni = extraerConRegex(texto, DNIreference);
        System.out.println("DNI: " + dni);

        DniException dniError = verificarDNI(dni);
        if (dniError != null) {
            System.out.println("Error en el DNI: " + dniError.getMessage());
        } else {
            System.out.println("DNI válido.");
        }


    }

    private static String extraerConRegex(String texto, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "No encontrado";
        }
    }

    private static DniException verificarDNI(String dni) {

        if (dni.length() != 9) {
            return new DniException("Número incorrecto de caracteres en el DNI.");
        }


        if (!dni.matches("\\d{8}[A-Z]")) {
            return new DniException("Carácter no válido en el DNI.");
        }


        String letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE";
        int numeroDNI = Integer.parseInt(dni.substring(0, 8));
        char letraCalculada = letrasDNI.charAt(numeroDNI % 23);
        char letraDNI = dni.charAt(8);


        if (letraDNI != letraCalculada) {
            return new DniException("Letra del DNI incorrecta.");
        }

        return null;
    }
}