import dosw.bitacora.Corte2.Patrones.Reportes.JSONReport;
import dosw.bitacora.Corte2.Patrones.Reportes.JSONReportFactory;
import dosw.bitacora.Corte2.Patrones.Reportes.Report;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JSONReportFactoryTest {

    private JSONReportFactory factory;

    @BeforeEach
    void setUp() {
        factory = new JSONReportFactory();
    }

    @Test
    @DisplayName("JSONReportFactory debe crear una instancia de JSONReport")
    void testCreateReportReturnsJSONReport() {
        Report report = factory.createReport("contenido");
        assertInstanceOf(JSONReport.class, report);
    }

    @Test
    @DisplayName("JSONReportFactory generateReport debe contener prefijo JSON")
    void testGenerateReportContainsJSONPrefix() {
        String result = factory.generateReport("contenido");
        assertTrue(result.contains("[JSON]"));
    }

    @Test
    @DisplayName("JSONReportFactory debe preservar el contenido del reporte")
    void testCreateReportPreservesContent() {
        Report report = factory.createReport("mi contenido json");
        assertTrue(report.getContent().contains("mi contenido json"));
    }
}