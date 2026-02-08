package dosw.bitacora.Semana2.patrones.Builder.Houses;

public interface BuilderHouse {

    void reset();
    void BuilderGareje(boolean yesOrNo);
    void BuilderMaterial(String material);
    void BuilderWalls(int amount);
    void BuilderDoors(int amount);
    void BuilderRoof(boolean yesOrNo);
    void BuilderPool(boolean yesOrNo);
    void BuilderGarden(boolean yesOrNo);
    void BuilderExtra(String extra);



}
