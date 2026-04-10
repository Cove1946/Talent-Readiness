import dosw.bitacora.Corte2.Patrones.ProcesamientoPagos.PayPalAPI;
import dosw.bitacora.Corte2.Patrones.ProcesamientoPagos.PayPalAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PayPalAdapterTest {

    private PayPalAdapter adapter;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        adapter = new PayPalAdapter(new PayPalAPI());
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("PayPalAdapter debe retornar true al procesar pago exitoso")
    void testProcessPaymentReturnsTrue() {
        boolean result = adapter.processPayment(100.0);
        assertTrue(result);
    }

    @Test
    @DisplayName("PayPalAdapter debe llamar a la API de PayPal")
    void testProcessPaymentCallsAPI() {
        adapter.processPayment(100.0);
        String output = outputStream.toString();
        assertTrue(output.contains("[PayPal API]"));
    }

    @Test
    @DisplayName("PayPalAdapter debe mostrar mensaje del adaptador")
    void testProcessPaymentShowsAdapterMessage() {
        adapter.processPayment(100.0);
        String output = outputStream.toString();
        assertTrue(output.contains("[PayPalAdapter]"));
    }

    @Test
    @DisplayName("PayPalAdapter debe incluir el monto en el mensaje")
    void testProcessPaymentShowsAmount() {
        adapter.processPayment(250.0);
        String output = outputStream.toString();
        assertTrue(output.contains("250.0"));
    }
}