package dosw.bitacora.Corte1.Semana3.patrones.ChainOfResponsibility;

public class PasaporteControl extends ControlMigratorioHandler {

    @Override
    public void procesar(IngresoRequest request) {
        System.out.println("Revisando pasaporte y visa...");

        if (!request.isPasaporteValido()) {
            System.out.println("Ingreso rechazado: Pasaporte o visa inválida.");
            return;
        }

        procesarSiguiente(request);
    }

}
