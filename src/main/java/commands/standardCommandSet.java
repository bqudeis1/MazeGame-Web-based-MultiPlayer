package commands;

import commands.state_pattern.CommandState;
import player.Player;

public enum standardCommandSet implements CommandsSet {
  turnLeftCommand("turnLeftCommand") {
    @Override
    public Command createCommand(Player p) {
      return new TurnLeftCommand(p);
    }
  },
  turnRightCommand("turnRightCommand") {
    @Override
    public Command createCommand(Player p) {
      return new TurnRightCommand(p);
    }
  },
  helpCommand("helpCommand") {
    public Command createCommand(Player p) {
      return new TurnRightCommand(p);
    }
  },
  wrongCommand("wrongCommand") {
    public Command createCommand(Player p) {
      return new TurnRightCommand(p);
    }
  },
  forwardCommand("forwardCommand") {
    public Command createCommand(Player p) {
      return new ForwardCommand(p);
    }
  },
  backwardCommand("backwardCommand") {
    public Command createCommand(Player p) {
      return new BackwardCommand(p);
    }
  },
  playerStatus("playerStatusCommand") {
    public Command createCommand(Player p) {
      return new TurnRightCommand(p);
    }
  };


  standardCommandSet(String turnLeftCommand) {}

  public Command createCommand(Player p) {
    return null;
  }
}
