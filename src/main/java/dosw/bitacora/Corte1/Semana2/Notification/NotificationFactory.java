package dosw.bitacora.Corte1.Semana2.Notification;

public abstract class NotificationFactory {

    public abstract Notification createNotification();

    public void sendNotification(String message) {
        Notification notification = createNotification();
        notification.send(message);
    }
}
