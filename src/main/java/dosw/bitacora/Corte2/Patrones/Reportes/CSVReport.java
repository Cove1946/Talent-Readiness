package dosw.bitacora.Corte2.Patrones.Reportes;

public class CSVReport implements Report {

    private String content;

    public CSVReport(String content) {
        this.content = content;
    }

    @Override
    public String generate() {
        return "[CSV] Generando reporte CSV:\n" + content;
    }

    @Override
    public String getContent() {
        return content;
    }
}
