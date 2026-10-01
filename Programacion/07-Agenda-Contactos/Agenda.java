import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Agenda {
    private final ArrayList<Contacto> contactos = new ArrayList<>();
    private final String fichero;

    Agenda(String fichero) {
        this.fichero = fichero;
    }

    boolean anadir(Contacto c) {
        if (contactos.contains(c) || !Contacto.telefonoValido(c.getTelefono())) {
            return false;
        }
        contactos.add(c);
        return true;
    }

    boolean eliminar(String nombre) {
        return contactos.remove(new Contacto(nombre, "", ""));
    }

    Contacto buscar(String nombre) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }

    List<Contacto> buscarPorPrefijo(String prefijo) {
        ArrayList<Contacto> resultado = new ArrayList<>();
        for (Contacto c : contactos) {
            if (c.getNombre().toLowerCase().startsWith(prefijo.toLowerCase())) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    void listar() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía");
            return;
        }
        ArrayList<Contacto> copia = new ArrayList<>(contactos);
        Collections.sort(copia);
        for (Contacto c : copia) {
            System.out.println(c);
        }
    }

    int size() {
        return contactos.size();
    }

    void guardar() throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fichero))) {
            for (Contacto c : contactos) {
                pw.println(c.toLinea());
            }
        }
    }

    void cargar() throws IOException {
        Path ruta = Paths.get(fichero);
        if (!Files.exists(ruta)) {
            return;
        }
        contactos.clear();
        for (String linea : Files.readAllLines(ruta)) {
            if (linea.isBlank()) continue;
            try {
                contactos.add(Contacto.desdeLinea(linea));
            } catch (IllegalArgumentException e) {
                System.out.println("Se ignora una línea: " + e.getMessage());
            }
        }
    }
}
