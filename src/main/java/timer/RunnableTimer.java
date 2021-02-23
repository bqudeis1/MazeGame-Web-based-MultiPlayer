package timer;


public class RunnableTimer implements Runnable {
    private final GameTimer time = GameTimer.getInstance();

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                time.setTime(time.getTime() + 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
