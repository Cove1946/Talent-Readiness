package dosw.bitacora.Corte2.Patrones.Reportes;

public class PDFReportFactory extends ReportFactory {

    @Override
    public Report createReport(String content) {
        System.out.println("[PDFReportFactory] Creando reporte PDF");
        return new PDFReport(content);
    }
}
