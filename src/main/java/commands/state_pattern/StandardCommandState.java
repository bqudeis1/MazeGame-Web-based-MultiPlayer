package commands.state_pattern;

import baha.MapSite;
import baha.Seller;
import commands.Command;
import commands.CommandsSet;
import commands.standardCommandSet;

import java.util.HashMap;

class StandardCommandState implements CommandState {
    CommandExecutor commandExecutor;
    private final HashMap<String, Command> commands = new HashMap<String, Command>();

    public StandardCommandState(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
        fillPlayerCommands(standardCommandSet.class);
    }

    public void fillPlayerCommands(Class<? extends CommandsSet> s) {
        //TODO refactor to accept any class.
        standardCommandSet[] c = standardCommandSet.values();
        //EnumSet.allOf(s).forEach(m->commands.put(m.name(),m.createCommand(player)));
        for (standardCommandSet SCT : c) {
            commands.put(SCT.name(), SCT.createCommand(commandExecutor.getPlayer()));
        }
    }

    @Override
    public String processCommand(String commandName) {
        if (commandName.equals("Trade")) {
            MapSite facingObject = commandExecutor.getPlayer().getFacingObject();
            if (facingObject instanceof Seller) {
                commandExecutor.setState(commandExecutor.getTradeCommandsState());
                return "you start trade.";
            }
        }else
        return "There is no Trader opposite you";
        return (String) commands.get("commandName").execute();
    }
}
