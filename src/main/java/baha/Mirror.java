package baha;

import items.Item;

public class Mirror implements MapSite {
    private String containsKeyName;
    private Item keyItem;


    public void check(){}
    public String look(){return "You see a silhouette of you";}

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
    }

    @Override
    public void enter(Maze maze) {

    }
}
