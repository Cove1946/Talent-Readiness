import dosw.bitacora.Corte2.Patrones.ProcesamientoPagos.TransactionLimitValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TransactionLimitValidatorTest {

    private TransactionLimitValidator validator;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        validator = new TransactionLimitValidator();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("TransactionLimitValidator debe aprobar monto dentro del limite")
    void testValidateAmountWithinLimit() {
        boolean result = validator.validate(300.0);
        assertTrue(result);
    }

    @Test
    @DisplayName("TransactionLimitValidator debe rechazar monto mayor al limite")
    void testValidateAmountExceedsLimit() {
        boolean result = validator.validate(600.0);
        assertFalse(result);
    }

    @Test
    @DisplayName("TransactionLimitValidator debe mostrar mensaje de limite excedido")
    void testValidateShowsLimitMessage() {
        validator.validate(600.0);
        String output = outputStream.toString();
        assertTrue(output.contains("[TransactionLimitValidator]"));
        assertTrue(output.contains("excedido"));
    }

    @Test
    @DisplayName("TransactionLimitValidator debe aprobar monto exactamente igual al limite")
    void testValidateAmountEqualToLimit() {
        boolean result = validator.validate(500.0);
        assertTrue(result);
    }
}