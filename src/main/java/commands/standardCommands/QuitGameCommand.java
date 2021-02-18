package commands.standardCommands;

import baha.GamesPool;
import commands.Command;
import player.Player;

public class QuitGameCommand implements Command {
    GamesPool gamesPool;

    public QuitGameCommand(GamesPool p) {
        gamesPool = p;
    }

    @Override
    public Object execute(Object[] input) {
        int gameId = Integer.parseInt((String) input[0]);
        int playerId = Integer.parseInt((String) input[1]);
        gamesPool.removePlayerFromGame(gameId, playerId);
        return null;
    }
}
