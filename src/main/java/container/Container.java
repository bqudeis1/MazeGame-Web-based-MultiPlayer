package container;

import items.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class Container implements IContainer{
     protected List<Item> ItemsContainer;

     @Override
     public boolean addItem(Item item) {
          return ItemsContainer.add(item);
     }

     @Override
     public boolean addItems(List<Item> items) {
          return ItemsContainer.addAll(items);
     }

     @Override
     public boolean isEmpty() {
          return ItemsContainer.isEmpty();
     }

     @Override
     public List<Item> getItems() {
          List<Item> copy = new ArrayList<>(ItemsContainer);
          ItemsContainer.clear();
          return copy;
     }
     @Override
     public String getItemsName(){
          if(!isEmpty()){
               StringBuilder itemsName=new StringBuilder("you Found: ");
               for(Item item: ItemsContainer) {
                    itemsName.append(item.getName()).append("\n");
               }
               return itemsName.append(".").toString();
          }
          return "Nothing found in "+getClass().getSimpleName();
     }
     @Override
     public Item getAndRemove(String itemName) {//TODO:rename this to meaningful name
          Item retItem = null;
          for (Item item : ItemsContainer) {
               if (item.getName().equals(itemName))
                    retItem = item;
          }
          return retItem;
     }
     @Override
     public boolean containItemName(String ItemName){

     }
}
