package commands.standardCommands;

import commands.Command;
import player.Player;

public class PlayerStatusCommand implements Command<String,String> {
    Player player;

    public PlayerStatusCommand(Player player) {
        this.player = player;
    }

    @Override
    public String execute(String... input) {
        return player.toString();
    }
}