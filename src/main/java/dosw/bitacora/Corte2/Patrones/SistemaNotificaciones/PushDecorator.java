package dosw.bitacora.Corte2.Patrones.SistemaNotificaciones;

import java.util.List;

public class PushDecorator extends NotifierDecorator {

    private List<String> deviceList;

    public PushDecorator(Notifier notifier, List<String> deviceList) {
        super(notifier);
        this.deviceList = deviceList;
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendPush(message);
    }

    private void sendPush(String message) {
        deviceList.forEach(device ->
                System.out.println("[PUSH] Enviando a dispositivo " + device + ": " + message)
        );
    }
}