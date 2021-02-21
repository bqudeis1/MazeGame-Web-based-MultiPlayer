package commands.standardCommands;

import baha.component.Door;
import baha.MapSite;
import commands.Command;
import player.Player;

public class CloseCommand implements Command<String,String> {
    Player p;
    public CloseCommand(Player p) {
        this.p=p;
    }

    @Override
    public String execute(String... input) {
        MapSite mapSite= p.getFacingObject();
        if(mapSite instanceof Door){
            Door d= (Door) mapSite;
            return d.close();
        }
        return "No Door";
    }
}
