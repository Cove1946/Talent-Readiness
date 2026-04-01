package dosw.bitacora.Corte2.Patrones.ProcesamientoPagos;

public class PaymentService {

    private PaymentFactory factory;

    public PaymentService(PaymentFactory factory) {
        this.factory = factory;
    }

    public boolean processPayment(double amount) {
        System.out.println("\n---------- Iniciando proceso de pago por $" + amount + " ----------");

        PaymentValidator validator = factory.createValidator();
        System.out.println("\n---------- Ejecutando validaciones ----------");

        if (!validator.validate(amount)) {
            System.out.println("\n Pago rechazado en validación.");
            return false;
        }

        PaymentProcessor processor = factory.createProcessor();
        System.out.println("\n---------- Procesando pago ----------");
        boolean result = processor.processPayment(amount);

        System.out.println(result ? "\n Pago procesado exitosamente." : "\n Error al procesar el pago.");
        return result;
    }
}