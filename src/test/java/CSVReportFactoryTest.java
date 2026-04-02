import dosw.bitacora.Corte2.Patrones.Reportes.CSVReport;
import dosw.bitacora.Corte2.Patrones.Reportes.CSVReportFactory;
import dosw.bitacora.Corte2.Patrones.Reportes.Report;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CSVReportFactoryTest {

    private CSVReportFactory factory;

    @BeforeEach
    void setUp() {
        factory = new CSVReportFactory();
    }

    @Test
    @DisplayName("CSVReportFactory debe crear una instancia de CSVReport")
    void testCreateReportReturnsCSVReport() {
        Report report = factory.createReport("contenido");
        assertInstanceOf(CSVReport.class, report);
    }

    @Test
    @DisplayName("CSVReportFactory generateReport debe contener prefijo CSV")
    void testGenerateReportContainsCSVPrefix() {
        String result = factory.generateReport("contenido");
        assertTrue(result.contains("[CSV]"));
    }

    @Test
    @DisplayName("CSVReportFactory debe preservar el contenido del reporte")
    void testCreateReportPreservesContent() {
        Report report = factory.createReport("col1,col2");
        assertTrue(report.getContent().contains("col1,col2"));
    }
}