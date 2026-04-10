package dosw.bitacora.Corte2.Patrones.Reportes;

public class CSVReportFactory extends ReportFactory {

    @Override
    public Report createReport(String content) {
        System.out.println("[CSVReportFactory] Creando reporte CSV");
        return new CSVReport(content);
    }
}