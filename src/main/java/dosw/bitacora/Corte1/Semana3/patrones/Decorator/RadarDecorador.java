package dosw.bitacora.Corte1.Semana3.patrones.Decorator;

public class RadarDecorador extends BarcoBaseDecorador {

    public RadarDecorador(Barco barco) {
        super(barco);
    }

    @Override
    public int poderAtaque() {
        return barco.poderAtaque() + 10;
    }

    @Override
    public String getDescripcion() {
        return barco.getDescripcion() + "Radar avanzado";
    }

}
