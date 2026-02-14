package dosw.bitacora.Semana2.patrones.ChainOfResponsibility;

public class MotivoViajeControl extends ControlMigratorioHandler {

    @Override
    public void processar(IngresoRequest request) {
        if (!request.isMotivoValido()) {
            System.out.println("Ingreso rechazado: motivo del viaje no válido.");
            return;
        }
        System.out.println("Motivo del viaje válido.");
        pasarAlSiguiente(request);
    }
}