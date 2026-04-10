package dosw.bitacora.Corte1.Semana3.patrones.AbstractFactory.Forniture;

public class furnitureStore {
    private final Chair chair;
    private final Sofa sofa;

    public furnitureStore (FurnitureFactory factory){
        this.chair = factory.createChair();
        this.sofa = factory.createSofa();
    }

    public void infoFurniture(){
        chair.hasLegs();
        chair.sitOn();

        sofa.hasLegs();
        sofa.lyingDown();
    }

}
