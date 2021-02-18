package baha;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import container.Container;
import items.Item;
@JsonDeserialize(as = Painting.class)
public class Painting extends Container implements MapSite {
  public int id = 0;
  private String containsKeyName;
  private Item keyItem;

  public Painting(){

  }

  public String look() {
    return "Painting";
  }

  public String getContainsKeyName() {
    return containsKeyName;
  }

  public void setContainsKeyName(String containsKeyName) {
    this.containsKeyName = containsKeyName;
  }

  public Item getKeyItem() {
    return keyItem;
  }

  public void setKeyItem(Item keyItem) {
    this.keyItem = keyItem;
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
