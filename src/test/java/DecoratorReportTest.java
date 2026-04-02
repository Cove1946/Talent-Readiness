import dosw.bitacora.Corte2.Patrones.Reportes.CompressionDecorator;
import dosw.bitacora.Corte2.Patrones.Reportes.DigitalSignatureDecorator;
import dosw.bitacora.Corte2.Patrones.Reportes.PDFReport;
import dosw.bitacora.Corte2.Patrones.Reportes.Report;
import dosw.bitacora.Corte2.Patrones.Reportes.WatermarkDecorator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecoratorReportTest {

    private Report baseReport;

    @BeforeEach
    void setUp() {
        baseReport = new PDFReport("Contenido base");
    }

    @Test
    @DisplayName("DigitalSignatureDecorator debe agregar firma al reporte")
    void testDigitalSignatureAddsSignature() {
        Report signed = new DigitalSignatureDecorator(baseReport);
        assertTrue(signed.generate().contains("[FIRMA DIGITAL]"));
    }

    @Test
    @DisplayName("WatermarkDecorator debe agregar marca de agua al reporte")
    void testWatermarkAddsMark() {
        Report watermarked = new WatermarkDecorator(baseReport);
        assertTrue(watermarked.generate().contains("[MARCA DE AGUA]"));
    }

    @Test
    @DisplayName("CompressionDecorator debe agregar compresion al reporte")
    void testCompressionAddsCompression() {
        Report compressed = new CompressionDecorator(baseReport);
        assertTrue(compressed.generate().contains("[COMPRESIÓN]"));
    }

    @Test
    @DisplayName("Decoradores apilados deben aplicar todas las decoraciones")
    void testStackedDecoratorsApplyAll() {
        Report decorated = new CompressionDecorator(
                new WatermarkDecorator(
                        new DigitalSignatureDecorator(baseReport)
                )
        );
        String result = decorated.generate();
        assertTrue(result.contains("[FIRMA DIGITAL]"));
        assertTrue(result.contains("[MARCA DE AGUA]"));
        assertTrue(result.contains("[COMPRESIÓN]"));
    }

    @Test
    @DisplayName("Decoradores deben preservar el contenido original")
    void testDecoratorsPreserveContent() {
        Report decorated = new DigitalSignatureDecorator(baseReport);
        assertTrue(decorated.generate().contains("Contenido base"));
    }

    @Test
    @DisplayName("El orden de decoradores debe respetarse en el output")
    void testDecoratorsOrder() {
        Report decorated = new CompressionDecorator(
                new WatermarkDecorator(
                        new DigitalSignatureDecorator(baseReport)
                )
        );
        String result = decorated.generate();
        int firmaIdx       = result.indexOf("[FIRMA DIGITAL]");
        int marcaIdx       = result.indexOf("[MARCA DE AGUA]");
        int compressionIdx = result.indexOf("[COMPRESIÓN]");

        assertTrue(firmaIdx < marcaIdx,       "Firma debe ir antes que Marca de agua");
        assertTrue(marcaIdx < compressionIdx, "Marca de agua debe ir antes que Compresion");
    }
}