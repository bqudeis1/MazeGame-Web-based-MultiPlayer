package items;

import baha.component.Wall;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = Key.class)
public class Key implements Item {
  private  String name = "key";
  private Gold price=new Gold(10);

  public Key() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Gold getPrice() {
    return price;
  }

  public void setPrice(Gold price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return name + " Key," + " key price: " + price.toString();
  }
}
