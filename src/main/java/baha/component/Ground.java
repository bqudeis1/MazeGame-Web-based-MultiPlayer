package baha.component;

import baha.MapSite;
import container.Container;

public class Ground extends Container implements MapSite {

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
    }

    @Override
    public String check() {
        //ground can't be checked
        return null;
    }
}
