import dosw.bitacora.Corte2.Patrones.Reportes.CSVReport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CSVReportTest {

    private CSVReport report;

    @BeforeEach
    void setUp() {
        report = new CSVReport("col1,col2,col3");
    }

    @Test
    @DisplayName("CSVReport debe contener el prefijo CSV en generate")
    void testGenerateContainsCSVPrefix() {
        String result = report.generate();
        assertTrue(result.contains("[CSV]"));
    }

    @Test
    @DisplayName("CSVReport debe contener el contenido en generate")
    void testGenerateContainsContent() {
        String result = report.generate();
        assertTrue(result.contains("col1,col2,col3"));
    }

    @Test
    @DisplayName("CSVReport getContent debe retornar el contenido original")
    void testGetContentReturnsOriginalContent() {
        assertEquals("col1,col2,col3", report.getContent());
    }

    @Test
    @DisplayName("CSVReport no debe lanzar excepcion con contenido vacio")
    void testGenerateWithEmptyContent() {
        CSVReport emptyReport = new CSVReport("");
        assertDoesNotThrow(() -> emptyReport.generate());
    }
}