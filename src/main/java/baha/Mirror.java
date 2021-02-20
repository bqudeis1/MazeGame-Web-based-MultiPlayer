package baha;

import container.Container;
import items.Item;

public class Mirror extends Container implements MapSite {

  @Override
  public Object clone() throws CloneNotSupportedException {
    return null;
  }


  @Override
  public String check() {
    return null;
  }

  @Override
  public String look() {
    return "You See a silhouette of you";
  }
}
