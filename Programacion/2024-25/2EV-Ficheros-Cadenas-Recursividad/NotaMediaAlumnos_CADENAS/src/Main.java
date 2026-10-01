public class Main {
    public static void main(String[] args) {

        String input = "Juan: 9; 1; 6# Ana: 9;1;5";

        String[] alumnos = input.split("#");


        for (int i = 0; i < alumnos.length; i++) {
            String alumno = alumnos[i];
            String[] partes = alumno.split(":");
            String nombre = partes[0].trim();
            String[] notasStr = partes[1].trim().split(";");

            int suma = 0;
          
            for (int j = 0; j < notasStr.length; j++) {
                suma += Integer.parseInt(notasStr[j].trim());
            }

            double media = (double) suma / notasStr.length;

            System.out.printf("%s -> %.2f%n", nombre, media);
        }
    }
}
