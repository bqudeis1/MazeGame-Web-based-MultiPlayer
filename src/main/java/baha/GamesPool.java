package baha;

import player.Player;

import java.util.*;

public class GamesPool {
    private static final TreeMap<Integer, Maze> publicGames = new TreeMap<>();    //represent the game Id,Game
    private static final HashMap<Integer, Maze> reservedGames = new HashMap<>();
    private static final MazeFactory MAZE_FACTORY = new MazeFactory();


//TODO: refactor this class there is a problem in registerPlayerInRandomGame function.
//TODO: add commands to player when u create player object.

    public Maze getGame(int gameId) {
        return publicGames.get(gameId);
    }

    public Player registerPlayerInNewGame(String playerName) {
        Maze game = CreateGame();
        int gameId = game.getGameId();
        reservedGames.put(gameId, game);
        return registerPlayerInGame(playerName, gameId);
    }

    public synchronized Player registerPlayerInGame(String playerName, int gameId) {
        Player player = new Player(playerName);
        player.setGameId(gameId);
        if (publicGames.containsKey(gameId)) {
            registerPlayerToPublicGame(gameId, player);
        } else {
            registerPlayerReservedGame(gameId, player);
        }
        return player;
    }


    private void registerPlayerToPublicGame(int gameId, Player player) {
        Maze mazeGame;
        mazeGame = publicGames.get(gameId);
        player.setCurrentRoom(mazeGame.getStartingRoom());
        mazeGame.addPlayer(player);
    }

    private void registerPlayerReservedGame(int gameId, Player player) {
        Maze mazeGame;
        mazeGame = reservedGames.get(gameId);
        player.setCurrentRoom(mazeGame.getStartingRoom());
        mazeGame.addPlayer(player);
        publicGames.put(mazeGame.getGameId(), mazeGame);
        reservedGames.remove(mazeGame.getGameId());
    }

    public synchronized Player registerPlayerInRandomGame(String playerName) {
        Player player = null;
        if (!publicGames.isEmpty()) {
            Map.Entry<Integer, Maze> entry = publicGames.firstEntry();
            if (entry.getValue().getPlayersNumber() < 4) {
                player = registerPlayerInGame(playerName, entry.getKey());
            }
        } else {
            player = registerPlayerInNewGame(playerName);
        }
        return player;
    }

    public Player findGame() {
        return null;
    }

    public void removePlayerFromGame(int gameId, int playerId) {
        if (publicGames.containsKey(gameId)) {
            Maze maze = publicGames.get(gameId);
            maze.removePlayerFromGame(playerId);
        }
    }

    private static Maze CreateGame() {
        return MAZE_FACTORY.CreateMaze();
    }
}
