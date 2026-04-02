package dosw.bitacora.Corte2.Patrones.Reportes;

public class DigitalSignatureDecorator extends ReportDecorator {

    public DigitalSignatureDecorator(Report report) {
        super(report);
    }

    @Override
    public String generate() {
        return wrappee.generate() + "\n[FIRMA DIGITAL] Reporte firmado digitalmente.";
    }

    @Override
    public String getContent() {
        return wrappee.getContent() + "\n[FIRMA DIGITAL]";
    }
}