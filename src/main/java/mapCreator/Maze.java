package mapCreator;

import baha.Room;
import items.Gold;
import player.Player;

import java.util.*;

public class Maze implements Cloneable, Comparator<Maze> {
    //TODO builder
    private final GameInfo gameInfo;
    private final List<Room> roomList = new ArrayList<Room>();
    private final Set<Room> startingRooms = new HashSet<>();
    private static Set<Integer> gamesIds = new HashSet<>();

    public GameInfo getGameInfo() {
        return gameInfo;
    }

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

    public Room returnRoom(int index) {
        return roomList.get(index);
    }

    public int getGameId() {
        return gameInfo.mazeId;
    }

    public int getPlayersNumber() {
        return gameInfo.playersNumber;
    }

    public Room getRoom(int roomId) {
        for (Room r : roomList) {
            if (r.getRoomNo() == roomId)
                return r;
        }
        return null;
    }

    public Room getStartingRoom() {
        if(!startingRooms.isEmpty()){
            return startingRooms.iterator().next();
        }
        return null;
    }

    @Override
    public int compare(Maze o1, Maze o2) {
        Objects.requireNonNull(o1);
        Objects.requireNonNull(o2);
        return o1.gameInfo.playersNumber.compareTo(o2.gameInfo.playersNumber);
    }

    public void addPlayer(Player player) {
        Objects.requireNonNull(player);
        gameInfo.playersNumber++;
        gameInfo.players.put(player.getId(), player);
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

    private class GameInfo {
        private final int mazeId;
        private Integer playersNumber;
        private boolean isGameFull;
        private final Hashtable<Integer, Player> players = new Hashtable<Integer, Player>();

        public GameInfo() {
            mazeId = generateRandomMazeId();
        }

        private synchronized int generateRandomMazeId() {
            int rand = 0;
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

        private void addPlayer(Player player) {
            Objects.requireNonNull(player);
            players.put(player.getId(), player);
            playersNumber = players.size();//you may need to remove this variable.
        }
    }
    //TODO: here u need to implement the hasCode method
}
