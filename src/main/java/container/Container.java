package container;

import items.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class Container implements IContainer {
    protected List<Item> itemsContainer;

    @Override
    public boolean addItem(Item item) {
        return itemsContainer.add(item);
    }

    @Override
    public boolean addItems(List<Item> items) {
        return itemsContainer.addAll(items);
    }

    @Override
    public boolean isEmpty() {
        return itemsContainer.isEmpty();
    }

    @Override
    public List<Item> getItems() {
        List<Item> copy = new ArrayList<>(itemsContainer);
        itemsContainer.clear();
        return copy;
    }

    @Override
    public String getItemsName() {
        if (!isEmpty()) {
            StringBuilder itemsName = new StringBuilder("you Found: ");
            for (Item item : itemsContainer) {
                itemsName.append(item.getName()).append("\n");
            }
            return itemsName.append(".").toString();
        }
        return "Nothing found in " + getClass().getSimpleName();
    }

    @Override
    public Item getAndRemove(String itemName) {//TODO:rename this to meaningful name
        Item retItem = null;
        for (Item item : itemsContainer) {
            if (item.getName().equals(itemName))
                retItem = item;
        }
        return retItem;
    }

    @Override
    public boolean containItemName(String itemName) {
        return itemsContainer.stream()
                .anyMatch(item -> item.getName().equals(itemName));
    }

    @Override
    public Item get(String itemName) {
       return itemsContainer.stream()
                .filter(customer -> itemName.equals(customer.getName()))
                .findAny()
                .orElse(null);
    }
}
