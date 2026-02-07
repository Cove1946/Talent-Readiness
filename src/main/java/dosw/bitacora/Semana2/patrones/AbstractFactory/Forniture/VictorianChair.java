package dosw.bitacora.Semana2.patrones.AbstractFactory.Forniture;

public class VictorianChair implements Chair {


    @Override
    public void sitOn() {
        System.out.println("Estas sentado en una silla victoriana");
    }

    @Override
    public void hasLegs() {
        System.out.println("La silla tiene 4 patas largas");
    }
}
