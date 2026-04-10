package dosw.bitacora.Corte1.Semana2.Notification;

public class EmailNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
