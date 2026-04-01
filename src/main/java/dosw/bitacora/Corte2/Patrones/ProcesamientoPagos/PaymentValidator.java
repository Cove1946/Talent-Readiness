package dosw.bitacora.Corte2.Patrones.ProcesamientoPagos;

public abstract class PaymentValidator {

    protected PaymentValidator nextValidator;

    public PaymentValidator setNext(PaymentValidator nextValidator) {
        this.nextValidator = nextValidator;
        return nextValidator;
    }

    public abstract boolean validate(double amount);

    protected boolean checkNext(double amount) {
        if (nextValidator == null) {
            return true;
        }
        return nextValidator.validate(amount);
    }
}