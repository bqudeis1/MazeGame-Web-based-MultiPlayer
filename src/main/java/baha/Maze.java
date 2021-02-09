package baha;

import java.util.ArrayList;
import java.util.List;

public class Maze implements Cloneable {

  public GameInfo getGameInfo() {
    return gameInfo;
  }

  private final GameInfo gameInfo;
  private final List<Room> roomSet = new ArrayList<Room>();

  public Maze() {
    synchronized (this){
      gameInfo=new GameInfo();
    }
  }

  public List<Room> getRoomSet() {
    return roomSet;
  }

  public void addRoom(Room r) {
    if (r != null) roomSet.add(r);
  }

  public Room returnRoom(int index) {
    return roomSet.get(index);
  }
  public int getGameId(){
    return gameInfo.mazeId;
  }

  public int getPlayersNumber() {
    return gameInfo.PlayersNumber;
  }


  private class GameInfo {
    private final int mazeId;



    private int PlayersNumber;
    //list of Players or PlayersId.
    public GameInfo(){
      mazeId=generateMazeId();
    }

    private synchronized int generateMazeId() {
      return 0 + (int) (Math.random() * ((100 - 0) + 1));
    }



  }

  // here u need to implement the hasCode method
}
