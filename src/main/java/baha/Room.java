package baha;

import java.util.Arrays;

public class Room implements MapSite {
  private final int roomNo;
  private final MapSite[] mapSites = new MapSite[5];
  int playerDirection = 0;
  private boolean dark;
  private boolean switchLightExists;

  public Room(int roomNo) {
    this.roomNo = roomNo;
  }

  public boolean isDark() {
    return dark;
  }

  public void setDark(boolean dark) {
    this.dark = dark;
  }

  public boolean isSwitchLightExists() {
    return switchLightExists;
  }

  public void setSwitchLightExists(boolean switchLightExists) {
    this.switchLightExists = switchLightExists;
  }

  public void turnLightOn() {
    if (isSwitchLightExists()) setDark(false);
  }

  public void turnLightOff() {
    if (isSwitchLightExists()) setDark(true);
  }

  public int getRoomNo() {
    return roomNo;
  }

  public MapSite[] getMapSites() {
    return mapSites;
  }

  public void setMapSites(MapSite mapSite, int side) {
    this.mapSites[side] = mapSite;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return null;
  }


  @Override
  public void enter(Maze maze) {}

  @Override
  public String toString() {
    return "Room{" +
            "roomNo=" + roomNo +
            ", mapSites=" + Arrays.toString(mapSites) +
            ", playerDirection=" + playerDirection +
            ", dark=" + dark +
            ", switchLightExists=" + switchLightExists +
            '}';
  }
}
