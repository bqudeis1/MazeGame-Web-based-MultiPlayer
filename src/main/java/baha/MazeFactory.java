package baha;


import baha.component.*;
import items.Key;
import mapCreator.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// this class responsible for create the maze
public class MazeFactory {
  public Maze CreateMaze() {
    // maze creation goes here, use builder of factory method.
    MazeFactory mazeGame = new MazeFactory();
    Room r1 = mazeGame.MakeRoom(1);
    Room r2 = mazeGame.MakeRoom(2);
    Room r3 = mazeGame.MakeRoom(3);
    Door d1 = mazeGame.MakeDoor(r1, r2);
    // 1) create rooms
    // 2) create doors
    // 3) set other sites
    // 4) link the doors with sides (e.g. r1.setMapSites(d1,0);r2.setMapSites(d1,3);

    r1.setMapSites(mazeGame.MakeWall(), 1);
    r1.setMapSites(mazeGame.MakePainting(), 2);
    r1.setMapSites(mazeGame.MakeSeller(), 3);
    r2.setMapSites(mazeGame.MakeWall(), 0);
    r2.setMapSites(mazeGame.MakeSeller(), 1);
    r2.setMapSites(mazeGame.MakePainting(), 2);
    r1.setMapSites(d1, 0);
    r2.setMapSites(d1, 3);
    r3.setMapSites(mazeGame.MakeWall(), 0);
    r3.setMapSites(mazeGame.MakeSeller(), 1);
    r3.setMapSites(mazeGame.MakePainting(), 2);
    r3.setMapSites(mazeGame.MakeChest(), 3);

    Maze m = new Maze();
    m.addRoom(r1);
    m.addRoom(r2);
    m.addRoom(r3);
    m.addStartingRoom(r1);
    m.addStartingRoom(r3);

//starting rooms 0,20,23,1

    return m;
  }

  public Maze CreateMap1Maze() {
    final int mazeSize = 50;
    MazeFactory mazeGame = new MazeFactory();
    Maze map1=new Maze();
    // create the maze rooms
    List<Room> rooms = new ArrayList<Room>();
    for (int i = 0; i < mazeSize; i++) {
      rooms.add(mazeGame.MakeRoom(i));
      map1.addRoom(rooms.get(i));
    }
    HashMap<String, Key> keys=new HashMap<>();
    Map1ItemsCreator.createItems(keys);
    //set rooms properties


    // win rooms 5,6,12,19
    Room.winningRoomsIds.add(5);
    Room.winningRoomsIds.add(6);
    Room.winningRoomsIds.add(12);
    Room.winningRoomsIds.add(19);
    // start rooms 0,1,10,23
    map1.addStartingRoom(rooms.get(10));
   // map1.addStartingRoom(rooms.get(1));
   // map1.addStartingRoom(rooms.get(20));
  //  map1.addStartingRoom(rooms.get(23));


    // set the maze walls
    Map1WallsCreator.createMap1Walls(rooms,mazeGame);
    // create the maze doors and link the rooms using doors you created
    Map1DoorsCreator.createMap1Doors(rooms,mazeGame,keys);
    //create paintings
    Map1PaintingsCreator.createMap1Paintings(rooms,mazeGame,keys);
    //create mirrors
    Map1MirrorsCreator.createMap1Mirrors(rooms,mazeGame,keys);
    //create chests
    Map1ChestsCreator.createMap1Chests(rooms,mazeGame,keys);
    //create sellers
    Map1SellersCreator.createMap1Sellers(rooms,mazeGame,keys);
    //create grounds
    Map1GroundCreator.createMap1Grounds(rooms,mazeGame);







//    //test for json
//    Maze myMaze = new Maze();
//    Room walls=mazeGame.MakeRoom(100);
//    Room paintings=mazeGame.MakeRoom(101);
//    Room chests=mazeGame.MakeRoom(102);
//    Room mirrors=mazeGame.MakeRoom(103);
//    Room sellers=mazeGame.MakeRoom(104);
//    Room doors=mazeGame.MakeRoom(105);
//
//    Wall walls0=mazeGame.MakeWall();
//    walls.setMapSites(walls0,0);
//    walls.setMapSites(walls0,1);
//    walls.setMapSites(walls0,2);
//    walls.setMapSites(walls0,3);
//    walls.setMapSites(walls0,4);
//
//    Painting p0=mazeGame.MakePainting();
//    Painting p1=mazeGame.MakePainting();
//    Painting p2=mazeGame.MakePainting();
//    Painting p3=mazeGame.MakePainting();
//    Painting p4=mazeGame.MakePainting();
//    Key keys0=new Key();
//    keys0.setName("dragon improper room key");
//    p0.addItem(keys0);
//    paintings.setMapSites(p0,0);
//    paintings.setMapSites(p1,1);
//    paintings.setMapSites(p2,2);
//    paintings.setMapSites(p3,3);
//    paintings.setMapSites(p4,4);
//
//    //Room mirrors=new Room();
//    Mirror m0=mazeGame.MakeMirror();
//    Mirror m1=mazeGame.MakeMirror();
//    Mirror m2=mazeGame.MakeMirror();
//    Mirror m3=mazeGame.MakeMirror();
//    Mirror m4=mazeGame.MakeMirror();
//    mirrors.setMapSites(m0,0);
//    mirrors.setMapSites(m1,1);
//    mirrors.setMapSites(m2,2);
//    mirrors.setMapSites(m3,3);
//    mirrors.setMapSites(m4,4);
//    m0.addItem(keys0);
//
//    //room of chests
//    Chest ch0=mazeGame.MakeChest();
//    Chest ch1=mazeGame.MakeChest();
//    Chest ch2=mazeGame.MakeChest();
//    Chest ch3=mazeGame.MakeChest();
//    Chest ch4=mazeGame.MakeChest();
//    chests.setMapSites(ch0,0);
//    chests.setMapSites(ch1,1);
//    chests.setMapSites(ch2,2);
//    chests.setMapSites(ch3,3);
//    chests.setMapSites(ch4,4);
//    ch0.addItem(keys0);
//
//    //myMaze.addRoom(chests);
//    myMaze.addRoom(mirrors);
//    //myMaze.addRoom(walls);
//    //myMaze.addRoom(paintings);




    return map1;
  }
  // factory methods.
  Maze MakeMaze() {
    return new Maze();
  }

  Room MakeRoom(int n) {
    return new Room(n);
  }

  public Wall MakeWall() {
    return new Wall();
  }

  public Door MakeDoor(Room rl, Room r2) {
    return new Door(rl, r2);
  }

  public Chest MakeChest() {
    return new Chest();
  }

  public Painting MakePainting() {
    return new Painting();
  }

  public Mirror MakeMirror() {
    return new Mirror();
  }

  public Seller MakeSeller() {
    return new Seller();
  }
  // factory methods ends here.

}

// class
