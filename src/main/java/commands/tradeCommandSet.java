package commands;

import commands.tradeCommands.BuyCommand;
import commands.tradeCommands.ListCommand;
import commands.tradeCommands.SellCommand;
import player.Player;

public enum tradeCommandSet implements CommandsSet {
    sellCommand("sell") {
        @Override
        public Command createCommand(Player p) { return new SellCommand(p); }
    },buyCommand("buy") {
        @Override
        public Command createCommand(Player p) { return new BuyCommand(p); }
    },listCommand("List") {
        @Override
        public Command createCommand(Player p) { return new ListCommand(p); }
    };

    tradeCommandSet(String commandName) {
    }

    public Command createCommand(Player p) {
        return null;
    }
}