package baha.component;

import baha.MapSite;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import container.Container;
import items.Item;
import items.Key;
import lockable.Lockable;

@JsonDeserialize(as = Chest.class)
public class Chest extends Container implements MapSite, Lockable {
    private boolean isLocked;
    private String neededKeyName;
    private final String name="Chest";


    public String getName() {
        return name;
    }

    public Chest() {
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public String getNeededKeyName() {
        return neededKeyName;
    }

    public void setNeededKeyName(String neededKeyName) {
        this.neededKeyName = neededKeyName;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
    }


    @Override
    public String check() {
        if (!isLocked)
            return getItemsName();
        return getLockKeyName();
    }

    @Override
    public boolean isLocked() {
        return isLocked;
    }

    @Override
    public void lock(Key key) {

    }

    @Override
    public void unlock(Key key) {
        if(key.getName().equals(neededKeyName))
            isLocked = false;
    }
    @JsonIgnore
    @Override
    public String getLockKeyName() {
        return neededKeyName;
    }

    @Override
    public String toString() {
        String lock=isLocked?" is locked ":" unlocked ";
        String items;
        for(Item item : itemsContainer) {
            items="this chest contains "+item.getName();
        }
        return name+lock+"\nneeded key name to lock/unlock: "+neededKeyName+".\n";
    }
}
