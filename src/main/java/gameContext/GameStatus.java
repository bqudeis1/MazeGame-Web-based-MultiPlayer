package gameContext;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public enum GameStatus implements Observable {
  GameStatusInstance;
  boolean isGameFinished = false;

  public boolean isGameFinished() {
    return isGameFinished;
  }

  public synchronized void setGameFinished(boolean gameFinished) {
    this.isGameFinished = gameFinished;
  }

  @Override
  public void addListener(InvalidationListener listener) {}

  @Override
  public void removeListener(InvalidationListener listener) {}
}
// object player1{
   // R//oom currentRoom;

    // move(){
        // door
        // if room has player fight
        // if not currentRoom =maze.getRoom
        // }
// }
// object player2{
//        Room currentRoom;
//        }
