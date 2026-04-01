package dosw.bitacora.Corte2.Patrones.ProcesamientoPagos;

public class StripeAdapter implements PaymentProcessor {

    private StripeAPI stripeAPI;

    public StripeAdapter(StripeAPI stripeAPI) {
        this.stripeAPI = stripeAPI;
    }

    @Override
    public boolean processPayment(double amount) {
        System.out.println("[StripeAdapter] Adaptando llamada a Stripe");
        stripeAPI.chargeCard(amount);
        return true;
    }
}