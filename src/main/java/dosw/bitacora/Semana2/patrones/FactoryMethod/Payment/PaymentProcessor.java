package dosw.bitacora.Semana2.patrones.FactoryMethod.Payment;

public abstract class PaymentProcessor {

    public abstract Payment createPayment();

    public void processPayment(double amount){
        Payment payment = createPayment();
        payment.pay(amount);
    }
}
