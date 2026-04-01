import dosw.bitacora.Corte2.Patrones.SistemaNotificaciones.Codigo.BaseNotifier;
import dosw.bitacora.Corte2.Patrones.SistemaNotificaciones.Codigo.EmailDecorator;
import dosw.bitacora.Corte2.Patrones.SistemaNotificaciones.Codigo.Notifier;
import dosw.bitacora.Corte2.Patrones.SistemaNotificaciones.Codigo.PushDecorator;
import dosw.bitacora.Corte2.Patrones.SistemaNotificaciones.Codigo.SMSDecorator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DecoratorIntegrationTest {

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("Debe enviar por los 3 canales cuando se apilan todos los decoradores")
    void testAllChannelsStackedTogether() {
        Notifier notifier = new PushDecorator(
                new SMSDecorator(
                        new EmailDecorator(
                                new BaseNotifier(),
                                List.of("user@test.com")
                        ),
                        List.of("+573001111111")
                ),
                List.of("device-001")
        );

        notifier.send("Alerta total");

        String output = outputStream.toString();
        assertTrue(output.contains("[BASE]"));
        assertTrue(output.contains("[EMAIL]"));
        assertTrue(output.contains("[SMS]"));
        assertTrue(output.contains("[PUSH]"));
    }

    @Test
    @DisplayName("El orden de ejecucion debe respetar el orden de apilamiento")
    void testExecutionOrder() {
        Notifier notifier = new PushDecorator(
                new SMSDecorator(
                        new EmailDecorator(
                                new BaseNotifier(),
                                List.of("user@test.com")
                        ),
                        List.of("+573001111111")
                ),
                List.of("device-001")
        );

        notifier.send("Test orden");

        String output = outputStream.toString();
        assertTrue(output.indexOf("[BASE]")  < output.indexOf("[EMAIL]"), "BASE antes que EMAIL");
        assertTrue(output.indexOf("[EMAIL]") < output.indexOf("[SMS]"),   "EMAIL antes que SMS");
        assertTrue(output.indexOf("[SMS]")   < output.indexOf("[PUSH]"),  "SMS antes que PUSH");
    }

    @Test
    @DisplayName("Solo Email y SMS sin Push debe funcionar correctamente")
    void testEmailAndSMSOnly() {
        Notifier notifier = new SMSDecorator(
                new EmailDecorator(
                        new BaseNotifier(),
                        List.of("user@test.com")
                ),
                List.of("+573001111111")
        );

        notifier.send("Test parcial");

        String output = outputStream.toString();
        assertTrue(output.contains("[EMAIL]"));
        assertTrue(output.contains("[SMS]"));
        assertFalse(output.contains("[PUSH]"));
    }
}