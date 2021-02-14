package commands;

import player.Player;

public class wrongCommand implements Command{
    Player player;

    public wrongCommand(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        return "";
    }
}
