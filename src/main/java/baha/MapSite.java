package baha;

public interface MapSite extends Cloneable {

  Object clone() throws CloneNotSupportedException;

  void enter(Maze maze);
  //TODO: remove this method no need .
}
