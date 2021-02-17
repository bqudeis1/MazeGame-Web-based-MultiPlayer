package commands.standardCommands;

import commands.Command;
import player.Player;

public class quitGameCommand implements Command {
    Player player;
    public quitGameCommand(Player p) {
        player=p;
    }

    @Override
    public Object execute(Object[] input) {
        // delete player form game.
            //1-but items in floor class.
            //2-remove player cookies.
            //3-remove any observers on player or player item register.
            //4-share the money between players in the same Game.
        return null;
    }
}
