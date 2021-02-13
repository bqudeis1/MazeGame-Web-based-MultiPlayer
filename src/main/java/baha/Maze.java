package baha;

import player.Player;

import java.util.*;

public class Maze implements Cloneable, Comparator<Maze> {
    //TODO builder
    private final GameInfo gameInfo;
    private final List<Room> roomList = new ArrayList<Room>();
    private final HashMap<Room, Boolean> startingRooms = new HashMap();
    private static Set<Integer>gamesIds= new HashSet<>();

    public GameInfo getGameInfo() {
        return gameInfo;
    }

    public void addStartingRoom(Room r) {
        startingRooms.put(roomList.get(0), false);//this need to edit.
    }

    public Maze() {
        synchronized (this) {//TODO:check this synchronization
            gameInfo = new GameInfo();
            gameInfo.PlayersNumber=0;
            gameInfo.isGameFull=false;
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
        return gameInfo.PlayersNumber;
    }

    public Room getRoom(int roomId) {
        for (Room r : roomList) {
            if (r.getRoomNo() == roomId)
                return r;
        }
        return null;
    }

    public Room getStartingRoom() {
        return startingRooms.keySet()
                .stream()
                .filter(key -> {
                    startingRooms.get(key);
                    return true;
                })
                .findFirst().get();
    }

    @Override
    public int compare(Maze o1, Maze o2) {
        Objects.requireNonNull(o1);
        Objects.requireNonNull(o2);
        return o1.gameInfo.PlayersNumber.compareTo(o2.gameInfo.PlayersNumber);
    }

    public void addPlayer(Player player){
        Objects.requireNonNull(player);
        gameInfo.PlayersNumber++;
        gameInfo.players.put(player.getId(),player);
    }
    public void RemovePlayerFromGame(Player player){
        Objects.requireNonNull(player);
        gameInfo.players.remove(player.getId());
        gameInfo.PlayersNumber++;
    }
    public Player getPlayer(int playerId){
        return gameInfo.players.get(playerId);
    }

    private class GameInfo {
        private final int mazeId;
        private Integer PlayersNumber;
        private boolean isGameFull;
        private final Hashtable<Integer,Player> players= new Hashtable<Integer,Player>();

        public GameInfo() {
            mazeId = generateRandomMazeId();
        }
        private synchronized int generateRandomMazeId() {
            int rand=0;
          do{
               rand= 0 + (int) (Math.random() * ((100 - 0) + 1));
          }while (gamesIds.contains(rand));
          gamesIds.add(rand);
            return rand;
        }
    }
    //TODO: here u need to implement the hasCode method
}
