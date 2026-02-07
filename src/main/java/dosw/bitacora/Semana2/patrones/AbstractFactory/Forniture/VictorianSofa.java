package dosw.bitacora.Semana2.patrones.AbstractFactory.Forniture;

public class VictorianSofa implements Sofa {


    @Override
    public void lyingDown() {
        System.out.println("Estas acostado en un sofa Victoriano");
    }

    @Override
    public void hasLegs() {
        System.out.println("La mesa tiene 4 patas");
    }
}
