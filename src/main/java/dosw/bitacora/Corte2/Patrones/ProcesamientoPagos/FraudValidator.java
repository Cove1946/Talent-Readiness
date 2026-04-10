package dosw.bitacora.Corte2.Patrones.ProcesamientoPagos;

public class FraudValidator extends PaymentValidator {

    private static final double MONTO_SOSPECHOSO = 800.0;

    @Override
    public boolean validate(double amount) {
        System.out.println("[FraudValidator] Validando posible fraude");
        if (amount > MONTO_SOSPECHOSO) {
            System.out.println("[FraudValidator] Transacción sospechosa. Pago rechazado.");
            return false;
        }
        System.out.println("[FraudValidator] Sin indicios de fraude. OK");
        return checkNext(amount);
    }
}
