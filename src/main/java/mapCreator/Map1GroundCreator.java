package mapCreator;


import baha.MazeFactory;
import baha.component.Ground;
import baha.component.Room;

import java.util.List;

public class Map1GroundCreator {
    public static void createMap1Grounds(List<Room> rooms, MazeFactory mazeGame){
        final int numberOfGrounds=rooms.size();
        Ground[] grounds=new Ground[numberOfGrounds];
        for(int i=0;i<numberOfGrounds;i++){
            grounds[i] =new Ground();
            //the fifth side is always the ground
            rooms.get(i).setMapSites(grounds[i],4);
        }
    }
}
