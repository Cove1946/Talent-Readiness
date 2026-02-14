package dosw.bitacora.Semana2.patrones.ChainOfResponsibility;

public class AntecedentesControl extends ControlMigratorioHandler {

    @Override
    public void processar(IngresoRequest request) {
        if (!request.isAntecedentesLimpios()) {
            System.out.println("Ingreso rechazado: antecedentes penales.");
            return;
        }
        System.out.println("Antecedentes limpios.");
        pasarAlSiguiente(request);
    }
}