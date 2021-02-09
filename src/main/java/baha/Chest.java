package baha;

import items.Item;

import java.util.List;

public class Chest implements MapSite {
  private boolean locked;
  private String neededKeyName;
  private List<Item> sellerItem;

  public void check() {}

  public String look() {
    return "Chest";
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return null;
  }

  @Override
  public void enter(Maze maze) {}
}
