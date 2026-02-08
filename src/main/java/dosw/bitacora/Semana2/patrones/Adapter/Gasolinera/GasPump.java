package dosw.bitacora.Semana2.patrones.Adapter.Gasolinera;

public class GasPump implements FuelService{

    @Override
    public void supply(int liters) {
        System.out.println("Suministrando " + liters + " galones de gasolina");
    }
}
