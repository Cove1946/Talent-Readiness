package dosw.bitacora.Corte1.Semana3.patrones.AbstractFactory.VideoGames;

public interface ConsoleFactory {
    Controller createController();
    Game createGame();
    UI createUI();
}
