package dosw.bitacora.Semana2.patrones.Builder.Houses;


public class main {
    public static void main(String[] args) {

        BuilderConcreteHouse builder = new BuilderConcreteHouse();

        BuilderDirector director = new BuilderDirector(builder);

        director.BuilderHouseGarden();
        House house1 = builder.getResult();
        System.out.println("House 1:" + house1.toString());

        director.BuilderHousePoor();
        House house2 = builder.getResult();
        System.out.println("House 2:" + house2.toString());

        director.BuilderHouseSimple();
        House house3 = builder.getResult();
        System.out.println("House 3:" + house1.toString());



    }
}
