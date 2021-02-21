package commands.tradeCommands;

import commands.Command;
import container.Container;
import player.Player;

public class ListCommand implements Command<String,String> {
    Player p;

    public ListCommand(Player p) {
        this.p = p;
    }

    @Override
    public String execute(String... input) {
        Container c=(Container)p.getFacingObject();
        return c.getItemsName();
    }
}
