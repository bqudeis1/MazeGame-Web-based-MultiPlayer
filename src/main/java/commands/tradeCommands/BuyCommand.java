package commands.tradeCommands;

import baha.Seller;
import commands.Command;
import items.Item;
import player.Player;

import java.util.Objects;

public class BuyCommand implements Command<String,String> {
    Player player;

    public BuyCommand(Player p) {
        this.player = p;
    }

    @Override
    public String execute(String... input) {
        Objects.requireNonNull(input);
        Seller seller = (Seller) player.getFacingObject();
        String itemName = input[0].replaceFirst("buy", "");
        if (seller.containItemName(itemName)) {
            Item itemToSell= seller.getAndRemove(itemName);
            player.addItem(itemToSell);
            seller.increaseSellerGold(itemToSell.getPrice());
            player.decreaseSellerGold(itemToSell.getPrice());
            return "You just buy " + itemName + ".";
        }
        return "You don't have " + itemName + " to sell.";
    }
}
