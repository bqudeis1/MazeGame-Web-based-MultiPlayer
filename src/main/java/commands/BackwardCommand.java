package commands;

import baha.Room;
import player.Player;

public class BackwardCommand implements Command<String> {
  Player player;

  public BackwardCommand(Player p) {
    this.player = p;
  }

  @Override
  public String execute() {
    return player.backward();
  }
}
