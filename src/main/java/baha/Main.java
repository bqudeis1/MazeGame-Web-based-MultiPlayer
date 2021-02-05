package baha;

import com.fasterxml.jackson.core.JsonProcessingException;
import commands.standardPlayerCommandExecutor;
import json.Json1;
import player.Player;

public class Main {

  private static Object Room;

  public static void main(String[] args) throws JsonProcessingException {
    // write your code here
    Maze maze = new MazeGame().CreateMaze();
    System.out.println(Json1.jsonStringGen(maze));
    standardPlayerCommandExecutor standardPlayerCommand =
        new standardPlayerCommandExecutor(new Player());
    standardPlayerCommand.processCommand("turnLeftCommand");
    standardPlayerCommand.processCommand("turnRightCommand");
    standardPlayerCommand.processCommand("forwardCommand");
    standardPlayerCommand.processCommand("backwardCommand");
  }
}
