package commands;

import player.Player;

public class TurnLeftCommand implements Command<String> {
  Player player;

  public TurnLeftCommand(Player player) {
    this.player = player;
  }

  @Override
  public String execute() {
    return player.turnLeft();
  }
}
