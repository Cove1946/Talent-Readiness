package dosw.bitacora.Corte1.Semana3.patrones.Bridge;

public class Square extends Form {

    public Square(Color color){
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("Dibujando cuadrado en");
        color.applyColor();
    }
}
