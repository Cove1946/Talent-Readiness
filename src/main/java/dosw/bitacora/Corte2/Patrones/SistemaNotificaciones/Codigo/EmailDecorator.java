package dosw.bitacora.Corte2.Patrones.SistemaNotificaciones.Codigo;

import java.util.List;

public class EmailDecorator extends NotifierDecorator {

    private List<String> emailList;

    public EmailDecorator(Notifier notifier, List<String> emailList) {
        super(notifier);
        this.emailList = emailList;
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendEmail(message);
    }

    private void sendEmail(String message) {
        emailList.forEach(email ->
                System.out.println("[EMAIL] Enviando a " + email + ": " + message)
        );
    }
}