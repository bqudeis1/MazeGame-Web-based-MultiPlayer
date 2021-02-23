package baha.component;

import baha.MapSite;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import container.Container;
import items.Item;

@JsonDeserialize(as = Ground.class)
public class Ground extends Container implements MapSite {

    public Ground() {
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
    }

    @Override
    public String check() {
        //ground can't be checked
        return null;
    }

    @Override
    public String toString() {
        String groundInfo="";
        for(Item item : itemsContainer) {
            groundInfo="this ground contains "+item.getName()+".\n";
        }
        return groundInfo;
    }
}
