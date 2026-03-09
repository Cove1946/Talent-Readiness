package dosw.bitacora.Corte1.Semana3.patrones.Adapter.Gasolinera;

public class GasPump implements FuelService{

    @Override
    public void supply(int liters) {
        System.out.println("Suministrando " + liters + " galones de gasolina");
    }
}
