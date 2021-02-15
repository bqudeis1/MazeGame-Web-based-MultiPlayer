package container;

import checkable.Checkable;
import items.Item;

import java.util.ArrayList;
import java.util.List;

public interface IContainer extends Checkable {
     boolean addItem(Item item);
     boolean addItems(List<Item> items);
     List<Item> getItems();
     String treasuredItemsName();
     boolean isEmpty();
}

