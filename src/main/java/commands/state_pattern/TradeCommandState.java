package commands.state_pattern;

import commands.Command;
import commands.CommandsSet;
import commands.standardCommandSet;
import commands.tradeCommandSet;

import java.util.HashMap;

public class TradeCommandState implements CommandState {
    CommandExecutor commandExecutor;
    private final HashMap<String, Command> commands = new HashMap<String, Command>();

    public TradeCommandState(CommandExecutor commandExecutor){
        this.commandExecutor=commandExecutor;
        fillPlayerCommands(tradeCommandSet.class);
    }
    public void fillPlayerCommands(Class< ? extends CommandsSet> s)  {
        //TODO refactor to accept any class.
        standardCommandSet[] c = standardCommandSet.values();
        //EnumSet.allOf(s).forEach(m->commands.put(m.name(),m.createCommand(player)));
        for (standardCommandSet SCT : c) {
            commands.put(SCT.name(), SCT.createCommand(commandExecutor.getPlayer()));
        }
    }
    @Override
    public String processCommand(String commandName) {
        if(commandName.equals("FinishTrade")){
            commandExecutor.setState(commandExecutor.getStandardCommandsState());
        }
        return (String) commands.get(commandName).execute();
    }
}

