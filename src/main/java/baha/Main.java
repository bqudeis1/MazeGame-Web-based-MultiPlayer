package baha;

import com.fasterxml.jackson.core.JsonProcessingException;
import timer.RunnableTimer;

public class Main {

  private static Object Room;

  public static void main(String[] args) throws JsonProcessingException {
    // write your code here
    // standardPlayerCommand.processCommand("forwardCommand");
    // standardPlayerCommand.processCommand("backwardCommand");
    new Thread(new RunnableTimer()).start();
  }
}
