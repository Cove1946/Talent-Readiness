import dosw.bitacora.Corte2.Patrones.SistemaNotificaciones.Codigo.BaseNotifier;
import dosw.bitacora.Corte2.Patrones.SistemaNotificaciones.Codigo.Notifier;
import dosw.bitacora.Corte2.Patrones.SistemaNotificaciones.Codigo.SMSDecorator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SMSDecoratorTest {

    private ByteArrayOutputStream outputStream;
    private Notifier base;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        base = new BaseNotifier();
    }

    @Test
    @DisplayName("SMSDecorator debe enviar a todos los telefonos de la lista")
    void testSendToAllPhones() {
        Notifier smsNotifier = new SMSDecorator(base, List.of("+573001111111", "+573002222222"));

        smsNotifier.send("Alerta");

        String output = outputStream.toString();
        assertTrue(output.contains("[SMS]"));
        assertTrue(output.contains("+573001111111"));
        assertTrue(output.contains("+573002222222"));
    }

    @Test
    @DisplayName("SMSDecorator debe llamar al wrappee antes de enviar SMS")
    void testCallsWrappeeFirst() {
        Notifier smsNotifier = new SMSDecorator(base, List.of("+573001111111"));

        smsNotifier.send("Test");

        String output = outputStream.toString();
        assertTrue(output.indexOf("[BASE]") < output.indexOf("[SMS]"),
                "El BASE debe ejecutarse antes que SMS");
    }

    @Test
    @DisplayName("SMSDecorator con lista vacia no debe enviar SMS")
    void testEmptyPhoneList() {
        Notifier smsNotifier = new SMSDecorator(base, List.of());

        smsNotifier.send("Test");

        String output = outputStream.toString();
        assertFalse(output.contains("[SMS]"));
    }

    @Test
    @DisplayName("SMSDecorator debe contener el mensaje en el envio")
    void testMessageContent() {
        Notifier smsNotifier = new SMSDecorator(base, List.of("+573001111111"));

        smsNotifier.send("Mensaje urgente");

        String output = outputStream.toString();
        assertTrue(output.contains("Mensaje urgente"));
    }
}