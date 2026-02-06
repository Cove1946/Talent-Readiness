package dosw.bitacora.Semana2.patrones.FactoryMethod.Payment;

public class CreditCardProcessor extends PaymentProcessor {
    @Override
    public Payment createPayment() {
        return new CreditCardPayment();
    }
}
