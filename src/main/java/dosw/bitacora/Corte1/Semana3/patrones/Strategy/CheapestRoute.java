package dosw.bitacora.Corte1.Semana3.patrones.Strategy;

public class CheapestRoute implements RouteStrategy{

    @Override
    public void calculateRoute() {
        System.out.println("Calculando la ruta mas economica...");
    }

}
