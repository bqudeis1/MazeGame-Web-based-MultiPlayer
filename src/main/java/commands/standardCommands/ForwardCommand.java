package commands.standardCommands;

import baha.component.Room;
import commands.Command;
import player.Player;

public class ForwardCommand implements Command<String,String> {
  Player player;
  Room room;

  public ForwardCommand(Player p) {
    this.player = p;
  }

  @Override
  public String execute(String... input) {
    return player.forward();
  }
}
