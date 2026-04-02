package dosw.bitacora.Corte2.Patrones.Reportes;

public class JSONReportFactory extends ReportFactory {

    @Override
    public Report createReport(String content) {
        System.out.println("[JSONReportFactory] Creando reporte JSON");
        return new JSONReport(content);
    }
}