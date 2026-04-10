package dosw.bitacora.Corte2.Patrones.Reportes;

public class WatermarkDecorator extends ReportDecorator {

    public WatermarkDecorator(Report report) {
        super(report);
    }

    @Override
    public String generate() {
        return wrappee.generate() + "\n[MARCA DE AGUA] Confidencial - Solo uso interno.";
    }

    @Override
    public String getContent() {
        return wrappee.getContent() + "\n[MARCA DE AGUA]";
    }
}

