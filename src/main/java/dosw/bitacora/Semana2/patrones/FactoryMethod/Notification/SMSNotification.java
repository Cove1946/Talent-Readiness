package dosw.bitacora.Semana2.patrones.FactoryMethod.Notification;

public class SMSNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("Enviando SMS:" + message);
    }
}
