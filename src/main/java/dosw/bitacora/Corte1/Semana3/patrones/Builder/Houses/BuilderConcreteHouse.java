package dosw.bitacora.Corte1.Semana3.patrones.Builder.Houses;

import java.util.ArrayList;
import java.util.List;

public class BuilderConcreteHouse implements BuilderHouse {

    private House result;
    private List<String> extras = new ArrayList<>();

    @Override
    public void reset() {
        this.result = new House();
    }

    @Override
    public void BuilderGareje(boolean yesOrNo) {
        result.setGaraje(yesOrNo);
    }

    @Override
    public void BuilderMaterial(String material) {
        result.setMaterial(material);
    }

    @Override
    public void BuilderWalls(int amount) {
        result.setWalls(amount);
    }

    @Override
    public void BuilderDoors(int amount) {
        result.setDoors(amount);
    }

    @Override
    public void BuilderRoof(boolean yesOrNo) {
        result.setRoof(yesOrNo);
    }

    @Override
    public void BuilderPool(boolean yesOrNo) {
        result.setPool(yesOrNo);
    }

    @Override
    public void BuilderGarden(boolean yesOrNo) {
        result.setGarden(yesOrNo);
    }

    @Override
    public void BuilderExtra(String extra) {
        this.extras.add(extra);
        result.setExtras(extras);

    }

    public House getResult() {
        return result;
    }
}
