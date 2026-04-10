package dosw.bitacora.Corte1.Semana2.Notification;

public class SMSNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}
