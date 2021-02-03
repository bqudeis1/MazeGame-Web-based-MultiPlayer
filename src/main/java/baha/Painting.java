package baha;

import items.Item;

public class Painting implements MapSite {
    private String containsKeyName;
    private Item keyItem;

    public void check(){}
    public String look(){return "Painting";}

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
    }
    @Override
    public void enter(Maze maze) {

    }

}
