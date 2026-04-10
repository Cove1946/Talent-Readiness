package dosw.bitacora.Corte2.Patrones.ProcesamientoPagos;

public class BankTransferFactory implements PaymentFactory {

    @Override
    public PaymentProcessor createProcessor() {
        return new BankTransferAdapter(new BankTransferAPI());
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