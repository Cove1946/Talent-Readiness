package dosw.bitacora.Semana2.patrones.Builder.Houses;

public class BuilderDirector {

    private BuilderHouse builder;

    public BuilderDirector(BuilderHouse builder){
        this.builder = builder;
    }

    public void otherBuilder(BuilderHouse builder){
        this.builder = builder;
    }

    //Casa con jardin y garaje sin piscina
    public void BuilderHouseGarden(){
        builder.reset();
        builder.BuilderMaterial("Ladrillo");
        builder.BuilderDoors(2);
        builder.BuilderWalls(4);
        builder.BuilderGarden(true);
        builder.BuilderGareje(true);
        builder.BuilderPool(false);
        builder.BuilderExtra("Pool Dance");
    }


    //Casa sencilla
    public void BuilderHouseSimple(){
        builder.reset();
        builder.BuilderMaterial("Concret");
        builder.BuilderDoors(2);
        builder.BuilderWalls(4);
        builder.BuilderGarden(false);
        builder.BuilderGareje(false);
        builder.BuilderPool(false);
        builder.BuilderExtra("Trees");
    }

    //Casa Pobre
    public void BuilderHousePoor(){
        builder.reset();
        builder.BuilderMaterial("Wood");
        builder.BuilderWalls(4);
        builder.BuilderGarden(false);
        builder.BuilderGareje(false);
        builder.BuilderPool(false);
    }



}
