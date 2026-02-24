package dosw.bitacora.Semana3.patrones.Composite;

import java.util.ArrayList;
import java.util.List;

public class Box implements Item {

    private String name;
    private List<Item> items = new ArrayList<>();

    public Box(String name) {
        this.name = name;
    }

    public void add(Item item) {
        items.add(item);
    }

    public void remove(Item item) {
        items.remove(item);
    }

    public List<Item> getItems() {
        return items;
    }



    @Override
    public double getPrecio() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrecio();
        }
        return total;
    }

    public String getNombre() {
        return name;
    }
}
