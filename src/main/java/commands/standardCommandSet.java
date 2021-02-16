package commands;

import commands.standardCommands.*;
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
      return new HelpCommand(p);
    }//add this command
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
  playerStatus("playerStatusCommand") {//that mean the player cant see his status while he is in trade mod?!!
    public Command createCommand(Player p) {
      return new PlayerStatusCommand(p);
    }
  },
  look("lookCommand") {
    public Command createCommand(Player p) {
      return new LookCommand(p);
    }
  },
  check("checkCommand") {
    public Command createCommand(Player p) {
      return new CheckCommand(p);
    }
  },
  open("openCommand") {
    public Command createCommand(Player p) {
      return new OpenCommand(p);
    }
  },
  close("closeCommand") {
    public Command createCommand(Player p) {
      return new CloseCommand(p);
    }
  };


  standardCommandSet(String commandName) {}

  public Command createCommand(Player p) {
    return null;
  }
}
