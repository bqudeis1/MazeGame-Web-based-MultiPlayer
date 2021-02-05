package baha;
// this class responsible for create the maze
public class MazeGame {
  public Maze CreateMaze() {
    // maze creation goes here, use builder of factory method.
    MazeGame mazeGame = new MazeGame();
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

    return m;
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
}

// class
