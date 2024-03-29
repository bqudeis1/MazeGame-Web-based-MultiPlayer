package commands.tradeCommands;

import baha.component.Seller;
import commands.Command;
import items.Gold;
import items.Item;
import player.Player;

import java.util.Objects;

public class SellCommand implements Command<String, String> {
    Player player;

    public SellCommand(Player p) {
        this.player = p;
    }

    @Override
    public String execute(String... input) {
        Objects.requireNonNull(input);
        Seller seller = (Seller) player.getFacingObject();
        String itemName = input[0];
        if (player.containItemName(itemName)) {
            Item itemToSell = player.get(itemName);//what if there is not gold to buy or sell?!!! the item will delete from here ?!!!?
            Gold gold = itemToSell.getPrice();
            if (doseSellerHaveMoneyToBuy(gold,seller)) {//TODO function name change.
                seller.addItem(player.getAndRemove(itemName));
                seller.decreaseSellerGold(itemToSell.getPrice());
                player.increasePlayerGold(itemToSell.getPrice());
                return "You just Sell " + itemName + ".";
            }
            return "Seller don't have Enough money.";
        }
        return "You don't have " + itemName + " to sell.";
    }

    private boolean doseSellerHaveMoneyToBuy(Gold gold, Seller seller) {
        return seller.getGold().compareTo(gold) > 0;
    }
}
