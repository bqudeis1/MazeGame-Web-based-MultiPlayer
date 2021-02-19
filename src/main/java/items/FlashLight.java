package items;

import baha.Room;
import baha.Wall;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Observable;
import java.util.Observer;
@JsonDeserialize(as = FlashLight.class)
public class FlashLight extends Observable implements Item {
    private final String name = "FlashLight";
    private boolean status;
    private Gold price=new Gold(2);

    //TODO you may use Close here to create the FlashLight Object.

    public FlashLight() {
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
        notifyObservers();
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

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyAll();
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        super.deleteObserver(o);
        setChanged();
        notifyAll();
    }
}
