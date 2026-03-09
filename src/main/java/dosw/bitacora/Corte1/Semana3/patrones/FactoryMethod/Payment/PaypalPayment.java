package dosw.bitacora.Corte1.Semana3.patrones.FactoryMethod.Payment;

public class PaypalPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Pago con Paypal por $" + amount);
    }
}
