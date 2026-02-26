package dosw.bitacora.Semana3.patrones.Bridge;

public class Main {
    public static void main(String[] args) {
        Form circuloRojo = new Circle(new Red());
        Form cuadradoRojo = new Square(new Red());

        Form circuloAzul = new Circle(new Blue());
        Form cuadradoAzul = new Square(new Blue());

        circuloAzul.draw();
        circuloRojo.draw();

        cuadradoAzul.draw();
        circuloRojo.draw();
    }


}
