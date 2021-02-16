package commands;

import player.Player;

//Marker Interface.
public interface CommandsSet <R,I>{
    public Command<R,I> createCommand(Player player);

}
