package commands;

import baha.GamesPool;
import commands.standardCommands.*;
import player.Player;

public enum standardCommandSet implements CommandsSet {
    turnLeft("turnLeft") {
        @Override
        public Command<String, String> createCommand(Player p) {
            return new TurnLeftCommand(p);
        }
    },
    turnRight("turnRight") {
        @Override
        public Command createCommand(Player p) {
            return new TurnRightCommand(p);
        }
    },
    forward("forward") {
        public Command createCommand(Player p) {
            return new ForwardCommand(p);
        }
    },
    backward("backward") {
        public Command createCommand(Player p) {
            return new BackwardCommand(p);
        }
    },
    playerStatus("playerStatus") {//that mean the player cant see his status while he is in trade mod?!!

        public Command createCommand(Player p) {
            return new PlayerStatusCommand(p);
        }
    },
    look("look") {
        public Command createCommand(Player p) {
            return new LookCommand(p);
        }
    },
    check("check") {
        public Command createCommand(Player p) {
            return new CheckCommand(p);
        }
    },
    open("open") {
        public Command createCommand(Player p) {
            return new OpenCommand(p);
        }
    },
    close("close") {
        public Command createCommand(Player p) {
            return new CloseCommand(p);
        }
    },
    useKey("useKey") {
        public Command createCommand(Player p) {
            return new UseKeyCommand(p);
        }
    },
    useFlashLight("useFlashLight") {
        public Command createCommand(Player p) {
            return new UseFlashLightCommand(p);
        }
    },
    switchLight("switchLight") {
        public Command createCommand(Player p) {
            return new SwitchLightCommand(p);
        }
    },
    help("help") {
        public Command<String, String> createCommand(Player p) {
            return new HelpCommand(p);
        }//add this command
    },
    quitGame("quitGame") {
        public Command createCommand(Player p) {
            return new QuitGameCommand(new GamesPool());
        }
    };


    standardCommandSet(String commandName) {
    }

    public Command createCommand(Player p) {
        return null;
    }
}
