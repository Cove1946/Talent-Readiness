import dosw.bitacora.Corte2.Patrones.ProcesamientoPagos.BankTransferFactory;
import dosw.bitacora.Corte2.Patrones.ProcesamientoPagos.CreditCardFactory;
import dosw.bitacora.Corte2.Patrones.ProcesamientoPagos.PayPalFactory;
import dosw.bitacora.Corte2.Patrones.ProcesamientoPagos.PaymentService;
import dosw.bitacora.Corte2.Patrones.ProcesamientoPagos.StripeFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("PaymentService con PayPal debe aprobar monto valido")
    void testPayPalServiceApprovesValidAmount() {
        PaymentService service = new PaymentService(new PayPalFactory());
        boolean result = service.processPayment(200.0);
        assertTrue(result);
    }

    @Test
    @DisplayName("PaymentService con Stripe debe rechazar monto sospechoso")
    void testStripeServiceRejectsSuspiciousAmount() {
        PaymentService service = new PaymentService(new StripeFactory());
        boolean result = service.processPayment(900.0);
        assertFalse(result);
    }

    @Test
    @DisplayName("PaymentService con CreditCard debe aprobar monto valido")
    void testCreditCardServiceApprovesValidAmount() {
        PaymentService service = new PaymentService(new CreditCardFactory());
        boolean result = service.processPayment(300.0);
        assertTrue(result);
    }

    @Test
    @DisplayName("PaymentService con BankTransfer debe rechazar monto sobre limite")
    void testBankTransferServiceRejectsOverLimit() {
        PaymentService service = new PaymentService(new BankTransferFactory());
        boolean result = service.processPayment(600.0);
        assertFalse(result);
    }

    @Test
    @DisplayName("PaymentService debe mostrar mensaje de pago exitoso")
    void testServiceShowsSuccessMessage() {
        PaymentService service = new PaymentService(new PayPalFactory());
        service.processPayment(200.0);
        String output = outputStream.toString();
        assertTrue(output.contains("exitosamente"));
    }

    @Test
    @DisplayName("PaymentService debe mostrar mensaje de pago rechazado")
    void testServiceShowsRejectedMessage() {
        PaymentService service = new PaymentService(new PayPalFactory());
        service.processPayment(900.0);
        String output = outputStream.toString();
        assertTrue(output.contains("rechazado"));
    }
}