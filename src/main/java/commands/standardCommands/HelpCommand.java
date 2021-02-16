package commands.standardCommands;

import baha.Room;
import commands.Command;
import player.Player;

public class HelpCommand implements Command<String,String> {
    Player player;

    public HelpCommand(Player p) {
        this.player = p;
    }

    @Override
    public String execute(String...input) {
        String commandsSet = "turnRightCommand\n";
        commandsSet += "turnLeftCommand\n";
        commandsSet += "backwardCommand\n";
        commandsSet += "forwardCommand\n";
        commandsSet += "playerStatusCommand\n";
        return commandsSet;
    }
}
