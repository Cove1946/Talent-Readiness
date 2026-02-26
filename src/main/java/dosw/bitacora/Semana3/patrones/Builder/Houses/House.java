package dosw.bitacora.Semana3.patrones.Builder.Houses;

import java.util.ArrayList;
import java.util.List;

public class House {

    private String material;
    private int walls;
    private int doors;
    private boolean roof;
    private boolean garaje;
    private boolean pool;
    private boolean garden;
    private List<String> extras = new ArrayList<>();



    public void setMaterial(String material) {
        this.material = material;
    }

    public void setWalls(int walls) {
        this.walls = walls;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public void setRoof(boolean roof) {
        this.roof = roof;
    }

    public void setGaraje(boolean garaje) {
        this.garaje = garaje;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    public void setGarden(boolean garden) {
        this.garden = garden;
    }

    public void setExtras(List<String> extras) {
        this.extras = extras;
    }



    public House obtainHouse(){
        return obtainHouse();
    }



    @Override
    public String toString() {
        return "House{" +
                "material='" + material + '\'' +
                ", walls=" + walls +
                ", doors=" + doors +
                ", roof=" + roof +
                ", garaje=" + garaje +
                ", pool=" + pool +
                ", garden=" + garden +
                ", extras=" + extras +
                '}';
    }
}
