package dosw.bitacora.Corte2.Patrones.ProcesamientoPagos;

public class CreditCardAdapter implements PaymentProcessor {

    private CreditCardAPI creditCardAPI;

    public CreditCardAdapter(CreditCardAPI creditCardAPI) {
        this.creditCardAPI = creditCardAPI;
    }

    @Override
    public boolean processPayment(double amount) {
        System.out.println("[CreditCardAdapter] Adaptando llamada a CreditCard");
        creditCardAPI.processCreditCard(amount);
        return true;
    }
}