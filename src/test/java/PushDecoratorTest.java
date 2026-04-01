import dosw.bitacora.Corte2.Patrones.SistemaNotificaciones.Codigo.BaseNotifier;
import dosw.bitacora.Corte2.Patrones.SistemaNotificaciones.Codigo.Notifier;
import dosw.bitacora.Corte2.Patrones.SistemaNotificaciones.Codigo.PushDecorator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PushDecoratorTest {

    private ByteArrayOutputStream outputStream;
    private Notifier base;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        base = new BaseNotifier();
    }

    @Test
    @DisplayName("PushDecorator debe enviar a todos los dispositivos de la lista")
    void testSendToAllDevices() {
        Notifier pushNotifier = new PushDecorator(base, List.of("device-001", "device-002"));

        pushNotifier.send("Notificacion push");

        String output = outputStream.toString();
        assertTrue(output.contains("[PUSH]"));
        assertTrue(output.contains("device-001"));
        assertTrue(output.contains("device-002"));
    }

    @Test
    @DisplayName("PushDecorator debe llamar al wrappee antes de enviar Push")
    void testCallsWrappeeFirst() {
        Notifier pushNotifier = new PushDecorator(base, List.of("device-001"));

        pushNotifier.send("Test");

        String output = outputStream.toString();
        assertTrue(output.indexOf("[BASE]") < output.indexOf("[PUSH]"),
                "El BASE debe ejecutarse antes que PUSH");
    }

    @Test
    @DisplayName("PushDecorator con lista vacia no debe enviar Push")
    void testEmptyDeviceList() {
        Notifier pushNotifier = new PushDecorator(base, List.of());

        pushNotifier.send("Test");

        String output = outputStream.toString();
        assertFalse(output.contains("[PUSH]"));
    }

    @Test
    @DisplayName("PushDecorator debe contener el mensaje en el envio")
    void testMessageContent() {
        Notifier pushNotifier = new PushDecorator(base, List.of("device-001"));

        pushNotifier.send("Mensaje push importante");

        String output = outputStream.toString();
        assertTrue(output.contains("Mensaje push importante"));
    }
}