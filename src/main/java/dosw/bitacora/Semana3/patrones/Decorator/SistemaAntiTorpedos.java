package dosw.bitacora.Semana3.patrones.Decorator;

public class SistemaAntiTorpedos extends BarcoBaseDecorador{

    public SistemaAntiTorpedos(Barco barco) {
        super(barco);
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + "Sistema Antitorpedos";
    }

    @Override
    public int defensa() {
        return super.defensa() + 20;
    }
}
