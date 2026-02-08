package dosw.bitacora.Semana2.patrones.Builder.Toys;

public class Main {
    public static void main(String[] args) {

        ToyFactory factory = new ToyFactory();

        ActionDollBuilder actionBuilder = new ActionDollBuilder();
        factory.constructorDoll(actionBuilder);
        ToyDoll actionDoll = actionBuilder.getResult();


        ClassicDollBuilder classicBuilder = new ClassicDollBuilder();
        factory.constructorDoll(classicBuilder);
        ToyDoll classicDoll = classicBuilder.getResult();

        actionDoll.showInfo();
        classicDoll.showInfo();

    }
}
