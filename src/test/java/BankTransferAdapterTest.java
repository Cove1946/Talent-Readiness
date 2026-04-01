import dosw.bitacora.Corte2.Patrones.ProcesamientoPagos.BankTransferAPI;
import dosw.bitacora.Corte2.Patrones.ProcesamientoPagos.BankTransferAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BankTransferAdapterTest {

    private BankTransferAdapter adapter;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        adapter = new BankTransferAdapter(new BankTransferAPI());
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("BankTransferAdapter debe retornar true al procesar pago exitoso")
    void testProcessPaymentReturnsTrue() {
        boolean result = adapter.processPayment(100.0);
        assertTrue(result);
    }

    @Test
    @DisplayName("BankTransferAdapter debe llamar a la API de BankTransfer")
    void testProcessPaymentCallsAPI() {
        adapter.processPayment(100.0);
        String output = outputStream.toString();
        assertTrue(output.contains("[BankTransfer API]"));
    }

    @Test
    @DisplayName("BankTransferAdapter debe mostrar mensaje del adaptador")
    void testProcessPaymentShowsAdapterMessage() {
        adapter.processPayment(100.0);
        String output = outputStream.toString();
        assertTrue(output.contains("[BankTransferAdapter]"));
    }
}