package dosw.bitacora.Corte2.Patrones.ProcesamientoPagos;

public class Client {

    public static void main(String[] args) {

        System.out.println("---------- PAYPAL ----------");
        PaymentService paypalService = new PaymentService(new PayPalFactory());
        paypalService.processPayment(200.0);

        System.out.println("\n---------- STRIPE ----------");
        PaymentService stripeService = new PaymentService(new StripeFactory());
        stripeService.processPayment(900.0);

        System.out.println("\n---------- TARJETA CRÉDITO ----------");
        PaymentService creditService = new PaymentService(new CreditCardFactory());
        creditService.processPayment(300.0);

        System.out.println("\n---------- TRANSFERENCIA BANCARIA ----------");
        PaymentService bankService = new PaymentService(new BankTransferFactory());
        bankService.processPayment(600.0);
    }
}