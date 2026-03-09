package dosw.bitacora.Corte1.Semana3.patrones.Decorator;

public class BarcoBase implements Barco{
    @Override
    public String getDescripcion() {
        return "Barco Base";
    }

    @Override
    public int poderAtaque() {
        return 30;
    }

    @Override
    public int defensa() {
        return 30;
    }
}
