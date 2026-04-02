package dosw.bitacora.Corte2.Patrones.Reportes;

public interface ReportBuilder {
    ReportBuilder addGeneralInfo(String info);
    ReportBuilder addStatistics(String stats);
    ReportBuilder addTransactionDetail(String detail);
    ReportBuilder addFinalSummary(String summary);
    Report build();
}
