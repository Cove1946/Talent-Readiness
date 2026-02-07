package dosw.bitacora.Semana2.patrones.AbstractFactory.VideoGames;

public class PlayStationFactory implements ConsoleFactory{
    @Override
    public Controller createController() {
        return new PlayStationController();
    }

    @Override
    public Game createGame() {
        return new PlayStationGame();
    }

    @Override
    public UI createUI() {
        return new PlayStationUI();
    }
}
