package dosw.bitacora.Corte2.Patrones.Reportes;

public class Client {

    public static void main(String[] args) {

        System.out.println("---------- REPORTE PDF COMPLETO ----------");
        ReportService pdfService = new ReportService(
                new PDFReportFactory(),
                new PDFReportBuilder()
        );
        Report pdfReport = pdfService.generateFullReport();
        System.out.println(pdfReport.generate());

        System.out.println("\n---------- REPORTE CSV CON FIRMA Y MARCA DE AGUA ----------");
        ReportService csvService = new ReportService(
                new CSVReportFactory(),
                new CSVReportBuilder()
        );
        Report csvReport = csvService.generateFullReport();
        Report csvDecorado = new WatermarkDecorator(
                new DigitalSignatureDecorator(csvReport)
        );
        System.out.println(csvDecorado.generate());

        System.out.println("\n---------- REPORTE JSON CON TODAS LAS DECORACIONES ----------");
        ReportService jsonService = new ReportService(
                new JSONReportFactory(),
                new JSONReportBuilder()
        );
        Report jsonReport = jsonService.generateSummaryReport();
        Report jsonDecorado = new CompressionDecorator(
                new WatermarkDecorator(
                        new DigitalSignatureDecorator(jsonReport)
                )
        );
        System.out.println(jsonDecorado.generate());
    }
}