package baha;

import java.util.HashMap;

public class GamesPool {
  private final HashMap<Integer, Maze> mazGames = new HashMap<>();

  public void addGame(Maze maze) {
    mazGames.put(maze.getGameId(), maze);
  }

  public Maze getMazeGame(int mazeId) { // check if mazeid odes not exixst and handl the that.
    return mazGames.get(mazeId);
  }

  public synchronized Maze getNotFullGame(){
    //mazGames.entrySet().
return null;
  }
}
