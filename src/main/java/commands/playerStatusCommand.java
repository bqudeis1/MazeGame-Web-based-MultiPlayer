package commands;

import player.Player;

public class playerStatusCommand implements Command {
    Player player;

    public playerStatusCommand(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        return player.toString();
    }
}