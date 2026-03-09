package dosw.bitacora.Corte1.Semana3.patrones.Command;

public class GameController {

    public void pressButton(Command command) {
        command.execute();
    }

}
