package dosw.bitacora.Corte1.Semana3.patrones.ChainOfResponsibility;

public class AprobacionFinalControl extends ControlMigratorioHandler {

    @Override
    public void procesar(IngresoRequest request) {
        System.out.println("Aprobación final por migración...");

        request.setAprobado(true);

        System.out.println("Ingreso aprobado. Bienvenido a Estados Unidos.");
    }
}