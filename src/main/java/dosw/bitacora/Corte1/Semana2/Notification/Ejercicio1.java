package dosw.bitacora.Corte1.Semana2.Notification;

public class Ejercicio1 {

    public static void main(String[] args) {

            NotificationFactory emailFactory = new EmailNotificationFactory();
            emailFactory.sendNotification("Hola por correo");

            NotificationFactory smsFactory = new SMSNotificationFactory();
            smsFactory.sendNotification("Hola por SMS");

            NotificationFactory pushFactory = new PushNotificationFactory();
            pushFactory.sendNotification("Hola por Push");
        }

}
