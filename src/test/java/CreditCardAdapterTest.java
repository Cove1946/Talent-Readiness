import dosw.bitacora.Corte2.Patrones.ProcesamientoPagos.CreditCardAPI;
import dosw.bitacora.Corte2.Patrones.ProcesamientoPagos.CreditCardAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardAdapterTest {

    private CreditCardAdapter adapter;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        adapter = new CreditCardAdapter(new CreditCardAPI());
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("CreditCardAdapter debe retornar true al procesar pago exitoso")
    void testProcessPaymentReturnsTrue() {
        boolean result = adapter.processPayment(100.0);
        assertTrue(result);
    }

    @Test
    @DisplayName("CreditCardAdapter debe llamar a la API de CreditCard")
    void testProcessPaymentCallsAPI() {
        adapter.processPayment(100.0);
        String output = outputStream.toString();
        assertTrue(output.contains("[CreditCard API]"));
    }

    @Test
    @DisplayName("CreditCardAdapter debe mostrar mensaje del adaptador")
    void testProcessPaymentShowsAdapterMessage() {
        adapter.processPayment(100.0);
        String output = outputStream.toString();
        assertTrue(output.contains("[CreditCardAdapter]"));
    }
}