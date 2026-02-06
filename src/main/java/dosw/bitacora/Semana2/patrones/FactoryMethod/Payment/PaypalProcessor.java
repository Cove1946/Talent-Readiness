package dosw.bitacora.Semana2.patrones.FactoryMethod.Payment;

public class PaypalProcessor extends PaymentProcessor {
    @Override
    public Payment createPayment() {
        return new PaypalPayment();
    }
}
