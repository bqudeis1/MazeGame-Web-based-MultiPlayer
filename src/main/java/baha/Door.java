package baha;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import json.CustomDoorSerializer;

@JsonSerialize(using = CustomDoorSerializer.class)
public class Door implements MapSite {
  // @Expose(serialize = false, deserialize = true)
  private final Room room1;
  // @Expose(serialize = false, deserialize = true)
  private final transient Room room2;
  private boolean isClosed;
  private boolean locked;
  private transient String neededKeyName;

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

  private boolean isClosed() {
    return isClosed;
  }

  public void setClosed(boolean closed) {
    this.isClosed = closed;
  }

  public void open() {
    setClosed(false);
  }

  public void close() {
    setClosed(true);
  }

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

  public String look() {
    return "Door";
  }

  public void check() {}

  public void useNameKey() {}

  @Override
  public Object clone() throws CloneNotSupportedException {
    return null;
  }

  @Override
  public void enter(Maze maze) {}
}
