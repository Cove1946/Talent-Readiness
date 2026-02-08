package dosw.bitacora.Semana2.patrones.Adapter.Gasolinera;

public class FastChargerAdapter implements FuelService {

    private FastElectricCharger charger;

    public FastChargerAdapter(FastElectricCharger charger){
        this.charger = charger;
    }

    private double convertLitersToKWh(int liters) {
        return liters * 8.0;
    }

    @Override
    public void supply(int liters) {
        double kWh = convertLitersToKWh(liters);
        charger.fastCharguer(kWh);

    }
}
