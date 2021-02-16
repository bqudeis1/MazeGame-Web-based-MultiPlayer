package baha;

import container.Container;
import items.Gold;
import items.Item;

import java.util.List;

public class Seller extends Container implements MapSite {
    private final int id = 0;
    private Gold gold;

    public void decreaseSellerGold(Gold gold) {
        gold.decreaseGold(gold);
    }

    public void increaseSellerGold(Gold gold) {
        gold.increaseGold(gold);
    }


    public Item getAndRemove(String itemName) {//TODO:rename this to meaningful name
        Item retItem = null;
        for (Item item : ItemsContainer) {
            if (item.getName().equals(itemName))
                retItem = item;
        }
        return retItem;
    }

    @Override
    public String look() {
        return "Seller";
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
