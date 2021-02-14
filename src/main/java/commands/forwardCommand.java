package commands;

import baha.Room;
import player.Player;

public class forwardCommand implements Command {
  Player player;
  Room room;

  public forwardCommand(Player p) {
    this.player = p;
  }

  @Override
  public String execute() {
    return player.forward();
  }
}
