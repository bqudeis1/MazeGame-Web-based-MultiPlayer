package baha.component;

import baha.MapSite;
import container.Container;
import items.Gold;
import items.Item;

import java.util.List;

public class Seller extends Container implements MapSite {

    public Gold getGold() {
        return gold;
    }

    private Gold gold;

    public void decreaseSellerGold(Gold gold) {
        gold.decreaseGold(gold);
    }

    public void increaseSellerGold(Gold gold) {
        gold.increaseGold(gold);
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
