package baha;

import java.util.*;

public class Maze implements Cloneable, Comparator<Maze> {
    private final GameInfo gameInfo;
    private final List<Room> roomList = new ArrayList<Room>();
    private final HashMap<Room, Boolean> startingRooms = new HashMap();
    private boolean isGameFull;
    private Integer numberOfPlayers;

    public GameInfo getGameInfo() {
        return gameInfo;
    }

    public void addStartingRoom(Room r) {
        startingRooms.put(roomList.get(0), false);//this need to edit.
    }

    public Maze() {
        synchronized (this) {
            gameInfo = new GameInfo();
        }
//        startingRooms.put(roomList.get(0), false);
//        startingRooms.put(roomList.get(1), false);
//        startingRooms.put(roomList.get(19), false);
//        startingRooms.put(roomList.get(23), false);
        isGameFull = false;
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
        return (o1).numberOfPlayers.compareTo(o2.numberOfPlayers);
    }

    private class GameInfo {
        private final int mazeId;
        private int PlayersNumber;

        //list of Players or PlayersId.
        public GameInfo() {
            mazeId = generateMazeId();
        }

        private synchronized int generateMazeId() {
            return 0 + (int) (Math.random() * ((100 - 0) + 1));
        }
    }

    // here u need to implement the hasCode method
}
