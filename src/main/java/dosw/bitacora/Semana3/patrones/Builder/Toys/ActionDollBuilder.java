package dosw.bitacora.Semana3.patrones.Builder.Toys;

public class ActionDollBuilder implements ToyDollBuilder {

    private ToyDoll doll;

    public ActionDollBuilder(){
        this.doll = new ToyDoll();
    }


    @Override
    public void buildHead() {
        doll.setBody("Action head");

    }

    @Override
    public void buildBody() {
        doll.setBody("Muscular Body");
    }

    @Override
    public void buildArms() {
        doll.setArms("Strong Arms");
    }

    @Override
    public void buildLegs() {
        doll.setLegs("Strong Legs");

    }

    @Override
    public void addAccessories() {
        doll.setHasAccessories(true);
    }

    public ToyDoll getResult(){
        return doll;
    }
}
