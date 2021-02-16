package commands.standardCommands;

import commands.Command;
import player.Player;

public class CheckCommand implements Command<String,String> {
    Player p;

    public CheckCommand(Player p) {
        this.p = p;
    }

    @Override
    public String execute(String... Input) {
        return p.check();
    }
}
