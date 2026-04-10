package dosw.bitacora.Corte1.Semana3.patrones.AbstractFactory.Forniture;

public class VictorianFurnitureFactory implements FurnitureFactory{

    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }
}
