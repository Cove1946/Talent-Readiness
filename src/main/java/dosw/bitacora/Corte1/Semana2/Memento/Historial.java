package dosw.bitacora.Corte1.Semana2.Memento;
import java.util.ArrayList;
import java.util.List;

public class Historial {

    private List<Memento> historial;

    public Historial() {
        historial = new ArrayList<>();
    }

    public void guardar(Memento memento) {
        historial.add(memento);
    }

    public Memento deshacer() {
        if (historial.isEmpty()) {
            return null;
        }

        int ultimoIndice = historial.size() - 1;
        Memento ultimo = historial.get(ultimoIndice);

        historial.remove(ultimoIndice);

        return ultimo;
    }
}