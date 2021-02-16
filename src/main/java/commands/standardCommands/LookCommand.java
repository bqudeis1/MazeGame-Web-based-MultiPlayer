package commands.standardCommands;

import commands.Command;
import player.Player;

public class LookCommand implements Command<String,String> {
    Player p;

    public LookCommand(Player p) {
        this.p = p;
    }

    @Override
    public String execute(String... input) {
        return p.look();
    }
}
