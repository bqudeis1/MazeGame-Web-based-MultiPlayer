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
        Maze game = MAZE_FACTORY.CreateMaze();
        int gameId = game.getGameId();
        reservedGames.put(gameId, game);
        return registerPlayerInGame(playerName, gameId);
    }

    public synchronized Player registerPlayerInGame(String playerName, int gameId) {
        Player player = new Player(playerName);
        if (publicGames.containsKey(gameId)) {
            registerPlayerInPublicGame(gameId, player);
        } else {
            registerPlayerInReservedGame(gameId, player);
        }
        return player;
    }

    public synchronized Player registerPlayerInRandomGame(String playerName) {
        if (publicGames.isEmpty()) {
            return registerPlayerInNewGame(playerName);
        } else {
            Map.Entry<Integer, Maze> entry = publicGames.firstEntry();
            return registerPlayerInGame(playerName, entry.getKey());
        }
    }

    private boolean registerPlayerInPublicGame(int gameId, Player player) {
        Maze mazeGame;
        mazeGame = publicGames.get(gameId);
        if (mazeGame.canAddPlayer()) {
            mazeGame.addPlayer(player);
            return true;
        }
        return false;
    }

    private void registerPlayerInReservedGame(int gameId, Player player) {
        Maze mazeGame;
        mazeGame = reservedGames.get(gameId);
        mazeGame.addPlayer(player);
        publicGames.put(mazeGame.getGameId(), mazeGame);
        reservedGames.remove(mazeGame.getGameId());
    }

    public void removePlayerFromGame(int gameId, int playerId) {
        if (publicGames.containsKey(gameId)) {
            Maze maze = publicGames.get(gameId);
            maze.removePlayerFromGame(playerId);
        }
    }

    public String processCommand(int gameId ,int playerId,String commandName){
        if(publicGames.containsKey(gameId)){
            return publicGames.get(gameId).execute(playerId,commandName);
        }
        return "no gameId mach ";
    }
}
