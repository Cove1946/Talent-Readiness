package dosw.bitacora.Corte2.Patrones.ProcesamientoPagos;

public class StripeAPI {
    public void chargeCard(double amount) {
        System.out.println("[Stripe API] Cargando tarjeta por: $" + amount);
    }
}
