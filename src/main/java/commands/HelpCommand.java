package commands;

import baha.Room;
import player.Player;

public class HelpCommand implements Command <String>{
    Player player;

    public HelpCommand(Player p) {
        this.player = p;
    }

    @Override
    public String execute() {
        String commandsSet = "turnRightCommand\n";
        commandsSet += "turnLeftCommand\n";
        commandsSet += "backwardCommand\n";
        commandsSet += "forwardCommand\n";
        commandsSet += "playerStatusCommand\n";
        return commandsSet;
    }
}
