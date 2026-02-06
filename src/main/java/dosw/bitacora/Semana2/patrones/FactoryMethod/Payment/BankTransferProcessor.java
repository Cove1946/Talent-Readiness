package dosw.bitacora.Semana2.patrones.FactoryMethod.Payment;

public class BankTransferProcessor extends PaymentProcessor{
    @Override
    public Payment createPayment() {
        return new BankTransferPayment();
    }
}
