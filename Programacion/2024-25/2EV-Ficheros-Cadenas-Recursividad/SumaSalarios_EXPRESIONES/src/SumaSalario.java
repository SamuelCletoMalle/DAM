import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SumaSalarios {

    public static void main(String[] args) {
        String texto = "Juan ha ganado, en enero 1200.02€, en febrero 2400.23€, en marzo nada, en abril 0€ y en junio 40€";

        String ENEROreference = "enero \\s* (\\d)"; // Captura numeros enero
        String FEBREROreference= "febrero:\\s*(\\d)"; // Captura numeros febrero
        String MARZOreference= "marzo:\\s*(\\d)"; // Captura numeros marzo
        String ABRILreference= "abril:\\s*(\\d)"; // Captura numeros abril
        String JUNIOreference= "junio:\\s*(\\d)"; // Captura numeros junio




        String salario = extraerConRegex(texto, ENEROreference, FEBREROreference, MARZOreference, ABRILreference, JUNIOreference);
        System.out.println("DNI: " + salario);

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