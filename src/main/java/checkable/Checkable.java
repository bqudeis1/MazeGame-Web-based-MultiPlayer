package checkable;

public interface Checkable {
    public String check();
}

interface Lockable{
     boolean isLocked();
     boolean Lock();
     void unlock();
}