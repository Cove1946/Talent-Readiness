package dosw.bitacora.Corte1.Semana2.Notification;

public class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Enviando EMAIL: " + message);
    }
}

