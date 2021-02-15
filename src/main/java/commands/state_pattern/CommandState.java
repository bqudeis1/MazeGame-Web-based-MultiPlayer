package commands.state_pattern;

import commands.CommandsSet;
import commands.standardCommandSet;

public interface CommandState {
    public String processCommand(String commandName);
    public void fillPlayerCommands(Class< ? extends CommandsSet > s);
}
