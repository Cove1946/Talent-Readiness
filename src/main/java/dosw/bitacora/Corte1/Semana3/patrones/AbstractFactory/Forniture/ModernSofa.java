package dosw.bitacora.Corte1.Semana3.patrones.AbstractFactory.Forniture;

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
