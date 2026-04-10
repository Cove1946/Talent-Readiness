import dosw.bitacora.Corte2.Patrones.Reportes.PDFReport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PDFReportTest {

    private PDFReport report;

    @BeforeEach
    void setUp() {
        report = new PDFReport("Contenido de prueba");
    }

    @Test
    @DisplayName("PDFReport debe contener el prefijo PDF en generate")
    void testGenerateContainsPDFPrefix() {
        String result = report.generate();
        assertTrue(result.contains("[PDF]"));
    }

    @Test
    @DisplayName("PDFReport debe contener el contenido en generate")
    void testGenerateContainsContent() {
        String result = report.generate();
        assertTrue(result.contains("Contenido de prueba"));
    }

    @Test
    @DisplayName("PDFReport getContent debe retornar el contenido original")
    void testGetContentReturnsOriginalContent() {
        assertEquals("Contenido de prueba", report.getContent());
    }

    @Test
    @DisplayName("PDFReport no debe lanzar excepcion con contenido vacio")
    void testGenerateWithEmptyContent() {
        PDFReport emptyReport = new PDFReport("");
        assertDoesNotThrow(() -> emptyReport.generate());
    }
}