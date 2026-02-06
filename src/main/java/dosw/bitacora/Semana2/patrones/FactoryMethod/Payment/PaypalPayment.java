package dosw.bitacora.Semana2.patrones.FactoryMethod.Payment;

public class PaypalPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Pago con Paypal por $" + amount);
    }
}
