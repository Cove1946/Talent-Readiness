package dosw.bitacora.Corte2.Patrones.ProcesamientoPagos;

public class BalanceValidator extends PaymentValidator {

    private static final double BALANCE_DISPONIBLE = 1000.0;

    @Override
    public boolean validate(double amount) {
        System.out.println("[BalanceValidator] Validando saldo disponible");
        if (amount > BALANCE_DISPONIBLE) {
            System.out.println("[BalanceValidator] Saldo insuficiente. Pago rechazado.");
            return false;
        }
        System.out.println("[BalanceValidator] Saldo suficiente. OK");
        return checkNext(amount);
    }
}