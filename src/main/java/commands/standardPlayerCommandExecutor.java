package commands;

import player.Player;

import java.util.EnumSet;
import java.util.HashMap;

public class standardPlayerCommandExecutor {
  private final Player player;
  private final HashMap<String, Command> commands = new HashMap<String, Command>();

  public standardPlayerCommandExecutor(Player p) {
    player = p;
    fillPlayerCommands(standardCommandSet.class);
  }

  public void processCommand(String commandName) {
    commands.get(commandName).execute();
  }

  private void fillPlayerCommands(Class<standardCommandSet> s) {
    standardCommandSet[] c = standardCommandSet.values();
    //EnumSet.allOf(s).forEach(m->commands.put(m.name(),m.createCommand(player)));
    for (standardCommandSet SCT : c) {
      commands.put(SCT.name(), SCT.createCommand(player));
    }
  }
}
