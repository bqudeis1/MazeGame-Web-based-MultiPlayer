package timer;

import gameContext.GameStatus;

public class RunnableTimer implements Runnable {
  private final GameTimer time;
  private boolean isTimeOut = false;

  public RunnableTimer(GameTimer time) {
    this.time = time;
  }

  @Override
  public void run() {
    while (!isTimeOut) {
      try {
        Thread.sleep(1000);
        time.setTime(time.getTime() - 1);
        isTimeOut = GameStatus.GameStatusInstance.isGameFinished();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
