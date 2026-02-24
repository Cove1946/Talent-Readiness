package dosw.bitacora.Semana3.patrones.FactoryMethod.Payment;

public class BankTransferProcessor extends PaymentProcessor{
    @Override
    public Payment createPayment() {
        return new BankTransferPayment();
    }
}
