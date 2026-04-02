import dosw.bitacora.Corte2.Patrones.Reportes.CSVReportBuilder;
import dosw.bitacora.Corte2.Patrones.Reportes.Report;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CSVReportBuilderTest {

    private CSVReportBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new CSVReportBuilder();
    }

    @Test
    @DisplayName("CSVReportBuilder debe incluir info general en el reporte")
    void testAddGeneralInfo() {
        Report report = builder.addGeneralInfo("Info general").build();
        assertTrue(report.getContent().contains("Info general"));
    }

    @Test
    @DisplayName("CSVReportBuilder debe incluir estadisticas en el reporte")
    void testAddStatistics() {
        Report report = builder.addStatistics("1500 usuarios").build();
        assertTrue(report.getContent().contains("1500 usuarios"));
    }

    @Test
    @DisplayName("CSVReportBuilder debe incluir detalle de transacciones")
    void testAddTransactionDetail() {
        Report report = builder.addTransactionDetail("TX001,500").build();
        assertTrue(report.getContent().contains("TX001,500"));
    }

    @Test
    @DisplayName("CSVReportBuilder debe incluir resumen final")
    void testAddFinalSummary() {
        Report report = builder.addFinalSummary("Total,1000").build();
        assertTrue(report.getContent().contains("Total,1000"));
    }

    @Test
    @DisplayName("CSVReportBuilder debe construir reporte con todas las secciones")
    void testBuildFullReport() {
        Report report = builder
                .addGeneralInfo("Info general")
                .addStatistics("1500 usuarios")
                .addTransactionDetail("TX001,500")
                .addFinalSummary("Total,1000")
                .build();

        String content = report.getContent();
        assertTrue(content.contains("INFO_GENERAL"));
        assertTrue(content.contains("ESTADISTICAS"));
        assertTrue(content.contains("DETALLE_TRANSACCIONES"));
        assertTrue(content.contains("RESUMEN_FINAL"));
    }

    @Test
    @DisplayName("CSVReportBuilder debe soportar encadenamiento de metodos")
    void testMethodChaining() {
        assertDoesNotThrow(() -> builder
                .addGeneralInfo("Info")
                .addStatistics("Stats")
                .addTransactionDetail("Detail")
                .addFinalSummary("Summary")
                .build()
        );
    }

    @Test
    @DisplayName("CSVReportBuilder build sin secciones no debe lanzar excepcion")
    void testBuildWithoutSections() {
        assertDoesNotThrow(() -> builder.build());
    }

    @Test
    @DisplayName("CSVReportBuilder generate debe contener prefijo CSV")
    void testBuildGeneratesCSVReport() {
        Report report = builder.addGeneralInfo("Info").build();
        assertTrue(report.generate().contains("[CSV]"));
    }
}