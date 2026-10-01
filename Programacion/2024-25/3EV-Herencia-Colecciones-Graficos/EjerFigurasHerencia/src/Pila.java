import java.util.Vector;

public class Pila {
    private Vector<ItfFigura> elementos;

    public Pila() {
        elementos = new Vector<>();
    }

    public void insertar(ItfFigura figura) {
        elementos.add(figura); // Agrega un elemento arriba de la pila
    }

    public ItfFigura recuperar() {
        if (!estaVacia()) {
            return elementos.remove(elementos.size() - 1); // Elimina y devuelve el último elemento
        }
        return null;
    }

    public boolean estaVacia() {
        return elementos.isEmpty();
    }
}