package baha;

import java.util.ArrayList;
import java.util.List;

public class Maze implements Cloneable {
  private final List<Room> roomSet = new ArrayList<Room>();

  public List<Room> getRoomSet() {
    return roomSet;
  }

  public void addRoom(Room r) {
    if (r != null) roomSet.add(r);
  }

  public Room returnRoom(int index) {
    return roomSet.get(index);
  }
}
