import dosw.bitacora.Corte2.Patrones.Reportes.JSONReportBuilder;
import dosw.bitacora.Corte2.Patrones.Reportes.Report;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JSONReportBuilderTest {

    private JSONReportBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new JSONReportBuilder();
    }

    @Test
    @DisplayName("JSONReportBuilder debe incluir info general en el reporte")
    void testAddGeneralInfo() {
        Report report = builder.addGeneralInfo("Info general").build();
        assertTrue(report.getContent().contains("infoGeneral"));
        assertTrue(report.getContent().contains("Info general"));
    }

    @Test
    @DisplayName("JSONReportBuilder debe incluir estadisticas en el reporte")
    void testAddStatistics() {
        Report report = builder.addStatistics("1500 usuarios").build();
        assertTrue(report.getContent().contains("estadisticas"));
        assertTrue(report.getContent().contains("1500 usuarios"));
    }

    @Test
    @DisplayName("JSONReportBuilder debe incluir detalle de transacciones")
    void testAddTransactionDetail() {
        Report report = builder.addTransactionDetail("TX001").build();
        assertTrue(report.getContent().contains("detalleTransacciones"));
        assertTrue(report.getContent().contains("TX001"));
    }

    @Test
    @DisplayName("JSONReportBuilder debe incluir resumen final")
    void testAddFinalSummary() {
        Report report = builder.addFinalSummary("Total 1000").build();
        assertTrue(report.getContent().contains("resumenFinal"));
        assertTrue(report.getContent().contains("Total 1000"));
    }

    @Test
    @DisplayName("JSONReportBuilder debe construir reporte con todas las secciones")
    void testBuildFullReport() {
        Report report = builder
                .addGeneralInfo("Info")
                .addStatistics("Stats")
                .addTransactionDetail("Detail")
                .addFinalSummary("Summary")
                .build();

        String content = report.getContent();
        assertTrue(content.contains("infoGeneral"));
        assertTrue(content.contains("estadisticas"));
        assertTrue(content.contains("detalleTransacciones"));
        assertTrue(content.contains("resumenFinal"));
    }

    @Test
    @DisplayName("JSONReportBuilder build sin secciones no debe lanzar excepcion")
    void testBuildWithoutSections() {
        assertDoesNotThrow(() -> builder.build());
    }

    @Test
    @DisplayName("JSONReportBuilder generate debe contener prefijo JSON")
    void testBuildGeneratesJSONReport() {
        Report report = builder.addGeneralInfo("Info").build();
        assertTrue(report.generate().contains("[JSON]"));
    }

    @Test
    @DisplayName("JSONReportBuilder debe generar estructura JSON valida con llaves")
    void testBuildGeneratesJSONStructure() {
        Report report = builder.addGeneralInfo("Info").build();
        assertTrue(report.getContent().contains("{"));
        assertTrue(report.getContent().contains("}"));
    }
}