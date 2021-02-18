package baha;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import container.Container;
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
}
