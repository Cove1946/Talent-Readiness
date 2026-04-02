package dosw.bitacora.Corte2.Patrones.Reportes;

public class JSONReportBuilder implements ReportBuilder {

    private String generalInfo;
    private String statistics;
    private String transactionDetail;
    private String finalSummary;

    @Override
    public ReportBuilder addGeneralInfo(String info) {
        this.generalInfo = "\"infoGeneral\": \"" + info + "\"";
        return this;
    }

    @Override
    public ReportBuilder addStatistics(String stats) {
        this.statistics = "\"estadisticas\": \"" + stats + "\"";
        return this;
    }

    @Override
    public ReportBuilder addTransactionDetail(String detail) {
        this.transactionDetail = "\"detalleTransacciones\": \"" + detail + "\"";
        return this;
    }

    @Override
    public ReportBuilder addFinalSummary(String summary) {
        this.finalSummary = "\"resumenFinal\": \"" + summary + "\"";
        return this;
    }

    @Override
    public Report build() {
        String content = "{\n" + String.join(",\n",
                generalInfo != null ? generalInfo : "",
                statistics != null ? statistics : "",
                transactionDetail != null ? transactionDetail : "",
                finalSummary != null ? finalSummary : ""
        ).trim() + "\n}";
        System.out.println("[JSONReportBuilder] Construyendo reporte JSON");
        return new JSONReport(content);
    }
}