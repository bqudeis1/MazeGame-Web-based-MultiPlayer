package container;

import checkable.Checkable;
import items.Item;
import java.util.ArrayList;
import java.util.List;
//@JsonDeserialize(using = CustomMapSiteDeserializer.class)
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

