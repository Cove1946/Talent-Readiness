import dosw.bitacora.Corte2.Patrones.Reportes.PDFReport;
import dosw.bitacora.Corte2.Patrones.Reportes.PDFReportFactory;
import dosw.bitacora.Corte2.Patrones.Reportes.Report;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PDFReportFactoryTest {

    private PDFReportFactory factory;

    @BeforeEach
    void setUp() {
        factory = new PDFReportFactory();
    }

    @Test
    @DisplayName("PDFReportFactory debe crear una instancia de PDFReport")
    void testCreateReportReturnsPDFReport() {
        Report report = factory.createReport("contenido");
        assertInstanceOf(PDFReport.class, report);
    }

    @Test
    @DisplayName("PDFReportFactory generateReport debe contener prefijo PDF")
    void testGenerateReportContainsPDFPrefix() {
        String result = factory.generateReport("contenido");
        assertTrue(result.contains("[PDF]"));
    }

    @Test
    @DisplayName("PDFReportFactory debe preservar el contenido del reporte")
    void testCreateReportPreservesContent() {
        Report report = factory.createReport("mi contenido");
        assertTrue(report.getContent().contains("mi contenido"));
    }
}