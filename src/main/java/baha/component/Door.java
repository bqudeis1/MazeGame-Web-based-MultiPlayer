package baha.component;

import baha.MapSite;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import items.Key;
import json.CustomDoorSerializer;
import lockable.Lockable;

@JsonSerialize(using = CustomDoorSerializer.class)
public class Door implements MapSite, Lockable {
    // @Expose(serialize = false, deserialize = true)
    private final Room room1;
    // @Expose(serialize = false, deserialize = true)
    private final transient Room room2;
    private boolean isOpen;
    private boolean isLocked;
    private transient String neededKeyName;

    public Door() {
        room1=new Room(-1);
        room2=new Room(-1);
    }

    public Door(Room r1, Room r2) { // check r1,r2 is not null
        room1 = r1;
        room2 = r2;
    }

    public String getNeededKeyName() {
        return neededKeyName;
    }

    public void setNeededKeyName(String neededKeyName) {
        this.neededKeyName = neededKeyName;
    }

    public Room getRoom1() {
        return room1;
    }

    public Room getRoom2() {
        return room2;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    private boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        this.isOpen = open;
    }

    public String close() {
        if(isOpen){
            setOpen(false);
            return "The Door now Closed.";
        }
            return "The Door already Close.";
    }

    public boolean isLocked() {
        return isLocked;
    }

    @Override
    public void lock(Key key) {
        if(key.getName().equals(neededKeyName))
            isLocked = false;
    }

    @Override
    public void unlock(Key key) {
        if(key.getName().equals(neededKeyName))
            isLocked = false;
    }

    @Override
    public String getLockKeyName() {
        return neededKeyName;
    }

    public String check() {
        if (isLocked) {
            return "Door is locked " + neededKeyName + " needed to unlock";
        }
        return "Door is Open";
    }

    public String open() {
        if (!isLocked) {
            if (isOpen) {
                return "Door is Open";
            }
            isOpen = true;
            return "Now the door is open";
        }
        return "Door is locked " + neededKeyName + " needed to unlock";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
    }

    @Override
    public String toString() {
        String doorLockStatus=isLocked?"locked":"unlocked";
        String doorClosedStatus=isOpen?"open":"closed";
        return "this door links between Room "+room1.getRoomNo()+" and "+room2.getRoomNo()
                +".\nthis door is "+doorLockStatus +" and "+doorClosedStatus+".\n";
    }
}
