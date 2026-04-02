package dosw.bitacora.Corte2.Patrones.Reportes;

public class PDFReport implements Report {

    private String content;

    public PDFReport(String content) {
        this.content = content;
    }

    @Override
    public String generate() {
        return "[PDF] Generando reporte PDF:\n" + content;
    }

    @Override
    public String getContent() {
        return content;
    }
}
