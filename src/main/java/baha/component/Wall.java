package baha.component;

import baha.MapSite;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = Wall.class)
public class Wall implements MapSite {


  private int id = 0;
  private final String name="Wall";

  public Wall() {
  }

//  public void setName(String name) {
//    this.name = name;
//  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return null;
  }
}
