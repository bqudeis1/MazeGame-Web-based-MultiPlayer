package gameContext;

import timer.GameTimer;

import java.util.Observable;
import java.util.Observer;

public class GameStatus implements Observer {
    private transient GameTimer gameTimerObservable;
    private transient long gameStartingTime;
    private long waitingTime = 3;//rewrite it to 60 sec.
    private long gameDuration = 60*60;//in sec
    boolean isGameStart;
    boolean isGameInWaitingMod;
    private boolean isGameFinished;

    public void setGameResult(String gameResult) {
        GameResult = gameResult;
    }

    private String GameResult;

    public long getWaitingTime() {
        return waitingTime;
    }


    public boolean isGameStart() {
        return isGameStart;
    }

    public void setGameStart(boolean gameStart) {
        isGameStart = gameStart;
    }

    public boolean isGameInWaitingMod() {
        return isGameInWaitingMod;
    }

    public void setGameInWaitingMod(boolean gameInWaitingMod) {
        isGameInWaitingMod = gameInWaitingMod;
    }

    public void setGameFinished(boolean gameFinished) {
        isGameFinished = gameFinished;
    }


    public GameStatus(Observable observable) {
        this.gameTimerObservable = (GameTimer) observable;
        observable.addObserver(this);
        gameStartingTime = GameTimer.getInstance().getTime();
        isGameInWaitingMod = true;
    }

    public boolean isGameFinished() {
        return isGameFinished;
    }


    @Override
    public void update(Observable o, Object arg) {
        if (waitingTime > 0) {
            waitingTime--;
            if (waitingTime == 0) {
                setGameInWaitingMod(false);
                setGameStart(true);
            }
        }
        if (isGameStart && gameDuration != 0) {
            gameDuration--;
            if (gameDuration == 0) {
                setGameFinished(true);
                o.deleteObserver(this);
                GameResult = "Time Over No Winner";
            }
        }
    }
}
