package dosw.bitacora.Corte2.Patrones.Reportes;

public class CompressionDecorator extends ReportDecorator {

    public CompressionDecorator(Report report) {
        super(report);
    }

    @Override
    public String generate() {
        return wrappee.generate() + "\n[COMPRESIÓN] Reporte comprimido en formato ZIP.";
    }

    @Override
    public String getContent() {
        return wrappee.getContent() + "\n[COMPRESIÓN]";
    }
}