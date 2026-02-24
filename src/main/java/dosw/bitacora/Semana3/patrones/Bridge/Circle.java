package dosw.bitacora.Semana3.patrones.Bridge;

public class Circle extends Form{

    public Circle(Color color){
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("Dibujando circulo en ");
        color.applyColor();
    }
}
