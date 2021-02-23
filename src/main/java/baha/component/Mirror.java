package baha.component;

import baha.MapSite;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import container.Container;
import items.Item;

@JsonDeserialize(as = Mirror.class)
public class Mirror extends Container implements MapSite {
  private final String name = "Mirror";

  public String getName() {
    return name;
  }

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

  @Override
  public String toString() {
    String mirrorInfo = "";
    for (Item item : itemsContainer) {
      mirrorInfo = "this mirror contains " + item.getName()+".\n";
    }
    return mirrorInfo;
  }
}