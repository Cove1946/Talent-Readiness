package dosw.bitacora.Semana3.patrones.Composite;

public class Product implements Item {

    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }


    @Override
    public double getPrecio() {
        return price;
    }

    public String getNombre() {
        return name;
    }
}
