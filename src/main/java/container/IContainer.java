package container;

import checkable.Checkable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import items.Item;

import java.util.ArrayList;
import java.util.List;

public interface IContainer extends Checkable {
     boolean addItem(Item item);
     List<Item> getItems();
     boolean addItems(List<Item> items);
     String getItemsName();
     boolean isEmpty();
     public Item getAndRemove(String itemName);
     public Item get(String itemName);
     public boolean containItemName(String itemName);
}

