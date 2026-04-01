package dosw.bitacora.Corte2.Patrones.SistemaNotificaciones;

import java.util.List;

public class Client {

    public static void main(String[] args) {

        // Construimos la pila de decoradores
        Notifier notifier = new BaseNotifier();

        notifier = new EmailDecorator(notifier,
                List.of("usuario@gmail.com", "admin@empresa.com"));

        notifier = new SMSDecorator(notifier,
                List.of("+573001234567", "+573009876543"));

        notifier = new PushDecorator(notifier,
                List.of("device-abc-123", "device-xyz-456"));

        // Obtenemos la única instancia del servicio (Singleton)
        NotificationService service = NotificationService.getInstance();
        service.setNotifier(notifier);

        // Enviamos la notificacion por todos los canales
        System.out.println("---------- Notificacion de emergencia ----------");
        service.notify("¡Alerta! El servidor esta caido");

        System.out.println("\n---------- Solo Email y SMS ----------");
        Notifier soloEmailSMS = new SMSDecorator(
                new EmailDecorator(
                        new BaseNotifier(),
                        List.of("usuario@gmail.com")
                ),
                List.of("+573001234567")
        );
        service.setNotifier(soloEmailSMS);
        service.notify("Recordatorio: reunión a las 3pm.");
    }
}