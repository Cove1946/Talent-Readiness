package dosw.bitacora.Corte2.Patrones.ProcesamientoPagos;

public class TransactionLimitValidator extends PaymentValidator {

    private static final double LIMITE_TRANSACCION = 500.0;

    @Override
    public boolean validate(double amount) {
        System.out.println("[TransactionLimitValidator] Validando límite de transacción");
        if (amount > LIMITE_TRANSACCION) {
            System.out.println("[TransactionLimitValidator] Límite excedido. Pago rechazado.");
            return false;
        }
        System.out.println("[TransactionLimitValidator] Dentro del límite. OK");
        return checkNext(amount);
    }
}