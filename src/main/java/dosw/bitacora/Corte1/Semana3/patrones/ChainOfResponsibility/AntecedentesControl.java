package dosw.bitacora.Corte1.Semana3.patrones.ChainOfResponsibility;

public class AntecedentesControl extends ControlMigratorioHandler {

    @Override
    public void procesar(IngresoRequest request) {
        System.out.println("Verificando antecedentes...");

        if (!request.isAntecedentesLimpios()) {
            System.out.println("Ingreso rechazado: Antecedentes negativos.");
            return;
        }

        procesarSiguiente(request);
    }
}
