package commands;

import baha.GamesPool;
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
  },
  useKeyCommand("useKeyCommand") {
    public Command createCommand(Player p) {
      return new UseKeyCommand(p);
    }
  },
  useFlashLight("UseFlashLightCommand") {
    public Command createCommand(Player p) {
      return new UseFlashLightCommand(p);
    }
  },
  switchLight("switchLightCommand") {
    public Command createCommand(Player p) {
      return new SwitchLightCommand(p);
    }
  },
  quitGame ("quitGame") {
    public Command createCommand(Player p) {
      return new QuitGameCommand(new GamesPool());
    }
  };


  standardCommandSet(String commandName) {}

  public Command createCommand(Player p) {
    return null;
  }
}
