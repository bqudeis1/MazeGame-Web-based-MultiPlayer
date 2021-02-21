package baha.component;

import baha.MapSite;
import container.Container;
import items.Item;

public class Painting extends Container implements MapSite {
  public int id = 0;


  public String look() {
    return "Painting";
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return null;
  }


  @Override
  public String check() {
    return null;
  }
}
