package dosw.bitacora.Corte1.Semana3.patrones.Builder.Toys;

public class ToyFactory {

    private ToyDollBuilder builder;

    public void constructorDoll(ToyDollBuilder builder){

        builder.buildHead();
        builder.buildBody();
        builder.buildArms();
        builder.buildLegs();
        builder.addAccessories();

    }
}
