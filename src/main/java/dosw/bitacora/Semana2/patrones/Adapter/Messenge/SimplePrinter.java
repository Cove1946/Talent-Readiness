package dosw.bitacora.Semana2.patrones.Adapter.Messenge;

public class SimplePrinter implements MessagePrinter {

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
