package dosw.bitacora.Semana2.patrones.AbstractFactory.Forniture;

public class ModernSofa implements Sofa {
    @Override
    public void lyingDown() {
        System.out.println("Estas acostado en un sofa moderno \n");
    }

    @Override
    public void hasLegs() {
        System.out.println("La silla tiene 3 patas cortas");
    }
}
