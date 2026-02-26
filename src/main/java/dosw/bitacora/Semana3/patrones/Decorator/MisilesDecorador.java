package dosw.bitacora.Semana3.patrones.Decorator;

public class MisilesDecorador extends BarcoBaseDecorador {

    public MisilesDecorador(Barco barco) {
        super(barco);
    }

    @Override
    public int poderAtaque() {
        return barco.poderAtaque() + 40;
    }

    @Override
    public String getDescripcion() {
        return barco.getDescripcion() + "Misiles ";
    }
}
