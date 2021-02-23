package baha;

import baha.component.Room;
import commands.state_pattern.CommandExecutor;
import gameContext.GameStatus;
import items.Gold;
import player.Player;
import timer.GameTimer;

import java.util.*;

public class Maze implements Cloneable, Comparator<Maze> {
    //TODO builder
    private final GameInfo gameInfo;
    private final List<Room> roomList = new ArrayList<Room>();
    private final Set<Room> startingRooms = new HashSet<>();
    private static final Set<Integer> gamesIds = new HashSet<>();
    private HashMap<Integer, CommandExecutor> commandExecutorHashMap = new HashMap<>();

    public void addStartingRoom(Room r) {
        startingRooms.add(r);
    }

    public Maze() {
        synchronized (this) {//TODO:check this synchronization
            gameInfo = new GameInfo();
            gameInfo.playersNumber = 0;
            gameInfo.isGameFull = false;
        }
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void addRoom(Room r) {
        if (r != null) roomList.add(r);
    }

    public int getGameId() {
        return gameInfo.gameId;
    }

    public Room getStartingRoom() {
        if (!startingRooms.isEmpty()) {
            return startingRooms.iterator().next();
        }
        return null;
    }

    @Override
    public int compare(Maze maze1, Maze maze2) {
        Objects.requireNonNull(maze1);
        Objects.requireNonNull(maze2);
        boolean gameOneInWaitingMod = maze1.gameInfo.gameStatus.isGameInWaitingMod();
        boolean gameTwoInWaitingMod = maze1.gameInfo.gameStatus.isGameInWaitingMod();

        if (gameOneInWaitingMod && gameTwoInWaitingMod) {
            return maze1.gameInfo.playersNumber.compareTo(maze2.gameInfo.playersNumber);
        } else if (gameOneInWaitingMod) {
            return 1;
        } else if (gameTwoInWaitingMod) {
            return -1;
        }
        return maze1.gameInfo.playersNumber.compareTo(maze2.gameInfo.playersNumber);
    }

    public void addPlayer(Player player) {
        Objects.requireNonNull(player);
        gameInfo.addPlayer(player);
        commandExecutorHashMap.put(player.getId(), new CommandExecutor(player));
    }

    public String execute(int playerId, String commandName) {
        return commandExecutorHashMap.get(playerId).processCommand(commandName);
    }

    public boolean canAddPlayer() {
        return (!gameInfo.isGameFull && getGameStatus().isGameInWaitingMod());
    }

    public void removePlayerFromGame(int playerId) {
        if (gameInfo.players.contains(playerId)) {
            Player player = gameInfo.removePlayer(playerId);
            if (player != null) {
                player.putItemsOnGround();
                Gold playerGold = player.getGoldAmount();
                Gold eachPlayerPortion = partitioningPlayerGold(playerGold);
                increaseEachPlayersGold(eachPlayerPortion);
            }
        }
    }

    private void increaseEachPlayersGold(Gold eachPlayerPortion) {
        gameInfo.players.forEach((key, value) -> {
            System.out.println(", Value: " + value);
            value.increasePlayerGold(eachPlayerPortion);
        });
    }

    private Gold partitioningPlayerGold(Gold playerGold) {
        return playerGold.divideGold(gameInfo.playersNumber);
    }

    public Player getPlayer(int playerId) {
        return gameInfo.players.get(playerId);
    }

    public GameStatus getGameStatus() {
        //clone the object and return the clone -> u dot need other objects to change game status.
        return gameInfo.gameStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((gameInfo == null) ? 0 : gameInfo.hashCode());
        return result;
    }


    private class GameInfo implements Observer {
        private final int gameId;
        private final Hashtable<Integer, Player> players = new Hashtable<>();
        private Integer playersNumber;
        private boolean isGameFull;
        private final GameStatus gameStatus;


        public GameInfo() {
            gameStatus = new GameStatus(GameTimer.getInstance());
            gameId = generateRandomMazeId();
        }

        private synchronized int generateRandomMazeId() {
            int rand;
            do {
                rand = 0 + (int) (Math.random() * ((100 - 0) + 1));
            } while (gamesIds.contains(rand));
            gamesIds.add(rand);
            return rand;
        }

        private Player removePlayer(int playerId) {
            Player player = players.remove(playerId);
            playersNumber = players.size();
            return player;
        }

        private synchronized void addPlayer(Player player) {
            if (gameStatus.isGameStart()) {
                throw new IndexOutOfBoundsException();
            } else if (gameStatus.isGameFinished()) {
                throw new IndexOutOfBoundsException();
            }
            if (!isGameFull && gameStatus.isGameInWaitingMod()) {
                player.setGameId(gameId);
                player.setCurrentRoom(getStartingRoom());
                players.put(player.getId(), player);
                playersNumber = players.size();//you may need to remove this variable.
                isGameFull = playersNumber == 4;
                player.addObserver(gameStatus);
            }
        }

        @Override
        public int hashCode() {
            final int prime = 7;
            int result = 1;
            result = prime * result + ((gameId));
            return result;
        }

        @Override
        public boolean equals(final Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            final GameInfo other = (GameInfo) obj;
            if (gameInfo == null) {
                return false;
            } else return gameId == other.gameId;
        }


        @Override
        public void update(Observable o, Object arg) {
            if (o instanceof Player) {
                Player p = (Player) o;
                gameStatus.setGameResult(p.getName());
                gameStatus.setGameFinished(true);
                o.deleteObserver(this);
            }
        }
    }
    //TODO: here u need to implement the hasCode method
}
