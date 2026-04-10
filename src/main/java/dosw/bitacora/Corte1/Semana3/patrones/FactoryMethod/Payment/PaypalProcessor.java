package dosw.bitacora.Corte1.Semana3.patrones.FactoryMethod.Payment;

public class PaypalProcessor extends PaymentProcessor {
    @Override
    public Payment createPayment() {
        return new PaypalPayment();
    }
}
