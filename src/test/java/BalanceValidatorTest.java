import dosw.bitacora.Corte2.Patrones.ProcesamientoPagos.BalanceValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BalanceValidatorTest {

    private BalanceValidator validator;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        validator = new BalanceValidator();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("BalanceValidator debe aprobar monto dentro del saldo disponible")
    void testValidateAmountWithinBalance() {
        boolean result = validator.validate(500.0);
        assertTrue(result);
    }

    @Test
    @DisplayName("BalanceValidator debe rechazar monto mayor al saldo disponible")
    void testValidateAmountExceedsBalance() {
        boolean result = validator.validate(1500.0);
        assertFalse(result);
    }

    @Test
    @DisplayName("BalanceValidator debe mostrar mensaje de saldo insuficiente")
    void testValidateShowsInsufficientBalanceMessage() {
        validator.validate(1500.0);
        String output = outputStream.toString();
        assertTrue(output.contains("[BalanceValidator]"));
        assertTrue(output.contains("insuficiente"));
    }

    @Test
    @DisplayName("BalanceValidator debe aprobar monto exactamente igual al saldo")
    void testValidateAmountEqualToBalance() {
        boolean result = validator.validate(1000.0);
        assertTrue(result);
    }
}