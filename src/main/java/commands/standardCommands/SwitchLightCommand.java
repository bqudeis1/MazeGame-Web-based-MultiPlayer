package commands.standardCommands;

import commands.Command;
import player.Player;

public class SwitchLightCommand implements Command {
    Player player;
    public SwitchLightCommand(Player p) {
        player=p;
    }

    @Override
    public String execute(Object[] input) {
        return player.switchLight();
    }
}
