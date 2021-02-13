package commands;

import player.Player;

enum standardCommandSet implements CommandsSet {
  turnLeftCommand("turnLeftCommand") {
    public Command createCommand(Player p) {
      return new turnLeftCommand(p);
    }
  },
  turnRightCommand("turnRightCommand") {
    public Command createCommand(Player p) {
      return new turnRightCommand(p);
    }
  },
  helpCommand("helpCommand") {
    public Command createCommand(Player p) {
      return new turnRightCommand(p);
    }
  },
  wrongCommand("wrongCommand") {
    public Command createCommand(Player p) {
      return new turnRightCommand(p);
    }
  },
  forwardCommand("forwardCommand") {
    public Command createCommand(Player p) {
      return new forwardCommand(p);
    }
  },
  backwardCommand("backwardCommand") {
    public Command createCommand(Player p) {
      return new backwardCommand(p);
    }
  },
  playerStatus("playerStatusCommand") {
    public Command createCommand(Player p) {
      return new turnRightCommand(p);
    }
  };


  standardCommandSet(String turnLeftCommand) {}

  public Command createCommand(Player p) {
    return null;
  }
}
