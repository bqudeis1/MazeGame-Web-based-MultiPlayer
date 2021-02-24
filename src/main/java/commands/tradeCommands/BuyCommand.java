package commands.tradeCommands;

import baha.component.Seller;
import commands.Command;
import items.Gold;
import items.Item;
import player.Player;

import java.util.Objects;

public class BuyCommand implements Command<String, String> {
    Player player;

    public BuyCommand(Player p) {
        this.player = p;
    }

    @Override
    public String execute(String... input) {
        Objects.requireNonNull(input);
        Seller seller = (Seller) player.getFacingObject();
        String itemName = input[0];
        if (seller.containItemName(itemName)) {
            Item itemToSell = seller.get(itemName);
            Gold gold = itemToSell.getPrice();
            if (dosePlayerHaveMoneyToBuy(gold)) {//TODO: function name change.
                player.addItem(seller.getAndRemove(itemName));
                seller.increaseSellerGold(itemToSell.getPrice());
                player.decreasePlayerGold(itemToSell.getPrice());
                return "You just buy " + itemName + ".";
            }
            return "You don't have Enough money.";
        }
        return "Seller doesn't have " + itemName + " to sell.";
    }

    private boolean dosePlayerHaveMoneyToBuy(Gold gold) {
        return player.getGoldAmount().compareTo(gold) >= 0;
    }
}
