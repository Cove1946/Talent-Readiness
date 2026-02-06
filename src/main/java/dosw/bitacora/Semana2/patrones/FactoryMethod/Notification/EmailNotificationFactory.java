package dosw.bitacora.Semana2.patrones.FactoryMethod.Notification;

public class EmailNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
