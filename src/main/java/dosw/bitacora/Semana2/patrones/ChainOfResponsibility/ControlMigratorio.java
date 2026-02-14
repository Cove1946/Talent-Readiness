package dosw.bitacora.Semana2.patrones.ChainOfResponsibility;

public interface ControlMigratorio {
    public void setSiguiente(ControlMigratorio siguiente);
    public void processar(IngresoRequest request);
}
