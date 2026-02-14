package dosw.bitacora.Semana2.patrones.ChainOfResponsibility;

public class AprobacionFinalControl extends ControlMigratorioHandler {

    @Override
    public void processar(IngresoRequest request) {
        request.setAprobado(true);
        System.out.println("Ingreso aprobado por migración.");
    }
}