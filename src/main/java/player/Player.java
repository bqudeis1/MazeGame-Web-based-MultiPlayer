package player;

import baha.Door;
import baha.MapSite;
import baha.Room;
import common.StringOutputFormatter;
import checkable.Checkable;
import container.Container;
import container.IContainer;
import items.FlashLight;
import items.Gold;
import items.Item;

import java.util.*;

public class Player extends Container implements Observer, Comparator<Player> {
    //TODO consider using builder to create player Object.
    private final List<Item> playerItems = new ArrayList<>();
    private final Gold goldAmount = new Gold(30);
    private final String name;
    private Direction direction = Direction.east;
    private int currentDirectionAsInt = 0;
    private Room currentRoom;
    private final int id;
    private int gameId;

    public Gold getGoldAmount() {
        return goldAmount;
    }

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
        if (getFacingObject() instanceof Door
                && !((Door) getFacingObject()).isLocked()) {
            Door d = (Door) getFacingObject();
            currentRoomChanged(d);
            return "you are in room " + currentRoom.getRoomNo();
        }
        return "there is no door or door is locked";
        // TODO:SEND A MESSAGE TO USER IF DOOR IS LOCKED OR NO DOOR OR IF DOOR CLOSED (SEND BACK DOOR
        // ANA FIGHT IN BACKWARD AND FORWARD
        // STATUS)
    }

    private void currentRoomChanged(Door d) {
        ExitCurrentRoom();
        Room nextRoom=d.getRoom2();
        currentRoom = d.getRoom2();
        //check if player in the room here and start the fight.
        enterNewRoom();
    }

    private void ExitCurrentRoom() {
        playerItems.forEach(item -> {
            if (item instanceof FlashLight) {
                ((FlashLight) item).deleteObserver(currentRoom);
            }
        });
    }

    public String switchLight() {
        if (currentRoom.isSwitchLightExists()) {
            currentRoom.switchLight();
            return "You just switched the light";
        }
        return "Room dose not have light";
    }

    private void Fight(Player player){
     player.compare(player,player);

    }
    private void enterNewRoom() {
        playerItems.forEach(item -> {
            if (item instanceof FlashLight) {
                ((FlashLight) item).addObserver(currentRoom);
            }
        });
    }

    public String backward() {
        int backwardDirectionAsInt;
        backwardDirectionAsInt = getBackwardDirectionAsInt();
        if (getFacingObject() instanceof Door
                && !((Door) getFacingObject()).isLocked()) {
            Door d = (Door) getFacingObject();
            currentRoom = d.getRoom2();
            return "you are in room " + currentRoom.getRoomNo();
        }
        return "there is no door or door is locked";
    }

    public String look() {
        return currentRoom.isLightsOn() ? "Room is Dark" : getFacingObject().look();
    }

    public MapSite getFacingObject() {
        return currentRoom.getMapSites()[currentDirectionAsInt];
    }

    private int getBackwardDirectionAsInt() {
        int backwardDirectionAsInt;
        if (currentDirectionAsInt == 0) backwardDirectionAsInt = 2;
        else if (currentDirectionAsInt == 2) backwardDirectionAsInt = 0;
        else if (currentDirectionAsInt == 1) backwardDirectionAsInt = 3;
        else backwardDirectionAsInt = 1;
        return backwardDirectionAsInt;
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
        //better replace what player facing function with variable.
        if (!currentRoom.isLightsOn()) {
            MapSite facingObject = getFacingObject();
            if (facingObject instanceof Checkable) {
                String CheckResultAsAString = ((Checkable) facingObject).check();
                if (facingObject instanceof IContainer) {
                    Container container = (Container) facingObject;
                    playerItems.addAll(container.getItems());
                    return CheckResultAsAString;
                }
                return CheckResultAsAString;
            }
        } else {
            return "Room is Dark";
        }
        return "nothing to check";
    }

    public void decreasePlayerGold(Gold gold) {
        gold.decreaseGold(gold);
    }

    public void increasePlayerGold(Gold gold) {
        gold.increaseGold(gold);
    }

    private void setDirectionToInt() {
        currentDirectionAsInt = direction.ordinal();
    }

    public Item getAndRemove(String itemName) {//TODO:rename this to meaningful name
        Item retItem = null;
        for (Item item : playerItems) {
            if (item.getName().equals(itemName))
                retItem = item;
        }
        return retItem;
    }

    public boolean playerHave(String itemName) {
        return playerItems.stream()
                .anyMatch(item -> item.getName().equals(itemName));
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

    @Override
    public int compare(Player o1, Player o2) {
        Objects.requireNonNull(o1);
        Objects.requireNonNull(o2);
        return o1.getGoldAmount().compareTo(o2.goldAmount);
    }

    public void putItemsOnGround() {
        Container container= (Container) currentRoom.getMapSites()[5];
        container.addItems(playerItems);
    }
}
