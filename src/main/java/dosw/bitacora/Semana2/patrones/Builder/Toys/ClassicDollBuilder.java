package dosw.bitacora.Semana2.patrones.Builder.Toys;

public class ClassicDollBuilder implements ToyDollBuilder{

    private ToyDoll doll;

    public ClassicDollBuilder(){
        this.doll = new ToyDoll();
    }

    @Override
    public void buildHead() {
        doll.setHead("Classic Head");

    }

    @Override
    public void buildBody() {
        doll.setBody("Simple Body");

    }

    @Override
    public void buildArms() {
        doll.setArms("Normal Arms");
    }

    @Override
    public void buildLegs() {
        doll.setLegs("Normal Legs");
    }

    @Override
    public void addAccessories() {
        doll.setHasAccessories(false);
    }

    public ToyDoll getResult() {
        return doll;
    }
}
