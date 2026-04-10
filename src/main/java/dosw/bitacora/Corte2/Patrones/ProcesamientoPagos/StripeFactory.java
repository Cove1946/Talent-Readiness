package dosw.bitacora.Corte2.Patrones.ProcesamientoPagos;

public class StripeFactory implements PaymentFactory {

    @Override
    public PaymentProcessor createProcessor() {
        return new StripeAdapter(new StripeAPI());
    }

    @Override
    public PaymentValidator createValidator() {
        PaymentValidator balance = new BalanceValidator();
        PaymentValidator fraud = new FraudValidator();
        PaymentValidator limit = new TransactionLimitValidator();
        balance.setNext(fraud).setNext(limit);
        return balance;
    }
}