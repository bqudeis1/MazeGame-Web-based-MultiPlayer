package json;

import baha.Maze;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class Json1 {
  public static String jsonStringGen(Maze maze) throws JsonProcessingException {
    Gson gson = new Gson();

    // String JsonString=gson.toJson(maze.getRoomSet().get(1));

    String x = new ObjectMapper().writeValueAsString(maze.getRoomList().get(1));

    return x;
  }
}
