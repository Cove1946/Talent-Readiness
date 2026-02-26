package dosw.bitacora.Semana3.patrones.AbstractFactory.Forniture;

public class ModernChair implements Chair {

    @Override
    public void sitOn() {
        System.out.println("Estas sentado en una silla moderna");
    }

    @Override
    public void hasLegs() {
        System.out.println("La silla no tiene patas");

    }
}
