package commands.standardCommands;

import commands.Command;
import items.FlashLight;
import player.Player;

public class UseFlashLightCommand implements Command {
    Player player;

    public UseFlashLightCommand(Player p) {
        this.player = p;
    }

    @Override
    public String execute(Object[] input) {
        if(player.playerHave("FlashLight")){
        FlashLight flashLight= (FlashLight) player.get("FlashLight");
        flashLight.setStatus(true);
        }
        return null;
    }
}
