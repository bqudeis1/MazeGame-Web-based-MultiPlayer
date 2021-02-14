package commands;

import baha.Room;
import player.Player;

public class helpCommand implements Command {
    Player player;
    Room room;

    public helpCommand(Player p) {
        this.player = p;
    }

  @Override
  public String execute() {
    String commandsSet="turnRightCommand\n";
    commandsSet+="turnLeftCommand\n";
    commandsSet+="backwardCommand\n";
    commandsSet+="forwardCommand\n";
    commandsSet+="playerStatusCommand\n";
    return commandsSet;
        }
}
