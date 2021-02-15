package commands;

import player.Player;

public class WrongCommand implements Command<String> {
    Player player;

    public WrongCommand(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        return "";
    }
}
