package json;

import baha.Maze;
import baha.Room;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWithSerializerProvider;
import com.google.gson.Gson;
import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;

import javax.ws.rs.ext.ExceptionMapper;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Json1 {
  //TODO write game to json file to save the game .
  //TODO read a game from json file to start new game .

  public static String jsonStringGen(Maze maze) throws JsonProcessingException {

    final ObjectMapper mapper = new ObjectMapper();
    File theMapFile = new File("maze.json");
    try{
      mapper.writeValue(theMapFile, maze.getRoomList().toArray());
    }catch (Exception e){

    }
    return mapper.writeValueAsString(maze.getRoomList());
  }

  public static void jsonReader() throws IOException {

    final ObjectMapper mapper = new ObjectMapper();
    Room[] rooms=mapper.readValue(new File("maze.json"), Room[].class);
    System.out.println(mapper.writeValueAsString(rooms));


  }

}
