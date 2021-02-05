package commands;

import baha.Room;
import player.Player;

public class backwardCommand implements Command {
  Player player;
  Room room;

  public backwardCommand(Player p) {
    this.player = p;
  }

  @Override
  public void execute() {
    player.backward();
  }
}
