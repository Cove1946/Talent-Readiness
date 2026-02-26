package dosw.bitacora.Semana3.patrones.ChainOfResponsibility;

public interface ControlMigratorio {

    void setSiguiente(ControlMigratorio siguiente);
    void procesar(IngresoRequest request);

}
