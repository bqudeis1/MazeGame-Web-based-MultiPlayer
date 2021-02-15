package commands.state_pattern;

import commands.Command;
import commands.CommandsSet;
import commands.standardCommandSet;

import java.util.HashMap;

public class TradeCommandState<T> implements CommandState {
    CommandExecutor<T> commandExecutor;
    private final HashMap<String, Command<T>> commands = new HashMap<String, Command<T>>();

    public TradeCommandState(CommandExecutor<T> commandExecutor){
        this.commandExecutor=commandExecutor;
        fillPlayerCommands(standardCommandSet.class);
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
        if(commandName.equals("QuiteTrade")){
            commandExecutor.setState(commandExecutor.getStandardCommandsState());
        }
        return null;
    }
}

