import dosw.bitacora.Corte2.Patrones.Reportes.JSONReport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JSONReportTest {

    private JSONReport report;

    @BeforeEach
    void setUp() {
        report = new JSONReport("{\"key\": \"value\"}");
    }

    @Test
    @DisplayName("JSONReport debe contener el prefijo JSON en generate")
    void testGenerateContainsJSONPrefix() {
        String result = report.generate();
        assertTrue(result.contains("[JSON]"));
    }

    @Test
    @DisplayName("JSONReport debe contener el contenido en generate")
    void testGenerateContainsContent() {
        String result = report.generate();
        assertTrue(result.contains("key"));
    }

    @Test
    @DisplayName("JSONReport getContent debe retornar el contenido original")
    void testGetContentReturnsOriginalContent() {
        assertTrue(report.getContent().contains("key"));
    }

    @Test
    @DisplayName("JSONReport no debe lanzar excepcion con contenido vacio")
    void testGenerateWithEmptyContent() {
        JSONReport emptyReport = new JSONReport("");
        assertDoesNotThrow(() -> emptyReport.generate());
    }
}