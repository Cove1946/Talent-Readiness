import dosw.bitacora.Corte2.Patrones.ProcesamientoPagos.FraudValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FraudValidatorTest {

    private FraudValidator validator;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        validator = new FraudValidator();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("FraudValidator debe aprobar monto no sospechoso")
    void testValidateNonSuspiciousAmount() {
        boolean result = validator.validate(300.0);
        assertTrue(result);
    }

    @Test
    @DisplayName("FraudValidator debe rechazar monto sospechoso")
    void testValidateSuspiciousAmount() {
        boolean result = validator.validate(900.0);
        assertFalse(result);
    }

    @Test
    @DisplayName("FraudValidator debe mostrar mensaje de transaccion sospechosa")
    void testValidateShowsFraudMessage() {
        validator.validate(900.0);
        String output = outputStream.toString();
        assertTrue(output.contains("[FraudValidator]"));
        assertTrue(output.contains("sospechosa"));
    }

    @Test
    @DisplayName("FraudValidator debe aprobar monto exactamente igual al limite")
    void testValidateAmountEqualToLimit() {
        boolean result = validator.validate(800.0);
        assertTrue(result);
    }
}