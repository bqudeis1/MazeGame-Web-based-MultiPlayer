package commands.standardCommands;

import commands.Command;
import player.Player;

public class TurnRightCommand implements Command<String,String> {
  Player player;

  public TurnRightCommand(Player player) {
    this.player = player;
  }

  @Override
  public String execute(String... input) {
    return player.turnRight();
  }
}
