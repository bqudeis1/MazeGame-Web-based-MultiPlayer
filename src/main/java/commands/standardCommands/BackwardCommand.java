package commands.standardCommands;

import baha.Room;
import commands.Command;
import player.Player;

public class BackwardCommand implements Command<String,String> {
  Player player;

  public BackwardCommand(Player p) {
    this.player = p;
  }

  @Override
  public String execute(String... input) {
    return player.backward();
  }
}
