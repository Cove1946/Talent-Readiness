import dosw.bitacora.Corte2.Patrones.Reportes.CSVReportBuilder;
import dosw.bitacora.Corte2.Patrones.Reportes.JSONReportBuilder;
import dosw.bitacora.Corte2.Patrones.Reportes.PDFReportBuilder;
import dosw.bitacora.Corte2.Patrones.Reportes.Report;
import dosw.bitacora.Corte2.Patrones.Reportes.ReportDirector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReportDirectorTest {

    @Test
    @DisplayName("Director debe construir reporte PDF completo con todas las secciones")
    void testBuildFullPDFReport() {
        ReportDirector director = new ReportDirector(new PDFReportBuilder());
        Report report = director.buildFullReport();

        String content = report.getContent();
        assertTrue(content.contains("INFO GENERAL") || content.contains("Info"));
        assertTrue(content.contains("ESTADÍSTICAS") || content.contains("Usuarios"));
        assertTrue(content.contains("DETALLE") || content.contains("TX"));
        assertTrue(content.contains("RESUMEN") || content.contains("Total"));
    }

    @Test
    @DisplayName("Director debe construir reporte CSV resumen solo con info y resumen")
    void testBuildSummaryCSVReport() {
        ReportDirector director = new ReportDirector(new CSVReportBuilder());
        Report report = director.buildSummaryReport();

        String content = report.getContent();
        assertTrue(content.contains("INFO_GENERAL"));
        assertTrue(content.contains("RESUMEN_FINAL"));
        assertFalse(content.contains("ESTADISTICAS"));
        assertFalse(content.contains("DETALLE_TRANSACCIONES"));
    }

    @Test
    @DisplayName("Director debe construir reporte JSON completo correctamente")
    void testBuildFullJSONReport() {
        ReportDirector director = new ReportDirector(new JSONReportBuilder());
        Report report = director.buildFullReport();

        String content = report.getContent();
        assertTrue(content.contains("infoGeneral"));
        assertTrue(content.contains("estadisticas"));
        assertTrue(content.contains("detalleTransacciones"));
        assertTrue(content.contains("resumenFinal"));
    }

    @Test
    @DisplayName("Director no debe lanzar excepcion al construir reporte")
    void testBuildReportDoesNotThrow() {
        ReportDirector director = new ReportDirector(new PDFReportBuilder());
        assertDoesNotThrow(() -> director.buildFullReport());
    }
}