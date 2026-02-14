package dosw.bitacora.Semana2.patrones.ChainOfResponsibility;

public class PasaporteControl extends ControlMigratorioHandler {

    @Override
    public void processar(IngresoRequest request) {
        if (!request.isPasaporteValido()) {
            System.out.println("Ingreso rechazado: pasaporte o visa inválidos.");
            return;
        }
        System.out.println("Pasaporte válido.");
        pasarAlSiguiente(request);
    }
}