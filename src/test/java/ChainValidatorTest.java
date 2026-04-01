import dosw.bitacora.Corte2.Patrones.ProcesamientoPagos.BalanceValidator;
import dosw.bitacora.Corte2.Patrones.ProcesamientoPagos.FraudValidator;
import dosw.bitacora.Corte2.Patrones.ProcesamientoPagos.PaymentValidator;
import dosw.bitacora.Corte2.Patrones.ProcesamientoPagos.TransactionLimitValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ChainValidatorTest {

    private PaymentValidator chain;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        PaymentValidator balance = new BalanceValidator();
        PaymentValidator fraud = new FraudValidator();
        PaymentValidator limit = new TransactionLimitValidator();
        balance.setNext(fraud).setNext(limit);
        chain = balance;
    }

    @Test
    @DisplayName("Cadena completa debe aprobar monto valido")
    void testChainApprovesValidAmount() {
        boolean result = chain.validate(200.0);
        assertTrue(result);
    }

    @Test
    @DisplayName("Cadena debe detenerse en BalanceValidator si saldo insuficiente")
    void testChainStopsAtBalance() {
        boolean result = chain.validate(1500.0);
        assertFalse(result);
        String output = outputStream.toString();
        assertTrue(output.contains("[BalanceValidator]"));
        assertFalse(output.contains("[FraudValidator]"));
    }

    @Test
    @DisplayName("Cadena debe detenerse en FraudValidator si monto sospechoso")
    void testChainStopsAtFraud() {
        boolean result = chain.validate(850.0);
        assertFalse(result);
        String output = outputStream.toString();
        assertTrue(output.contains("[FraudValidator]"));
        assertFalse(output.contains("[TransactionLimitValidator]"));
    }

    @Test
    @DisplayName("Cadena debe detenerse en TransactionLimitValidator si limite excedido")
    void testChainStopsAtLimit() {
        boolean result = chain.validate(600.0);
        assertFalse(result);
        String output = outputStream.toString();
        assertTrue(output.contains("[TransactionLimitValidator]"));
    }

    @Test
    @DisplayName("Cadena debe ejecutar todos los validadores si monto es valido")
    void testChainExecutesAllValidators() {
        chain.validate(200.0);
        String output = outputStream.toString();
        assertTrue(output.contains("[BalanceValidator]"));
        assertTrue(output.contains("[FraudValidator]"));
        assertTrue(output.contains("[TransactionLimitValidator]"));
    }
}