package dosw.bitacora.Corte1.Semana2.Notification;

public class PushNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new PushNotification();
    }
}

