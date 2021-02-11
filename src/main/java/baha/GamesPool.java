package baha;

import player.Player;

import java.util.*;

public class GamesPool {
    private static final TreeMap<Integer, Maze> mazeGames = new TreeMap<>(); //represent the game Id,Game
    private static final HashMap<Integer, Maze> reservedGames = new HashMap<>();
    private static final MazeGame mazeGame = new MazeGame();



    public synchronized Player registerPlayerInGame(String playerName, int GameId) {
        Player player = new Player(playerName);
        Maze game = reservedGames.get(GameId);
        player.setCurrentRoom(game.getStartingRoom());
        game.addPlayer(player);
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
        if (!mazeGames.isEmpty()) {
            Map.Entry<Integer, Maze> entry = mazeGames.firstEntry();
            if (entry.getValue().getPlayersNumber() < 4) {
                player = registerPlayerInGame(playerName, entry.getKey());
            }
        } else {
            player = registerPlayerInNewGame(playerName);
        }
        return player;
    }

    private static Maze CreateGame() {
        return mazeGame.CreateMaze();
    }
}
