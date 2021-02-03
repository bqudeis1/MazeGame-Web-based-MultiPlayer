package baha;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Maze implements Cloneable {
        private List<Room> roomSet= new ArrayList<Room>();

    public List<Room> getRoomSet() {
        return roomSet;
    }

    public void addRoom(Room r){
            if(r!=null)
                roomSet.add(r);
        }

    public Room returnRoom(int index){
        return roomSet.get(index);
    }

}