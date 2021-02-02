package baha;

import java.util.HashSet;
import java.util.Set;

public class Maze implements Cloneable {
        private Set<Room> roomSet= new HashSet<>();

        public void addRoom(Room r){
            if(r!=null)
                roomSet.add(r);
        }

}