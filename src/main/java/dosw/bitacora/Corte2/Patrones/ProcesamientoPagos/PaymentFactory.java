package dosw.bitacora.Corte2.Patrones.ProcesamientoPagos;

public interface PaymentFactory {
    PaymentProcessor createProcessor();
    PaymentValidator createValidator();
}