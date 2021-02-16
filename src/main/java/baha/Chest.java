package baha;

import container.Container;
import items.Key;
import lockable.Lockable;


public class Chest extends Container implements MapSite, Lockable {
    private boolean isLocked;
    private String neededKeyName;

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

    @Override
    public String getLockKeyName() {
        return neededKeyName;
    }
}
