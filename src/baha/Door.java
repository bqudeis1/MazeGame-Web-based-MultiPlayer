package baha;

public class Door implements MapSite {
    private boolean isClosed;
    private boolean locked;
    private String neededKeyName;
    private final Room room1;
    private final Room room2;

    public Door(Room r1, Room r2) {//check r1,r2 is not null
        room1=r1;
        room2=r2;
    }


    private boolean isClosed() {
        return isClosed;
    }
    public void setClosed(boolean closed) {
        this.isClosed = closed;
    }
    public void open(){setClosed(false);}
    public void close(){setClosed(true);}
    public boolean isLocked() {
        return locked;
    }
    public void setLocked(boolean locked) {
        this.locked = locked;
    }
    public String getNameNeededKey() {
        return neededKeyName;
    }
    public void setNameNeededKey(String neededKeyName) {
        this.neededKeyName = neededKeyName;
    }
    public String look(){return "Door";}


    public void check(){}
    public void useNameKey(){}

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
    }

    @Override
    public void enter(Maze maze) {

    }
}
