package dosw.bitacora.Corte2.Patrones.Reportes;

public class JSONReport implements Report {

    private String content;

    public JSONReport(String content) {
        this.content = content;
    }

    @Override
    public String generate() {
        return "[JSON] Generando reporte JSON:\n" + content;
    }

    @Override
    public String getContent() {
        return content;
    }
}
