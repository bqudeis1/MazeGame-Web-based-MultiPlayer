package baha;
// this class resposible for create the maze
public class MazeGame {
  public Maze CreateMaze() {
    // maze creation goes here, use builder of factory method.
    return null;
  }

  //factory methods.
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

//class
