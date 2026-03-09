package dosw.bitacora.Corte1.Semana3.patrones.Bridge;

abstract class Form {

    protected Color color;

    public Form(Color color){
        this.color = color;
    }

    public abstract void draw();
}
