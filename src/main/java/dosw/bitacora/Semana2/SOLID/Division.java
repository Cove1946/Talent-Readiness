package dosw.bitacora.Semana2.SOLID;

public class Division implements Operacion{

    @Override
    public double calcular(double a, double b) {
        if (b == 0) {
            System.out.println("No se puede dividir por cero");
        }
        return a / b;
    }

}
