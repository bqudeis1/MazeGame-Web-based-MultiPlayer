package container;

import items.Item;

import java.util.List;

public interface Container {
    int n=0;
    public boolean addItem(Item item);
    public boolean addItems(List<Item> items);
    public List<Item> getItems(List<Item> items);
    public boolean isEmpty();
}

