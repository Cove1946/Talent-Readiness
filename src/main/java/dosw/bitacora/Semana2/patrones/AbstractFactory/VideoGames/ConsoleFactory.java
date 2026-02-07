package dosw.bitacora.Semana2.patrones.AbstractFactory.VideoGames;

public interface ConsoleFactory {
    Controller createController();
    Game createGame();
    UI createUI();
}
