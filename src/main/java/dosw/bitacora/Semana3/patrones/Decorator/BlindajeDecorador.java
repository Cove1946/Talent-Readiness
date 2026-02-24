package dosw.bitacora.Semana3.patrones.Decorator;

public class BlindajeDecorador extends BarcoBaseDecorador {

    public BlindajeDecorador(Barco barco) {
        super(barco);
    }

    @Override
    public String getDescripcion() {
        return barco.getDescripcion() + "Blindaje refozado";
    }

    @Override
    public int defensa() {
        return barco.defensa() + 30;
    }
}
