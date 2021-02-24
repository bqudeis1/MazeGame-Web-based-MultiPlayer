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
        this.gold = new Gold(100);
    }

    public Gold getGold() {
        return gold;
    }

    public void decreaseSellerGold(Gold gold) {
        this.gold.decreaseGold(gold);
    }

    public void increaseSellerGold(Gold gold) {
        this.gold.increaseGold(gold);
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
        //TODO:

        return "seller can't be checked";
    }

    public String getItemsName() {
        if (!isEmpty()) {
            StringBuilder itemsName = new StringBuilder("Trader Items:  ");
            for (Item item : itemsContainer) {
                itemsName.append("\n").append(item.getName()).append("  PRICE: " + item.getPrice()).append(" Coins.");
            }
            return itemsName.toString();
        }
        return "Trader does not have any item to sell " + getClass().getSimpleName();
    }

    @Override
    public String toString() {
        String sellerInfo = "";
        for (Item item : itemsContainer) {
            sellerInfo = "this seller have " + item.getName() + " for " + item.getPrice().getAmount() + " golds.\n";
        }
        return sellerInfo;
    }
}
