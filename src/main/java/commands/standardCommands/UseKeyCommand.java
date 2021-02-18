package commands.standardCommands;

import baha.MapSite;
import commands.Command;
import items.Key;
import lockable.Lockable;
import player.Player;

public class UseKeyCommand implements Command<String, String> {
    Player player;

    public UseKeyCommand(Player player) {
        this.player = player;
    }

    @Override
    public String execute(String[] input) {
        MapSite objectOppositePlayer = player.getFacingObject();
        if (objectOppositePlayer instanceof Lockable) {
            Lockable lockable = (Lockable) objectOppositePlayer;
            String keyName = lockable.getLockKeyName();
            if (player.playerHave(keyName)) {
                Key openingKey = (Key) player.get(keyName);
                ((Lockable) lockable).unlock(openingKey);
                return "Door is unlocked now.";
            }
            return "You don't have "+keyName+" key.";
        }
        return "you can't unlock "+objectOppositePlayer.getClass().getSimpleName();
    }
}
