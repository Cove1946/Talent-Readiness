package dosw.bitacora.Semana2.patrones.FactoryMethod.Notification;

public abstract class NotificationFactory {

    public abstract Notification createNotification();

    public void sendNotification(String message) {
        Notification notification = createNotification();
        notification.send(message);
    }
}
