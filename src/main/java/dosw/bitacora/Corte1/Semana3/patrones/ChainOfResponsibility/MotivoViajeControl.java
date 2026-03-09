package dosw.bitacora.Corte1.Semana3.patrones.ChainOfResponsibility;

public class MotivoViajeControl extends ControlMigratorioHandler {

    @Override
    public void procesar(IngresoRequest request) {
        System.out.println("Evaluando motivo del viaje...");

        if (!request.isMotivoValido()) {
            System.out.println("Ingreso rechazado: Motivo de viaje no válido.");
            return;
        }

        procesarSiguiente(request);
    }
}
