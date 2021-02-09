package baha;

public class Wall implements MapSite {

  public int id = 0;

  @Override
  public Object clone() throws CloneNotSupportedException {
    return null;
  }

  @Override
  public void enter(Maze maze) {}
}
