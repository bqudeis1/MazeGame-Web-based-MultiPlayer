package items;

public class FlashLight extends Item {
  public static final String name = "flashLight";
  private boolean status;
  private Gold price;
  //TODO you may use Close here to create the FlashLight Object.

  public boolean getStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public void turnOn() {
    setStatus(true);
  }

  public void turnOff() {
    setStatus(false);
  }

  @Override
  public String toString() {
    return "FlashLight  " + price.toString();
  }

  @Override
  public Gold getPrice() {
    return price;
  }

  public void setPrice(Gold gold) {
    this.price = gold;
  }

  @Override
  public String getName() {
    return name;
  }
}
