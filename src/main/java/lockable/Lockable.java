package lockable;

import checkable.Checkable;
import items.Key;

public interface Lockable extends Checkable {
    boolean isLocked();
    void lock(Key key);
    void unlock(Key key);
    String getLockKeyName();
}
