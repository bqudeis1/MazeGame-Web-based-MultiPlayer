package baha;

import baha.component.*;

import java.util.ArrayList;
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

    // create the maze rooms
    List<Room> rooms = new ArrayList<Room>();
    for (int i = 0; i < mazeSize; i++) {
      rooms.add(mazeGame.MakeRoom(i));
    }

    // win rooms 5,6,12,19
    // start rooms 0,1,10,23

    // set the maze walls
    Wall wall0 = mazeGame.MakeWall();
    rooms.get(0).setMapSites(wall0, 2);
    rooms.get(0).setMapSites(wall0, 1);
    rooms.get(3).setMapSites(wall0, 1);
    rooms.get(2).setMapSites(wall0, 3);
    rooms.get(2).setMapSites(wall0, 1);
    rooms.get(15).setMapSites(wall0, 2);
    rooms.get(10).setMapSites(wall0, 1);
    rooms.get(10).setMapSites(wall0, 3);
    rooms.get(16).setMapSites(wall0, 0);
    rooms.get(31).setMapSites(wall0, 0);
    rooms.get(31).setMapSites(wall0, 2);
    rooms.get(40).setMapSites(wall0, 2);
    rooms.get(25).setMapSites(wall0, 2);
    rooms.get(19).setMapSites(wall0, 0);
    rooms.get(19).setMapSites(wall0, 1);
    rooms.get(19).setMapSites(wall0, 3);
    rooms.get(20).setMapSites(wall0, 1);
    rooms.get(20).setMapSites(wall0, 3);
    rooms.get(9).setMapSites(wall0, 3);
    rooms.get(42).setMapSites(wall0, 2);
    rooms.get(46).setMapSites(wall0, 2);
    rooms.get(38).setMapSites(wall0, 0);
    rooms.get(38).setMapSites(wall0, 2);
    rooms.get(8).setMapSites(wall0, 2);
    rooms.get(24).setMapSites(wall0, 3);
    rooms.get(34).setMapSites(wall0, 2);
    rooms.get(34).setMapSites(wall0, 1);
    rooms.get(41).setMapSites(wall0, 3);
    rooms.get(5).setMapSites(wall0, 0);
    rooms.get(5).setMapSites(wall0, 1);
    rooms.get(5).setMapSites(wall0, 3);
    rooms.get(23).setMapSites(wall0, 1);
    rooms.get(23).setMapSites(wall0, 3);
    rooms.get(11).setMapSites(wall0, 0);
    rooms.get(43).setMapSites(wall0, 2);
    rooms.get(36).setMapSites(wall0, 2);
    rooms.get(18).setMapSites(wall0, 0);
    rooms.get(47).setMapSites(wall0, 1);
    rooms.get(47).setMapSites(wall0, 3);
    rooms.get(33).setMapSites(wall0, 3);
    rooms.get(6).setMapSites(wall0, 0);
    rooms.get(6).setMapSites(wall0, 1);
    rooms.get(6).setMapSites(wall0, 3);
    rooms.get(1).setMapSites(wall0, 1);
    rooms.get(1).setMapSites(wall0, 2);
    rooms.get(1).setMapSites(wall0, 3);
    rooms.get(17).setMapSites(wall0, 0);
    rooms.get(17).setMapSites(wall0, 2);
    rooms.get(22).setMapSites(wall0, 2);
    rooms.get(26).setMapSites(wall0, 1);
    rooms.get(26).setMapSites(wall0, 2);

    rooms.get(29).setMapSites(wall0, 1);
    rooms.get(29).setMapSites(wall0, 2);
    rooms.get(29).setMapSites(wall0, 3);
    rooms.get(35).setMapSites(wall0, 0);
    rooms.get(35).setMapSites(wall0, 2);
    rooms.get(37).setMapSites(wall0, 1);
    rooms.get(37).setMapSites(wall0, 3);
    rooms.get(12).setMapSites(wall0, 1);
    rooms.get(12).setMapSites(wall0, 2);
    rooms.get(12).setMapSites(wall0, 3);

    // create the maze doors and link the rooms using doors you created
    Door d0 = mazeGame.MakeDoor(rooms.get(0), rooms.get(3));
    Door d1 = mazeGame.MakeDoor(rooms.get(3), rooms.get(7));
    Door d2 = mazeGame.MakeDoor(rooms.get(7), rooms.get(2));
    Door d3 = mazeGame.MakeDoor(rooms.get(2), rooms.get(10));
    Door d4 = mazeGame.MakeDoor(rooms.get(7), rooms.get(15));
    Door d5 = mazeGame.MakeDoor(rooms.get(15), rooms.get(16));
    Door d6 = mazeGame.MakeDoor(rooms.get(16), rooms.get(31));
    Door d7 = mazeGame.MakeDoor(rooms.get(31), rooms.get(49));
    Door d8 = mazeGame.MakeDoor(rooms.get(49), rooms.get(40));
    Door d9 = mazeGame.MakeDoor(rooms.get(40), rooms.get(25));
    Door d10 = mazeGame.MakeDoor(rooms.get(25), rooms.get(19));
    Door d11 = mazeGame.MakeDoor(rooms.get(20), rooms.get(9));
    Door d12 = mazeGame.MakeDoor(rooms.get(9), rooms.get(24));
    Door d13 = mazeGame.MakeDoor(rooms.get(9), rooms.get(42));
    Door d14 = mazeGame.MakeDoor(rooms.get(42), rooms.get(45));
    Door d15 = mazeGame.MakeDoor(rooms.get(45), rooms.get(46));
    Door d16 = mazeGame.MakeDoor(rooms.get(46), rooms.get(38));
    Door d17 = mazeGame.MakeDoor(rooms.get(38), rooms.get(8));
    Door d18 = mazeGame.MakeDoor(rooms.get(8), rooms.get(41));
    Door d19 = mazeGame.MakeDoor(rooms.get(41), rooms.get(34));
    Door d20 = mazeGame.MakeDoor(rooms.get(41), rooms.get(5));
    Door d21 = mazeGame.MakeDoor(rooms.get(23), rooms.get(11));
    Door d22 = mazeGame.MakeDoor(rooms.get(11), rooms.get(43));
    Door d23 = mazeGame.MakeDoor(rooms.get(43), rooms.get(36));
    Door d24 = mazeGame.MakeDoor(rooms.get(36), rooms.get(18));
    Door d25 = mazeGame.MakeDoor(rooms.get(36), rooms.get(27));
    Door d26 = mazeGame.MakeDoor(rooms.get(27), rooms.get(28));
    Door d27 = mazeGame.MakeDoor(rooms.get(27), rooms.get(14));
    Door d28 = mazeGame.MakeDoor(rooms.get(14), rooms.get(47));
    Door d29 = mazeGame.MakeDoor(rooms.get(14), rooms.get(33));
    Door d30 = mazeGame.MakeDoor(rooms.get(33), rooms.get(6));
    Door d31 = mazeGame.MakeDoor(rooms.get(1), rooms.get(13));
    Door d32 = mazeGame.MakeDoor(rooms.get(13), rooms.get(17));
    Door d33 = mazeGame.MakeDoor(rooms.get(17), rooms.get(21));
    Door d34 = mazeGame.MakeDoor(rooms.get(21), rooms.get(22));
    Door d35 = mazeGame.MakeDoor(rooms.get(22), rooms.get(26));
    Door d36 = mazeGame.MakeDoor(rooms.get(21), rooms.get(35));
    Door d37 = mazeGame.MakeDoor(rooms.get(35), rooms.get(32));
    Door d38 = mazeGame.MakeDoor(rooms.get(32), rooms.get(37));
    Door d39 = mazeGame.MakeDoor(rooms.get(32), rooms.get(30));
    Door d40 = mazeGame.MakeDoor(rooms.get(30), rooms.get(29));
    Door d41 = mazeGame.MakeDoor(rooms.get(30), rooms.get(48));
    Door d42 = mazeGame.MakeDoor(rooms.get(48), rooms.get(12));
    Door d43 = mazeGame.MakeDoor(rooms.get(40), rooms.get(43));
    Door d44 = mazeGame.MakeDoor(rooms.get(33), rooms.get(44));




    // make keys
