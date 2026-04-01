package dosw.bitacora.Corte2.Patrones.SistemaNotificaciones;

import java.util.List;

public class SMSDecorator extends NotifierDecorator {

    private List<String> phoneList;

    public SMSDecorator(Notifier notifier, List<String> phoneList) {
        super(notifier);
        this.phoneList = phoneList;
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        phoneList.forEach(phone ->
                System.out.println("[SMS] Enviando a " + phone + ": " + message)
        );
    }
}