package dosw.bitacora.Semana2.patrones.FactoryMethod.Notification;

public class SMSNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}
