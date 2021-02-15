package commands;

import player.Player;

//Marker Interface.
public interface CommandsSet <T>{
    public Command<T> createCommand(Player player);

}
