package dosw.bitacora.Semana2.patrones.FactoryMethod.Notification;

public class PushNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new PushNotification();
    }
}

