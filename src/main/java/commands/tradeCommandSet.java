package commands;

import commands.tradeCommands.BuyCommand;
import commands.tradeCommands.ListCommand;
import commands.tradeCommands.SellCommand;
import player.Player;

public enum tradeCommandSet implements CommandsSet {
    sell("sell") {
        @Override
        public Command createCommand(Player p) { return new SellCommand(p); }
    },buy("buy") {
        @Override
        public Command createCommand(Player p) { return new BuyCommand(p); }
    },list("list") {
        @Override
        public Command createCommand(Player p) { return new ListCommand(p); }
    };

    tradeCommandSet(String commandName) {
    }

    public Command createCommand(Player p) {
        return null;
    }
}