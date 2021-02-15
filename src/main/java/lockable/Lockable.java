package lockable;

import items.Key;

public interface Lockable {
    boolean isLocked();
    void lock(Key key);
    void unlock(Key key);
    String getLockKeyName();
}
