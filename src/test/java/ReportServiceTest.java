import dosw.bitacora.Corte2.Patrones.Reportes.CSVReportBuilder;
import dosw.bitacora.Corte2.Patrones.Reportes.CSVReportFactory;
import dosw.bitacora.Corte2.Patrones.Reportes.JSONReportBuilder;
import dosw.bitacora.Corte2.Patrones.Reportes.JSONReportFactory;
import dosw.bitacora.Corte2.Patrones.Reportes.PDFReportBuilder;
import dosw.bitacora.Corte2.Patrones.Reportes.PDFReportFactory;
import dosw.bitacora.Corte2.Patrones.Reportes.Report;
import dosw.bitacora.Corte2.Patrones.Reportes.ReportService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReportServiceTest {

    @Test
    @DisplayName("ReportService debe generar reporte PDF completo")
    void testGenerateFullPDFReport() {
        ReportService service = new ReportService(
                new PDFReportFactory(),
                new PDFReportBuilder()
        );
        Report report = service.generateFullReport();
        assertNotNull(report);
        assertTrue(report.generate().contains("[PDF]"));
    }

    @Test
    @DisplayName("ReportService debe generar reporte CSV resumen")
    void testGenerateSummaryCSVReport() {
        ReportService service = new ReportService(
                new CSVReportFactory(),
                new CSVReportBuilder()
        );
        Report report = service.generateSummaryReport();
        assertNotNull(report);
        assertTrue(report.generate().contains("[CSV]"));
    }

    @Test
    @DisplayName("ReportService debe generar reporte JSON desde contenido")
    void testGenerateJSONFromContent() {
        ReportService service = new ReportService(
                new JSONReportFactory(),
                new JSONReportBuilder()
        );
        Report report = service.generateFromContent("{\"test\": \"data\"}");
        assertNotNull(report);
        assertTrue(report.generate().contains("[JSON]"));
    }

    @Test
    @DisplayName("ReportService no debe lanzar excepcion al generar reporte")
    void testGenerateReportDoesNotThrow() {
        ReportService service = new ReportService(
                new PDFReportFactory(),
                new PDFReportBuilder()
        );
        assertDoesNotThrow(() -> service.generateFullReport());
    }

    @Test
    @DisplayName("ReportService reporte completo debe tener mas contenido que el resumen")
    void testFullReportHasMoreContentThanSummary() {
        ReportService service = new ReportService(
                new PDFReportFactory(),
                new PDFReportBuilder()
        );
        Report fullReport    = service.generateFullReport();
        Report summaryReport = new ReportService(
                new PDFReportFactory(),
                new PDFReportBuilder()
        ).generateSummaryReport();

        assertTrue(
                fullReport.getContent().length() > summaryReport.getContent().length()
        );
    }
}