//    Item key0=new Key();
//    key0.setName("the demon king room key");
//    Item key1=new Key();
//    key1.setName("the human king room key");
//    Item key2=new Key();
//    key2.setName("the fairy queen room key");
//    Item key3=new Key();
//    key3.setName("the mermaid queen room key");
//    Item key4=new Key();
//    key4.setName("the jungle nymph room key");
//    Item key5=new Key();
//    key5.setName("the ghost whale room key");
//    Item key6=new Key();
//    key6.setName("the demon cat room key");
//    Item key7=new Key();
//    key7.setName("demon of wrath room key");
//    Item key8=new Key();
//    key8.setName("the prince of demons room key");
//    Item key9=new Key();
//    key9.setName("the sea dragon room key");
//    Item key10=new Key();
//    key10.setName("the ice demon room key");
//    Item key11=new Key();
//    key11.setName("the lightning fairy room key");
//    Item key12=new Key();
//    key12.setName("the orcs king room key");
//    Item key13=new Key();
//    key13.setName("the goblins king room key");
//    Item key14=new Key();
//    key14.setName("the slime room key");
//    Item key15=new Key();
//    key15.setName("the wargs king room key");
//    Item key16=new Key();
//    key16.setName("the trolls king room key");
//    Item key17=new Key();
//    key17.setName("the mumakil room key");
//    Item key18=new Key();
//    key18.setName("the eagles king key");
//    Item key19=new Key();
//    key19.setName("the gaints room key");
//    Item key20=new Key();
//    key20.setName("the wizards king room key");
//    Item key21=new Key();
//    key21.setName("the fire dragon room key");
//    Item key22=new Key();
//    key22.setName("the stray dogs room key");
//    Item key23=new Key();
//    key23.setName("the sage room key");


    //create paintings
    Painting painting0 =mazeGame.MakePainting();
    Painting painting1 =mazeGame.MakePainting();
    Painting painting2 =mazeGame.MakePainting();
    Painting painting3 =mazeGame.MakePainting();
    Painting painting4 =mazeGame.MakePainting();
    Painting painting5 =mazeGame.MakePainting();
    Painting painting6 =mazeGame.MakePainting();
    Painting painting7 =mazeGame.MakePainting();
    Painting painting8 =mazeGame.MakePainting();
    Painting painting9 =mazeGame.MakePainting();
    Painting painting10 =mazeGame.MakePainting();
    Painting painting11 =mazeGame.MakePainting();
    Painting painting12 =mazeGame.MakePainting();






















    rooms.get(0).setMapSites(d0, 0);
    rooms.get(3).setMapSites(d0, 3);

    Maze myMaze = new Maze();
    return myMaze;
  }
  // factory methods.
  Maze MakeMaze() {
    return new Maze();
  }

  Room MakeRoom(int n) {
    return new Room(n);
  }

  Wall MakeWall() {
    return new Wall();
  }

  Door MakeDoor(Room rl, Room r2) {
    return new Door(rl, r2);
  }

  Chest MakeChest() {
    return new Chest();
  }

  Painting MakePainting() {
    return new Painting();
  }

  Mirror MakeMirror() {
    return new Mirror();
  }

  Seller MakeSeller() {
    return new Seller();
  }
  // factory methods ends here.

}

// class
