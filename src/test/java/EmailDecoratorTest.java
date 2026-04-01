import dosw.bitacora.Corte2.Patrones.SistemaNotificaciones.Codigo.BaseNotifier;
import dosw.bitacora.Corte2.Patrones.SistemaNotificaciones.Codigo.EmailDecorator;
import dosw.bitacora.Corte2.Patrones.SistemaNotificaciones.Codigo.Notifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmailDecoratorTest {

    private ByteArrayOutputStream outputStream;
    private Notifier base;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        base = new BaseNotifier();
    }

    @Test
    @DisplayName("EmailDecorator debe enviar a todos los correos de la lista")
    void testSendToAllEmails() {
        Notifier emailNotifier = new EmailDecorator(base, List.of("a@test.com", "b@test.com"));

        emailNotifier.send("Hola");

        String output = outputStream.toString();
        assertTrue(output.contains("[EMAIL]"));
        assertTrue(output.contains("a@test.com"));
        assertTrue(output.contains("b@test.com"));
    }

    @Test
    @DisplayName("EmailDecorator debe llamar al wrappee antes de enviar email")
    void testCallsWrappeeFirst() {
        Notifier emailNotifier = new EmailDecorator(base, List.of("a@test.com"));

        emailNotifier.send("Test");

        String output = outputStream.toString();
        assertTrue(output.indexOf("[BASE]") < output.indexOf("[EMAIL]"),
                "El BASE debe ejecutarse antes que EMAIL");
    }

    @Test
    @DisplayName("EmailDecorator con lista vacia no debe enviar emails")
    void testEmptyEmailList() {
        Notifier emailNotifier = new EmailDecorator(base, List.of());

        emailNotifier.send("Test");

        String output = outputStream.toString();
        assertFalse(output.contains("[EMAIL]"));
    }

    @Test
    @DisplayName("EmailDecorator debe contener el mensaje en el envio")
    void testMessageContent() {
        Notifier emailNotifier = new EmailDecorator(base, List.of("test@test.com"));

        emailNotifier.send("Mensaje importante");

        String output = outputStream.toString();
        assertTrue(output.contains("Mensaje importante"));
    }
}