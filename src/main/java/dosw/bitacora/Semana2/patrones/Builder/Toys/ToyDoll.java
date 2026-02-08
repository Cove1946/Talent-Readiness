package dosw.bitacora.Semana2.patrones.Builder.Toys;

public class ToyDoll {

    private String head;
    private String body;
    private String arms;
    private String legs;
    private boolean hasAccessories;

    public void setHead(String head) {
        this.head = head;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setArms(String arms) {
        this.arms = arms;
    }

    public void setLegs(String legs) {
        this.legs = legs;
    }

    public void setHasAccessories(boolean hasAccessories) {
        this.hasAccessories = hasAccessories;
    }

    public void showInfo() {
        System.out.println("ToyDoll {");
        System.out.println(" head = " + head);
        System.out.println(" body = " + body);
        System.out.println(" arms = " + arms);
        System.out.println(" legs = " + legs);
        System.out.println(" accessories = " + hasAccessories);
        System.out.println("}");
    }
}
