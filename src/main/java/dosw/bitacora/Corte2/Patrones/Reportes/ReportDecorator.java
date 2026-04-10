package dosw.bitacora.Corte2.Patrones.Reportes;

public abstract class ReportDecorator implements Report {

    protected Report wrappee;

    public ReportDecorator(Report report) {
        this.wrappee = report;
    }

    @Override
    public String generate() {
        return wrappee.generate();
    }

    @Override
    public String getContent() {
        return wrappee.getContent();
    }
}
