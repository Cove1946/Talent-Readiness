package dosw.bitacora.Semana2.Notification;

public class PushNotification implements Notification{

    @Override
    public void send(String message) {
        System.out.println("Enviando PUSH:" + message);
    }
}
