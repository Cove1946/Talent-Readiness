package dosw.bitacora.Semana2.Notification;

public class PushNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new PushNotification();
    }
}

