package dosw.bitacora.Semana2.patrones.FactoryMethod.Payment;

public class CreditCardPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Pago con Tarjeta de Credito por $" + amount);

    }
}
