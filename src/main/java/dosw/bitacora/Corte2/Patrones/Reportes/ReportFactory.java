package dosw.bitacora.Corte2.Patrones.Reportes;

public abstract class ReportFactory {

    public abstract Report createReport(String content);

    public String generateReport(String content) {
        Report report = createReport(content);
        return report.generate();
    }
}
