package timer;

import gameContext.GameStatus;

//singleton
public class GameTimer {
  private long time;

  public GameTimer(long time) {
    this.time = time;
  }

  public long getTime() {
    return time;
  }

  public void setTime(long time) {
    this.time = time;
    if(time==0){
      GameStatus.GameStatusInstance.setGameFinished(true);
    }
  }

}
