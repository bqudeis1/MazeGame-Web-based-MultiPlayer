package commands.state_pattern;

import commands.Command;
import commands.standardCommandSet;
import commands.state_pattern.CommandState;
import commands.state_pattern.StandardCommandState;
import player.Player;

import java.util.HashMap;

public class CommandExecutor {
    private final Player player;
    private final CommandState standardCommandsState = new StandardCommandState(this);
    private final CommandState TradeCommandsState = new TradeCommandState(this);
    private CommandState currentCommandsState;

    public CommandState getTradeCommandsState() {
        return TradeCommandsState;
    }

    public Player getPlayer() {
        return player;
    }

    public CommandExecutor(Player p) {
        player = p;
    }

    public String processCommand(String commandName) {
        return (String) currentCommandsState.processCommand(commandName);
    }

    protected void setState(CommandState commandState) {
        currentCommandsState = commandState;
    }

    protected CommandState getStandardCommandsState() {
        return standardCommandsState;
    }
}
