package commands.state_pattern;

import commands.Command;
import commands.standardCommandSet;
import commands.state_pattern.CommandState;
import commands.state_pattern.StandardCommandState;
import player.Player;

import java.util.HashMap;

public class CommandExecutor {
    private final Player player;
    private final CommandState standardCommandsState;
    private final CommandState TradeCommandsState;
    private CommandState currentCommandsState;

    public CommandExecutor(Player p) {
        player = p;
        standardCommandsState = new StandardCommandState(this);
        TradeCommandsState = new TradeCommandState(this);
    }


    public CommandState getTradeCommandsState() {
        return TradeCommandsState;
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

    public Player getPlayer() {
        return player;
    }
}
