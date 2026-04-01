import dosw.bitacora.Corte2.Patrones.SistemaNotificaciones.Codigo.BaseNotifier;
import dosw.bitacora.Corte2.Patrones.SistemaNotificaciones.Codigo.EmailDecorator;
import dosw.bitacora.Corte2.Patrones.SistemaNotificaciones.Codigo.NotificationService;
import dosw.bitacora.Corte2.Patrones.SistemaNotificaciones.Codigo.Notifier;
import dosw.bitacora.Corte2.Patrones.SistemaNotificaciones.Codigo.SMSDecorator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NotificationServiceTest {

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() throws Exception {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Resetear Singleton entre pruebas
        Field instance = NotificationService.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
    }

    @Test
    @DisplayName("Singleton debe retornar siempre la misma instancia")
    void testSingletonInstance() {
        NotificationService instance1 = NotificationService.getInstance();
        NotificationService instance2 = NotificationService.getInstance();

        assertSame(instance1, instance2);
    }

    @Test
    @DisplayName("Singleton debe ser thread-safe")
    void testSingletonThreadSafe() throws InterruptedException {
        NotificationService[] instances = new NotificationService[2];

        Thread t1 = new Thread(() -> instances[0] = NotificationService.getInstance());
        Thread t2 = new Thread(() -> instances[1] = NotificationService.getInstance());

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        assertSame(instances[0], instances[1]);
    }

    @Test
    @DisplayName("notify debe lanzar excepcion si no hay notificador configurado")
    void testNotifyWithoutNotifier() {
        NotificationService service = NotificationService.getInstance();

        assertThrows(IllegalStateException.class, () -> service.notify("Test"));
    }

    @Test
    @DisplayName("notify debe enviar el mensaje correctamente con notificador configurado")
    void testNotifyWithNotifier() {
        NotificationService service = NotificationService.getInstance();
        service.setNotifier(new EmailDecorator(new BaseNotifier(), List.of("test@test.com")));

        service.notify("Mensaje de prueba");

        assertTrue(outputStream.toString().contains("Mensaje de prueba"));
    }

    @Test
    @DisplayName("setNotifier debe permitir cambiar el notificador dinamicamente")
    void testChangeNotifierDynamically() {
        NotificationService service = NotificationService.getInstance();

        service.setNotifier(new EmailDecorator(new BaseNotifier(), List.of("email@test.com")));
        service.notify("Mensaje 1");

        service.setNotifier(new SMSDecorator(new BaseNotifier(), List.of("+573001111111")));
        service.notify("Mensaje 2");

        String output = outputStream.toString();
        assertTrue(output.contains("[EMAIL]"));
        assertTrue(output.contains("[SMS]"));
    }
}