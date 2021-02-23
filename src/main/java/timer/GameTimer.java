package timer;

import javax.jms.IllegalStateException;
import java.util.Observable;

// singleton
public class GameTimer extends Observable {
    private static GameTimer instance;
    private long time = 0;
    static {
        new Thread(new RunnableTimer()).start();
    }

    private GameTimer() {//throw exception here

    }

    public static synchronized GameTimer getInstance() {
        if (instance == null) {
            synchronized (GameTimer.class) {
                if (instance == null) {
                    instance = new GameTimer();
                }
            }
        }
        return instance;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
        setChanged();
        notifyObservers();

    }

    @Override
    public String toString() {
        return "time left -> "+time/(3600)+":"+(time%3600)/60+":"+(time%60);
    }
}
