package dosw.bitacora.Corte2.Patrones.ProcesamientoPagos;

public class CreditCardFactory implements PaymentFactory {

    @Override
    public PaymentProcessor createProcessor() {
        return new CreditCardAdapter(new CreditCardAPI());
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

