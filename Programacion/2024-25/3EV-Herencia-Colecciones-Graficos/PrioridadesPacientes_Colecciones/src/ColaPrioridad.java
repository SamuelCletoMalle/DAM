import java.util.PriorityQueue;
import java.util.Comparator;

public class ColaPrioridad<T extends Paciente> {
    private PriorityQueue<T> cola;

    public ColaPrioridad() {
        cola = new PriorityQueue<>(new Comparator<T>() {
            @Override
            public int compare(T p1, T p2) {
                if (p1.getGravedad() != p2.getGravedad()) {
                    return Integer.compare(p1.getGravedad(), p2.getGravedad()); // menor gravedad = más prioridad
                } else {
                    return Long.compare(p1.getTiempoIngreso(), p2.getTiempoIngreso()); // más antiguo = más prioridad
                }
            }
        });
    }

    public void ingresar(T elemento) {
        cola.offer(elemento);
    }

    public T atender() {
        return cola.poll();
    }

    public boolean estaVacia() {
        return cola.isEmpty();
    }
}
