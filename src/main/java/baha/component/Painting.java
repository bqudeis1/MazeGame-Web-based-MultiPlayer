package baha.component;

import baha.MapSite;
import container.Container;
import items.Item;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = Painting.class)
public class Painting extends Container implements MapSite {
  private int id = 0;

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

  @Override
  public Object clone() throws CloneNotSupportedException {
    return null;
  }


  @Override
  public String check() {
    return null;
  }
}

