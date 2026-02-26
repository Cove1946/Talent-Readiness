package dosw.bitacora.Semana3.patrones.Strategy;

public class NavigationApp {

    private RouteStrategy routeStrategy;

    public NavigationApp(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public void setRouteStrategy(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public void startNavigation() {
        System.out.println("Iniciando navegacion...");
        routeStrategy.calculateRoute();
    }

}
