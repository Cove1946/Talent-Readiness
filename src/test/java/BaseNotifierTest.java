import dosw.bitacora.Corte2.Patrones.SistemaNotificaciones.Codigo.BaseNotifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BaseNotifierTest {

    private BaseNotifier baseNotifier;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        baseNotifier = new BaseNotifier();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("BaseNotifier debe imprimir el mensaje correctamente")
    void testSendMessage() {
        baseNotifier.send("Mensaje de prueba");

        String output = outputStream.toString();
        assertTrue(output.contains("[BASE]"));
        assertTrue(output.contains("Mensaje de prueba"));
    }

    @Test
    @DisplayName("BaseNotifier no debe lanzar excepcion con mensaje vacio")
    void testSendEmptyMessage() {
        assertDoesNotThrow(() -> baseNotifier.send(""));
    }

    @Test
    @DisplayName("BaseNotifier no debe lanzar excepcion con mensaje nulo")
    void testSendNullMessage() {
        assertDoesNotThrow(() -> baseNotifier.send(null));
    }
}