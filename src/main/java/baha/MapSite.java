package baha;

public interface MapSite extends Cloneable {

  Object clone() throws CloneNotSupportedException;

  void enter(Maze maze);
}
