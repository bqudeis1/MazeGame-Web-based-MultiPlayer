package commands;

import baha.Room;
import player.Player;

public class ForwardCommand implements Command<String> {
  Player player;
  Room room;

  public ForwardCommand(Player p) {
    this.player = p;
  }

  @Override
  public String execute() {
    return player.forward();
  }
}
