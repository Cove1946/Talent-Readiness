package dosw.bitacora.Semana2.patrones.Decorator;

public abstract class BarcoBaseDecorador implements Barco {

    protected Barco barco;

    public BarcoBaseDecorador(Barco barco) {
        this.barco = barco;
    }

    @Override
    public String getDescripcion() {
        return barco.getDescripcion();
    }

    @Override
    public int poderAtaque() {
        return barco.poderAtaque();
    }

    @Override
    public int defensa() {
        return barco.defensa();
    }
}
