package dosw.bitacora.Semana3.patrones.Adapter.Gasolinera;

public class SlowChargerAdapter implements FuelService {

    private SlowElectricCharger charger;

    public SlowChargerAdapter(SlowElectricCharger charger) {
        this.charger = charger;
    }

    @Override
    public void supply(int liters) {
        double kWh = convertLitersToKWh(liters);
        charger.slowCharger(kWh);
    }

    private double convertLitersToKWh(int liters) {
        return liters * 7.0;
    }
}
