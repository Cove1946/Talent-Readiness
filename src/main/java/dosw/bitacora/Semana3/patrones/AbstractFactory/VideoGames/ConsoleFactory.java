package dosw.bitacora.Semana3.patrones.AbstractFactory.VideoGames;

public interface ConsoleFactory {
    Controller createController();
    Game createGame();
    UI createUI();
}
