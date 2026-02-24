package dosw.bitacora.Semana3.patrones.AbstractFactory.Forniture;

public class main {
    public static void main(String[] args) {
        FurnitureFactory factory = new ModernFurnitureFactory();
        FurnitureFactory factory1 = new VictorianFurnitureFactory();

        furnitureStore store = new furnitureStore(factory);
        store.infoFurniture();


        furnitureStore store1 = new furnitureStore(factory1);
        store1.infoFurniture();

    }
}
