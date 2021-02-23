package baha.component;

import baha.MapSite;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import container.Container;
import items.Gold;
import items.Item;

import java.util.List;
@JsonDeserialize(as = Seller.class)
public class Seller extends Container implements MapSite {
    private Gold gold;

    public Seller() {

    }

    public Gold getGold() {
        return gold;
    }

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

    @Override
    public String toString() {
        String sellerInfo="";
        for(Item item : itemsContainer) {
            sellerInfo="this seller have "+item.getName()+" for "+item.getPrice().getAmount()+" golds.\n";
        }
        return sellerInfo;
    }
}
