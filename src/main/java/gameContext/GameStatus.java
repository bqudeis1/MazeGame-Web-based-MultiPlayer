package gameContext;

import timer.GameTimer;

import java.util.Observable;
import java.util.Observer;

public class GameStatus implements Observer {
    private GameTimer gameTimerObservable;
    private long gameStartingTime;
    private long waitingTime = 60;
    private long gameDuration = 20*60;//in sec

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

    boolean isGameStart;
    boolean isGameInWaitingMod;
    private boolean isGameFinished;
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
        long temp = gameTimerObservable.getTime() - gameStartingTime;
        if (temp >= waitingTime) {
            isGameStart = true;
            isGameInWaitingMod = false;
        }
        if (temp >= gameDuration) {
            isGameFinished = true;
            gameTimerObservable.deleteObserver(this);
        }
    }
}
