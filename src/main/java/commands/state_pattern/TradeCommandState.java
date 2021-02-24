package commands.state_pattern;

import baha.MapSite;
import baha.component.Seller;
import commands.Command;
import commands.CommandsSet;
import commands.standardCommandSet;
import commands.tradeCommandSet;

import java.util.HashMap;

public class TradeCommandState implements CommandState {
    CommandExecutor commandExecutor;
    private final HashMap<String, Command> commands = new HashMap<String, Command>();

    public TradeCommandState(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
        fillPlayerCommands(tradeCommandSet.class);
    }

    public void fillPlayerCommands(Class<? extends CommandsSet> s) {
        //TODO: refactor to accept any class.
        tradeCommandSet[] c = tradeCommandSet.values();
        //EnumSet.allOf(s).forEach(m->commands.put(m.name(),m.createCommand(player)));
        for (tradeCommandSet SCT : c) {
            commands.put(SCT.name(), SCT.createCommand(commandExecutor.getPlayer()));
        }
    }

    @Override
    public String processCommand(String commandName) {
        if (commandName.equals("FinishTrade")) {
            MapSite facingObject = commandExecutor.getPlayer().getFacingObject();
            if (facingObject instanceof Seller) {
                commandExecutor.setState(commandExecutor.getStandardCommandsState());
                return "you left trade mode.";
            } else {
                return "You are not in trade mode";
            }
        }
        String commandInput = "";
        if (commandName.contains(" ")) {
            int i=commandName.indexOf(" ");
            commandInput=commandName.substring(i+1);
            commandName=commandName.substring(0,i);
        }
        Command<String, String> command = commands.get(commandName);
        String result = String.valueOf(command.execute(commandInput));
        return result;
    }
}

