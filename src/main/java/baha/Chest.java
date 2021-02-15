package baha;

import container.Container;
import items.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Chest implements MapSite, Container {
    private boolean locked;
    private String neededKeyName;
    private List<Item> chestItem;

    public void check() {
    }

    public String look() {
        return "Chest";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
    }

    @Override
    public void enter(Maze maze) {
    }

    @Override
    public boolean addItem(Item item) {
        return chestItem.add(item);
    }

    @Override
    public boolean addItems(List<Item> items) {
        return chestItem.addAll(items);
    }

    @Override
    public boolean isEmpty() {
        return chestItem.isEmpty();
    }

    @Override
    public List<Item> getItems(List<Item> items) {
        List<Item> copy = new ArrayList<>(chestItem);
        chestItem.clear();
        return copy;
    }
}
