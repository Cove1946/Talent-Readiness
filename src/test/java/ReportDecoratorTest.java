import dosw.bitacora.Corte2.Patrones.Reportes.CompressionDecorator;
import dosw.bitacora.Corte2.Patrones.Reportes.DigitalSignatureDecorator;
import dosw.bitacora.Corte2.Patrones.Reportes.PDFReport;
import dosw.bitacora.Corte2.Patrones.Reportes.Report;
import dosw.bitacora.Corte2.Patrones.Reportes.WatermarkDecorator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReportDecoratorTest {

    private Report baseReport;

    @BeforeEach
    void setUp() {
        baseReport = new PDFReport("Contenido base");
    }

    @Test
    @DisplayName("ReportDecorator getContent debe delegar al wrappee")
    void testGetContentDelegatesToWrappee() {
        Report decorated = new DigitalSignatureDecorator(baseReport);
        assertTrue(decorated.getContent().contains(baseReport.getContent()));
    }

    @Test
    @DisplayName("ReportDecorator generate debe delegar al wrappee")
    void testGenerateDelegatesToWrappee() {
        Report decorated = new WatermarkDecorator(baseReport);
        assertTrue(decorated.generate().contains(baseReport.generate().substring(0, 10)));
    }

    @Test
    @DisplayName("DigitalSignatureDecorator getContent debe contener FIRMA DIGITAL")
    void testDigitalSignatureGetContent() {
        Report decorated = new DigitalSignatureDecorator(baseReport);
        assertTrue(decorated.getContent().contains("[FIRMA DIGITAL]"));
    }

    @Test
    @DisplayName("WatermarkDecorator getContent debe contener MARCA DE AGUA")
    void testWatermarkGetContent() {
        Report decorated = new WatermarkDecorator(baseReport);
        assertTrue(decorated.getContent().contains("[MARCA DE AGUA]"));
    }

    @Test
    @DisplayName("CompressionDecorator getContent debe contener COMPRESION")
    void testCompressionGetContent() {
        Report decorated = new CompressionDecorator(baseReport);
        assertTrue(decorated.getContent().contains("[COMPRESIÓN]"));
    }

    @Test
    @DisplayName("Decoradores apilados getContent debe contener todas las marcas")
    void testStackedDecoratorsGetContent() {
        Report decorated = new CompressionDecorator(
                new WatermarkDecorator(
                        new DigitalSignatureDecorator(baseReport)
                )
        );
        String content = decorated.getContent();
        assertTrue(content.contains("[FIRMA DIGITAL]"));
        assertTrue(content.contains("[MARCA DE AGUA]"));
        assertTrue(content.contains("[COMPRESIÓN]"));
    }

    @Test
    @DisplayName("Decorador debe preservar contenido original en getContent")
    void testDecoratorPreservesOriginalContent() {
        Report decorated = new CompressionDecorator(baseReport);
        assertTrue(decorated.getContent().contains("Contenido base"));
    }
}