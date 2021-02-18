package baha;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import json.Json1;

import java.io.IOException;

public class Main {

  private static Object Room;

  public static void main(String[] args) throws IOException {
    // write your code here
    // standardPlayerCommand.processCommand("forwardCommand");
    // standardPlayerCommand.processCommand("backwardCommand");

    //json test
    Maze maze=new Maze();
    MazeFactory mazeFactory=new MazeFactory();
    maze=mazeFactory.CreateMap1Maze();
    System.out.println(Json1.jsonStringGen(maze));
    Maze maze1=new Maze();
    Json1.jsonReader();


    //end of json test

  }
}
