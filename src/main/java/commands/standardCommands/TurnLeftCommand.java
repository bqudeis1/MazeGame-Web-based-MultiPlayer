package commands.standardCommands;

import commands.Command;
import player.Player;

public class TurnLeftCommand implements Command<String,String> {
  Player player;

  public TurnLeftCommand(Player player) {
    this.player = player;
  }

  @Override
  public String execute(String... input) {
    return player.turnLeft();
  }
}
