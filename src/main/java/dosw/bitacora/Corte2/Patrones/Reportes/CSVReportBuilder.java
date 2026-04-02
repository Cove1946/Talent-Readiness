package dosw.bitacora.Corte2.Patrones.Reportes;

public class CSVReportBuilder implements ReportBuilder {

    private String generalInfo;
    private String statistics;
    private String transactionDetail;
    private String finalSummary;

    @Override
    public ReportBuilder addGeneralInfo(String info) {
        this.generalInfo = "INFO_GENERAL," + info;
        return this;
    }

    @Override
    public ReportBuilder addStatistics(String stats) {
        this.statistics = "ESTADISTICAS," + stats;
        return this;
    }

    @Override
    public ReportBuilder addTransactionDetail(String detail) {
        this.transactionDetail = "DETALLE_TRANSACCIONES," + detail;
        return this;
    }

    @Override
    public ReportBuilder addFinalSummary(String summary) {
        this.finalSummary = "RESUMEN_FINAL," + summary;
        return this;
    }

    @Override
    public Report build() {
        String content = String.join("\n",
                generalInfo != null ? generalInfo : "",
                statistics != null ? statistics : "",
                transactionDetail != null ? transactionDetail : "",
                finalSummary != null ? finalSummary : ""
        ).trim();
        System.out.println("[CSVReportBuilder] Construyendo reporte CSV");
        return new CSVReport(content);
    }
}