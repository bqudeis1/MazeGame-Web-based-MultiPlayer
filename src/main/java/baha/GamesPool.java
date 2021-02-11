package baha;

import player.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class GamesPool {
    private static final TreeMap<Integer, Maze> mazeGames = new TreeMap<Integer, Maze>(); //represent the game Id,Game
    private static final HashMap<Integer, Maze> reservedGames = new HashMap<>();
    private static final MazeGame mazeGame = new MazeGame();

    private static Maze CreateGame() {
        Maze maze = mazeGame.CreateMaze();
        return maze;
    }

    public synchronized Player registerPlayerInGame(String playerName, int GameId) {
        Player player = new Player(playerName);
        Maze game = reservedGames.get(GameId);
        player.setCurrentRoom(game.getStartingRoom());
        mazeGames.put(game.getGameId(), game);
        mazeGames.remove(game.getGameId());
        return player;
    }

    public Player registerPlayerInNewGame(String playerName) {
        Maze game = CreateGame();
        int gameId = game.getGameId();
        reservedGames.put(gameId, game);
        return registerPlayerInGame(playerName, gameId);
    }

    public synchronized Player registerPlayerInRandomGame(String playerName) {
        Player player = null;
        if(mazeGames.isEmpty()){
            player = registerPlayerInNewGame(playerName);
        }
        Map.Entry<Integer, Maze> entry = mazeGames.firstEntry();
        if (entry.getValue().getPlayersNumber() < 4) {
            player = registerPlayerInGame(playerName, entry.getKey());
        } else {
            player = registerPlayerInNewGame(playerName);
        }
        return player;
    }
}
