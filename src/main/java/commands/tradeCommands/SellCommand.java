package commands.tradeCommands;

import baha.Seller;
import commands.Command;
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
        String itemName = input[0].replaceFirst("sell", "");
        if (player.containItemName(itemName)) {
            Item itemToSell= player.getAndRemove(itemName);
            seller.addItem(itemToSell);
            seller.decreaseSellerGold(itemToSell.getPrice());
            player.increaseSellerGold(itemToSell.getPrice());
            return "You just sell " + itemName + ".";
        }
        return "You don't have " + itemName + " to sell.";
    }
}
