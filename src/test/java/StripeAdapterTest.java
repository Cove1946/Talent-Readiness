import dosw.bitacora.Corte2.Patrones.ProcesamientoPagos.StripeAPI;
import dosw.bitacora.Corte2.Patrones.ProcesamientoPagos.StripeAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class StripeAdapterTest {

    private StripeAdapter adapter;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        adapter = new StripeAdapter(new StripeAPI());
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("StripeAdapter debe retornar true al procesar pago exitoso")
    void testProcessPaymentReturnsTrue() {
        boolean result = adapter.processPayment(100.0);
        assertTrue(result);
    }

    @Test
    @DisplayName("StripeAdapter debe llamar a la API de Stripe")
    void testProcessPaymentCallsAPI() {
        adapter.processPayment(100.0);
        String output = outputStream.toString();
        assertTrue(output.contains("[Stripe API]"));
    }

    @Test
    @DisplayName("StripeAdapter debe mostrar mensaje del adaptador")
    void testProcessPaymentShowsAdapterMessage() {
        adapter.processPayment(100.0);
        String output = outputStream.toString();
        assertTrue(output.contains("[StripeAdapter]"));
    }

    @Test
    @DisplayName("StripeAdapter debe incluir el monto en el mensaje")
    void testProcessPaymentShowsAmount() {
        adapter.processPayment(350.0);
        String output = outputStream.toString();
        assertTrue(output.contains("350.0"));
    }
}