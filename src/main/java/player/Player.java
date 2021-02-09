package player;

import baha.Door;
import baha.Room;
import items.Gold;
import items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Player implements Observer {
  private final List<Item> playerItems = new ArrayList<Item>();
  private final Gold goldAmount = new Gold(30);
  private String name;
  private Direction direction = Direction.east;
  private int currentDirectionAsInt = 0;
  private Room currentRoom;

  public void forward() {
    if (currentRoom.getMapSites()[currentDirectionAsInt] instanceof Door
        && !((Door) currentRoom.getMapSites()[currentDirectionAsInt]).isLocked()) {
      Door d = (Door) currentRoom.getMapSites()[currentDirectionAsInt];
      currentRoom = d.getRoom2();
    }
    // TODO:SEND A MESSAGE TO USER IF DOOR IS LOCKED OR NO DOOR OR IF DOOR CLOSED (SEND BACK DOOR
    // ANA FIGHT IN BACKWARD AND FORWARD
    // STATUS)
  }

  public void backward() {
    int backwardDirectionAsInt;
    backwardDirectionAsInt = getBackwardDirectionAsInt();
    if (currentRoom.getMapSites()[backwardDirectionAsInt] instanceof Door
        && !((Door) currentRoom.getMapSites()[backwardDirectionAsInt]).isLocked()) {
      Door d = (Door) currentRoom.getMapSites()[backwardDirectionAsInt];
      currentRoom = d.getRoom2();
    }
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

  @Override
  public void update(Observable o, Object arg) { // implement
  }

  public void turnLeft() {
    if (direction == Direction.north) direction = Direction.west;
    else if (direction == Direction.west) direction = Direction.south;
    else if (direction == Direction.south) direction = Direction.east;
    else if (direction == Direction.east) direction = Direction.north;
    setDirectionToInt();
  }

  public void turnRight() {
    if (direction == Direction.north) direction = Direction.east;
    else if (direction == Direction.east) direction = Direction.south;
    else if (direction == Direction.south) direction = Direction.west;
    else if (direction == Direction.west) direction = Direction.north;
    setDirectionToInt();
  }

  private void setDirectionToInt() {
    if (direction == Direction.east) currentDirectionAsInt = 0;
    else if (direction == Direction.south) currentDirectionAsInt = 1;
    else if (direction == Direction.west) currentDirectionAsInt = 2;
    else if (direction == Direction.north) currentDirectionAsInt = 3;
  }
}
