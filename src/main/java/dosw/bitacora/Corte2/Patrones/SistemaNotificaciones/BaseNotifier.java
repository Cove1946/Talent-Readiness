package dosw.bitacora.Corte2.Patrones.SistemaNotificaciones;

public class BaseNotifier implements Notifier {

    @Override
    public void send(String message) {
        System.out.println("[BASE] Notificación iniciada: " + message);
    }
}
