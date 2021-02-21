package baha;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import container.Container;
import items.Item;
@JsonDeserialize(as = Painting.class)
public class Painting extends Container implements MapSite {
  private int id = 0;
  private String containsKeyName;
  private Item keyItem;
  private final String name="Painting";


  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

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
