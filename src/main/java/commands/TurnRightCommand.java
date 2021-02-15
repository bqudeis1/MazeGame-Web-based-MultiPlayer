package commands;

import player.Player;

public class TurnRightCommand implements Command<String> {
  Player player;

  public TurnRightCommand(Player player) {
    this.player = player;
  }

  @Override
  public String execute() {
    return player.turnRight();
  }
}
