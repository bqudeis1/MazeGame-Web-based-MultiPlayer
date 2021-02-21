package json;

import mapCreator.Maze;
import baha.Room;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class Json1 {
  //TODO write game to json file to save the game .
  //TODO read a game from json file to start new game .

  public static String jsonStringGen(Maze maze) throws JsonProcessingException {

    final ObjectMapper mapper = new ObjectMapper();
    File theMapFile = new File("maze.json");
    String jsonString="";
    jsonString=mapper.writeValueAsString(maze.getRoomList());
    try{
      mapper.writeValue(theMapFile, maze.getRoomList().toArray());
    }catch (Exception e){

    }
    return jsonString;
  }

  public static void jsonReader() throws IOException {

    final ObjectMapper mapper = new ObjectMapper();
    Room[] rooms=mapper.readValue(new File("maze.json"), Room[].class);
    System.out.println(mapper.writeValueAsString(rooms));


  }

}
