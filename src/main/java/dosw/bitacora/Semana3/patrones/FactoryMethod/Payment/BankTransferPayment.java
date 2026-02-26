package dosw.bitacora.Semana3.patrones.FactoryMethod.Payment;

public class BankTransferPayment implements Payment{
    @Override
    public void pay(double amount) {
        System.out.println("Pay con Transferencia Bancaria por $" + amount);
    }
}
