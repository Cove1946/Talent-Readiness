package dosw.bitacora.Semana2.patrones.FactoryMethod.Payment;

public class ejercicioClase {
    public static void main(String[] args) {
        PaymentProcessor processor;
        processor = new CreditCardProcessor();
        processor.processPayment(100);
        processor = new PaypalProcessor();
        processor.processPayment(250);
        processor = new BankTransferProcessor();
        processor.processPayment(500);
    }
}
