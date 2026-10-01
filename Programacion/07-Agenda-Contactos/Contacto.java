import java.util.Objects;

class Contacto implements Comparable<Contacto> {
    private String nombre;
    private String telefono;
    private String email;

    Contacto(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    String getNombre() { return nombre; }
    String getTelefono() { return telefono; }
    String getEmail() { return email; }

    void setTelefono(String telefono) { this.telefono = telefono; }
    void setEmail(String email) { this.email = email; }

    /** Un teléfono es válido si tiene 9 dígitos */
    static boolean telefonoValido(String telefono) {
        return telefono != null && telefono.matches("[0-9]{9}");
    }

    /** Línea que se guarda en el fichero: nombre;telefono;email */
    String toLinea() {
        return nombre + ";" + telefono + ";" + email;
    }

    static Contacto desdeLinea(String linea) {
        String[] partes = linea.split(";");
        if (partes.length != 3) {
            throw new IllegalArgumentException("Línea mal formada: " + linea);
        }
        return new Contacto(partes[0], partes[1], partes[2]);
    }

    @Override
    public int compareTo(Contacto otro) {
        return nombre.compareToIgnoreCase(otro.nombre);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contacto)) return false;
        return nombre.equalsIgnoreCase(((Contacto) o).nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase());
    }

    @Override
    public String toString() {
        return String.format("%-15s %-10s %s", nombre, telefono, email);
    }
}
