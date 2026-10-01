class DniException {
    private String message;

    public DniException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
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
