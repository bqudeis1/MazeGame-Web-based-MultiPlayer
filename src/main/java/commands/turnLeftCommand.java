package commands;

import player.Player;

public class turnLeftCommand implements Command {
  Player player;

  public turnLeftCommand(Player player) {
    this.player = player;
  }

  @Override
  public String execute() {
    return player.turnLeft();
  }
}
