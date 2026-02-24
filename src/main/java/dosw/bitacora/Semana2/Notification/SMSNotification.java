package dosw.bitacora.Semana2.Notification;

public class SMSNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("Enviando SMS:" + message);
    }
}
