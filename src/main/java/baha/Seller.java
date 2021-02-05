package baha;

import items.Item;

import java.util.List;

public class Seller implements MapSite {
  public int id = 0;
  private List<Item> sellerItem;

  public String look() {
    return "Seller";
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return null;
  }

  @Override
  public void enter(Maze maze) {}
}
