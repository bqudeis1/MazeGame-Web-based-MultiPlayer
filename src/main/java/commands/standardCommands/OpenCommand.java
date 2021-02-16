package commands.standardCommands;

import baha.Door;
import baha.MapSite;
import commands.Command;
import player.Player;

public class OpenCommand implements Command<String,String> {
    Player p;

    public OpenCommand(Player p) {
        this.p = p;
    }


    @Override
    public String execute(String... input) {
        MapSite mapSite= p.getFacingObject();
        if(mapSite instanceof Door){
            Door d= (Door) mapSite;
            return d.open();
        }
        return "No Door";
    }
}
