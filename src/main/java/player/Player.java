package player;

import baha.component.Door;
import baha.MapSite;
import baha.component.Room;
import baha.component.Seller;
import com.fasterxml.jackson.annotation.JsonIgnore;
import common.StringOutputFormatter;
import checkable.Checkable;
import container.Container;
import container.IContainer;
import items.FlashLight;
import items.Gold;
import items.Item;

import java.util.*;

public class Player extends Observable implements Observer, Comparator<Player>, IContainer {
    //TODO consider using builder to create player Object.
    private final List<Item> playerItems = new ArrayList<>();
    private final Gold goldAmount = new Gold(30);

    public String getName() {
        return name;
    }

    private final String name;
    private Direction direction = Direction.east;
    private int currentDirectionAsInt = 0;
    private Room currentRoom;
    private final int id;
    private int gameId;
    private static Set<Integer> playerIds = new HashSet<>();



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
        id = generateRandomPlayerId();//generat random id
    }

    public String forward() {
        //TODO refactor this contain doublect code ordinal.
        if (getFacingObject() instanceof Door
                && !((Door) getFacingObject()).isLocked()) {//TODO check if door is closed
            Door d = (Door) getFacingObject();
            currentRoomChanged(d);
            if (currentRoom.isWiningRoom()) {
                setChanged();
                notifyObservers();
            }
            return "you are in room " + currentRoom.getRoomNo();
        }
        return "there is no door or door is locked";
        // TODO:SEND A MESSAGE TO USER IF DOOR IS LOCKED OR NO DOOR OR IF DOOR CLOSED (SEND BACK DOOR
        // ANA FIGHT IN BACKWARD AND FORWARD
        // STATUS)
    }

    private void currentRoomChanged(Door d) {
        if(currentRoom==d.getRoom1()){
        ExitCurrentRoom();
        Room nextRoom = d.getRoom2();
        currentRoom = d.getRoom2();
        //check if player in the room here and start the fight.
        enterNewRoom();
        }else{
            ExitCurrentRoom();
            Room nextRoom = d.getRoom1();
            currentRoom = d.getRoom1();
        }
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

    private void Fight(Player player) {
        player.compare(player, player);

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
            if (currentRoom.isWiningRoom()) {
                setChanged();
                notifyObservers();
            }
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
            if (facingObject instanceof Checkable && !(facingObject instanceof Seller)) {
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
        this.goldAmount.decreaseGold(gold);
    }

    public void increasePlayerGold(Gold gold) {
        this.goldAmount.increaseGold(gold);
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
        playerItems.remove(retItem);
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
        return
                "Player Name: " + name + "\n" +
                        "Player Items=" + playerItems + "\n" +
                        "Direction: " + direction +
                        "Gold Amount: " + goldAmount +
                        ", GameCode \"" + gameId + "\"" +
                          "\n" + currentRoom.RoomInfo();
    }

    @Override
    public int compare(Player o1, Player o2) {
        Objects.requireNonNull(o1);
        Objects.requireNonNull(o2);
        return o1.getGoldAmount().compareTo(o2.goldAmount);
    }

    public void putItemsOnGround() {
        Container container = (Container) currentRoom.getMapSites()[5];
        container.addItems(playerItems);
    }

    private synchronized int generateRandomPlayerId() {
        int rand = 0;
        do {
            rand = (int) (Math.random() * ((10000 - 0) + 1));
        } while (playerIds.contains(rand));
        playerIds.add(rand);
        return rand;
    }


    public List<Item> getItemsContainer() {
        return playerItems;
    }

    @JsonIgnore
    @Override
    public boolean addItem(Item item) {
        return playerItems.add(item);
    }

    @JsonIgnore
    @Override
    public boolean addItems(List<Item> items) {
        return playerItems.addAll(items);
    }

    @JsonIgnore
    @Override
    public boolean isEmpty() {
        return playerItems.isEmpty();
    }

    @JsonIgnore
    @Override
    public List<Item> getItems() {
        List<Item> copy = new ArrayList<>(playerItems);
        playerItems.clear();
        return copy;
    }

    @JsonIgnore
    @Override
    public String getItemsName() {
        if (!isEmpty()) {
            StringBuilder itemsName = new StringBuilder("you Found: ");
            for (Item item : playerItems) {
                itemsName.append(item.getName()).append("\n");
            }
            return itemsName.append(".").toString();
        }
        return "Nothing found in " + getClass().getSimpleName();
    }

    @JsonIgnore
    @Override
    public boolean containItemName(String itemName) {
        return playerItems.stream()
                .anyMatch(item -> item.getName().equals(itemName));
    }

    @JsonIgnore
    @Override
    public Item get(String itemName) {
        return playerItems.stream()
                .filter(item -> itemName.equals(item.getName()))
                .findAny()
                .orElse(null);
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }
}
