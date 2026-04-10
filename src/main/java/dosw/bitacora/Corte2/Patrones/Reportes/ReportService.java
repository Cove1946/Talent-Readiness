package dosw.bitacora.Corte2.Patrones.Reportes;

public class ReportService {

    private ReportFactory factory;
    private ReportDirector director;

    public ReportService(ReportFactory factory, ReportBuilder builder) {
        this.factory = factory;
        this.director = new ReportDirector(builder);
    }

    public Report generateFullReport() {
        System.out.println("\n-- Construyendo reporte completo --");
        return director.buildFullReport();
    }

    public Report generateSummaryReport() {
        System.out.println("\n-- Construyendo reporte resumen --");
        return director.buildSummaryReport();
    }

    public Report generateFromContent(String content) {
        System.out.println("\n-- Generando reporte desde contenido --");
        return factory.createReport(content);
    }
}
