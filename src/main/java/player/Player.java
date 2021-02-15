package player;

import baha.Door;
import baha.MapSite;
import baha.Room;
import baha.StringOutputFormatter;
import checkable.Checkable;
import items.Gold;
import items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Player implements Observer {
    //TODO consider using build to create player Object.
    private final List<Item> playerItems = new ArrayList<>();
    private final Gold goldAmount = new Gold(30);
    private final String name;
    private Direction direction = Direction.east;
    private int currentDirectionAsInt = 0;
    private Room currentRoom;
    private final int id;
    private int gameId;

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getId() {
        return id;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Player(String playerName) {
        name = playerName;
        id = 0;//generat random id
    }

    public String forward() {
        //TODO refactor this contain doublect code ordinal.
        if (currentRoom.getMapSites()[currentDirectionAsInt] instanceof Door
                && !((Door) currentRoom.getMapSites()[currentDirectionAsInt]).isLocked()) {
            Door d = (Door) currentRoom.getMapSites()[currentDirectionAsInt];
            currentRoom = d.getRoom2();
            return "you are in room " + currentRoom.getRoomNo();
        }
        return "there is no door or door is locked";
        // TODO:SEND A MESSAGE TO USER IF DOOR IS LOCKED OR NO DOOR OR IF DOOR CLOSED (SEND BACK DOOR
        // ANA FIGHT IN BACKWARD AND FORWARD
        // STATUS)
    }

    public String backward() {
        int backwardDirectionAsInt;
        backwardDirectionAsInt = getBackwardDirectionAsInt();
        if (currentRoom.getMapSites()[backwardDirectionAsInt] instanceof Door
                && !((Door) currentRoom.getMapSites()[backwardDirectionAsInt]).isLocked()) {
            Door d = (Door) currentRoom.getMapSites()[backwardDirectionAsInt];
            currentRoom = d.getRoom2();
            return "you are in room " + currentRoom.getRoomNo();
        }
        return "there is no door or door is locked";
    }

    private int getBackwardDirectionAsInt() {
        int backwardDirectionAsInt;
        if (currentDirectionAsInt == 0) backwardDirectionAsInt = 2;
        else if (currentDirectionAsInt == 2) backwardDirectionAsInt = 0;
        else if (currentDirectionAsInt == 1) backwardDirectionAsInt = 3;
        else backwardDirectionAsInt = 1;
        return backwardDirectionAsInt;
    }

    public void playerStatus() {
        System.out.println("You are facing " + direction);
        System.out.println("You have " + goldAmount + " gold");
        // print keys and flashlight
    }

    public String turnLeft() {
        //TODO see if the player in trad mod what what happen if the player asked to turn left?.
        if (direction == Direction.north) direction = Direction.west;
        else if (direction == Direction.west) direction = Direction.south;
        else if (direction == Direction.south) direction = Direction.east;
        else if (direction == Direction.east) direction = Direction.north;
        setDirectionToInt();
        return StringOutputFormatter.getDirectionInAppropriateFormat(direction);
    }

    public String turnRight() {
        if (direction == Direction.north) direction = Direction.east;
        else if (direction == Direction.east) direction = Direction.south;
        else if (direction == Direction.south) direction = Direction.west;
        else if (direction == Direction.west) direction = Direction.north;
        setDirectionToInt();
        return StringOutputFormatter.getDirectionInAppropriateFormat(direction);
    }

    public String check() {
        if (!currentRoom.isDark()) {
            MapSite object = currentRoom.getMapSites()[currentDirectionAsInt];
            if (object instanceof Checkable) {
               return  ((Checkable) object).check();
            }
        }
        return  "nothing to check";
    }

    private void setDirectionToInt() {
        currentDirectionAsInt = direction.ordinal();
    }

    public int getGameId() {
        return gameId;
    }

    @Override
    public void update(Observable o, Object arg) { // implement
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerItems=" + playerItems +
                ", goldAmount=" + goldAmount +
                ", name='" + name + '\'' +
                ", direction=" + direction +
                ", currentRoom=" + currentRoom +
                '}';
    }
}
