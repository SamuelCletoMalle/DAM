import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtraerDatos {

    public static void main(String[] args) {
        String texto = "Nombre José Manuel. DNI:423322333. Tlf: 685949943. email: jper@gakk.es";

        String DNIreference = "DNI:(\\d{8,9})"; // Captura 8 o 9 dígitos después de "DNI:"
        String TLFreference= "Tlf:\\s*(\\d{9})"; // Captura 9 dígitos después de "Tlf:"
        String EMAILreference= "email:\\s*([\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,})"; // Captura el email




        String dni = extraerConRegex(texto, DNIreference);
        System.out.println("DNI: " + dni);

        String tlf = extraerConRegex(texto, TLFreference);
        System.out.println("Teléfono: " + tlf);

        String email = extraerConRegex(texto, EMAILreference);
        System.out.println("Email: " + email);


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
}