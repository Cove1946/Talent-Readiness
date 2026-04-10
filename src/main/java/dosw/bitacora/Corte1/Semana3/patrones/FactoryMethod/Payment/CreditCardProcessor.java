package dosw.bitacora.Corte1.Semana3.patrones.FactoryMethod.Payment;

public class CreditCardProcessor extends PaymentProcessor {
    @Override
    public Payment createPayment() {
        return new CreditCardPayment();
    }
}
