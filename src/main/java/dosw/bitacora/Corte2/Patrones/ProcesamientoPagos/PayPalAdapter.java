package dosw.bitacora.Corte2.Patrones.ProcesamientoPagos;

public class PayPalAdapter implements PaymentProcessor {

    private PayPalAPI paypalAPI;

    public PayPalAdapter(PayPalAPI paypalAPI) {
        this.paypalAPI = paypalAPI;
    }

    @Override
    public boolean processPayment(double amount) {
        System.out.println("[PayPalAdapter] Adaptando llamada a PayPal");
        paypalAPI.makePayment(amount);
        return true;
    }
}