package dosw.bitacora.Corte2.Patrones.Reportes;

public class ReportDirector {

    private ReportBuilder builder;

    public ReportDirector(ReportBuilder builder) {
        this.builder = builder;
    }

    public Report buildFullReport() {
        return builder
                .addGeneralInfo("Plataforma v1.0 - Reporte completo")
                .addStatistics("Usuarios activos: 1500 | Transacciones: 3200")
                .addTransactionDetail("TX001: $500 | TX002: $300 | TX003: $200")
                .addFinalSummary("Total transacciones: $1000")
                .build();
    }

    public Report buildSummaryReport() {
        return builder
                .addGeneralInfo("Plataforma v1.0 - Reporte resumen")
                .addFinalSummary("Total transacciones: $1000")
                .build();
    }
}
