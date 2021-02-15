package commands;

import player.Player;

public class PlayerStatusCommand implements Command {
    Player player;

    public PlayerStatusCommand(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        return player.toString();
    }
}