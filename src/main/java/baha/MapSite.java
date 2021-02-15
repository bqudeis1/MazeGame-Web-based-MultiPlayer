package baha;

public interface MapSite extends Cloneable {

  Object clone() throws CloneNotSupportedException;

  default String look(){return getClass().getSimpleName();}
}
