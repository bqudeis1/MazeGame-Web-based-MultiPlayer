package baha;

import items.Item;

import java.util.List;

public class Seller implements MapSite {
    private List<Item> sellerItem;

    public String look(){
        return "Seller";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
    }

    @Override
    public void enter(Maze maze) {

    }
}
