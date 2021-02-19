package container;

import com.fasterxml.jackson.annotation.JsonIgnore;
import items.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class Container implements IContainer {

    protected List<Item> itemsContainer =new ArrayList<>();

    public List<Item> getItemsContainer() {
        return itemsContainer;
    }

    @JsonIgnore
    @Override
    public boolean addItem(Item item) {
        return itemsContainer.add(item);
    }
    @JsonIgnore
    @Override
    public boolean addItems(List<Item> items) {
        return itemsContainer.addAll(items);
    }
    @JsonIgnore
    @Override
    public boolean isEmpty() {
        return itemsContainer.isEmpty();
    }
    @JsonIgnore
    @Override
    public List<Item> getItems() {
        List<Item> copy = new ArrayList<>(itemsContainer);
        itemsContainer.clear();
        return copy;
    }
    @JsonIgnore
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
    @JsonIgnore
    @Override
    public Item getAndRemove(String itemName) {//TODO:rename this to meaningful name
        Item retItem = null;
        for (Item item : itemsContainer) {
            if (item.getName().equals(itemName))
                retItem = item;
        }
        return retItem;
    }
    @JsonIgnore
    @Override
    public boolean containItemName(String itemName) {
        return itemsContainer.stream()
                .anyMatch(item -> item.getName().equals(itemName));
    }
    @JsonIgnore
    @Override
    public Item get(String itemName) {
       return itemsContainer.stream()
                .filter(customer -> itemName.equals(customer.getName()))
                .findAny()
                .orElse(null);
    }
}
