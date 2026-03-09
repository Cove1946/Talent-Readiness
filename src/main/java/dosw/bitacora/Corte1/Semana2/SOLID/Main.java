package dosw.bitacora.Corte1.Semana2.SOLID;

public class Main {

    public static void main(String[] args) {

        Calculadora calculadora = new Calculadora();

        Operacion suma = new Suma();
        Operacion resta = new Resta();
        Operacion multiplicacion = new Multiplicacion();
        Operacion division = new Division();

        System.out.println("Suma: " + calculadora.calcular(suma, 8, 1));
        System.out.println("Resta: " + calculadora.calcular(resta, 12, 2));
        System.out.println("Multiplicacion: " + calculadora.calcular(multiplicacion, 8, 3));
        System.out.println("Division: " + calculadora.calcular(division, 15, 5));
    }
}