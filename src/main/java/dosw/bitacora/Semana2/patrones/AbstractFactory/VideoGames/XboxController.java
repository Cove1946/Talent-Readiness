package dosw.bitacora.Semana2.patrones.AbstractFactory.VideoGames;

public class XboxController implements Controller{

    @Override
    public void connect() {
        System.out.println("Control de Xbox conectado");
    }
}
