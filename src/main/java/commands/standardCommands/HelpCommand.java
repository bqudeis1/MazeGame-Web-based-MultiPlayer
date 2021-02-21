package commands.standardCommands;

import commands.Command;
import player.Player;

public class HelpCommand implements Command<String, String> {
    Player player;

    public HelpCommand(Player p) {
        this.player = p;
    }

    @Override
    public String execute(String... input) {
        String commandsSet = "turnLeft\n";
        commandsSet += "turnRight\n";
        commandsSet += "backward\n";
        commandsSet += "forward\n";
        commandsSet += "playerStatus\n";
        commandsSet += "look\n";
        commandsSet += "check\n";
        commandsSet += "open\n";
        commandsSet += "close\n";
        commandsSet += "useKey\n";
        commandsSet += "useFlashLight\n";
        commandsSet += "switchLight\n";
        commandsSet += "time left\n";
        commandsSet += "help\n";
        commandsSet += "quitGame\n";

        return commandsSet;
    }
}
