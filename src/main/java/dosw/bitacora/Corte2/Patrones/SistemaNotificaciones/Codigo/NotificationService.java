package dosw.bitacora.Corte2.Patrones.SistemaNotificaciones.Codigo;

public class NotificationService {

    private static NotificationService instance;
    private Notifier notifier;

    private NotificationService() { }

    public static NotificationService getInstance() {
        if (instance == null) {
            synchronized (NotificationService.class) {
                if (instance == null) {
                    instance = new NotificationService();
                }
            }
        }
        return instance;
    }

    public void setNotifier(Notifier notifier) {
        this.notifier = notifier;
    }

    public void notify(String message) {
        if (notifier == null) {
            throw new IllegalStateException("No hay un notificador configurado");
        }
        notifier.send(message);
    }
}