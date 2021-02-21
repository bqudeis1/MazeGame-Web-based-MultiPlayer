package mapCreator;


import baha.MazeFactory;
import baha.component.Mirror;
import baha.component.Room;
import items.Key;

import java.util.HashMap;
import java.util.List;

public class Map1MirrorsCreator {
    public static void createMap1Mirrors(List<Room> rooms, MazeFactory mazeGame, HashMap<String, Key> keys){
        final int numberOfMirrors=14;
        Mirror[] mirrors=new Mirror[numberOfMirrors];
        for(int i=0;i<numberOfMirrors;i++){
            mirrors[i] =mazeGame.MakeMirror();
        }
        mirrors[3].addItem(keys.get("the prince of demons room key"));
        mirrors[7].addItem(keys.get("the orcs king room key"));
        mirrors[10].addItem(keys.get("the slime room key"));
        mirrors[12].addItem(keys.get("the fire dragon room key"));
        mirrors[13].addItem(keys.get("the mermaid queen room key"));
        rooms.get(7).setMapSites(mirrors[0],3);
        rooms.get(49).setMapSites(mirrors[1],2);
        rooms.get(49).setMapSites(mirrors[2],1);
        rooms.get(42).setMapSites(mirrors[3],0);
        rooms.get(45).setMapSites(mirrors[4],2);
        rooms.get(45).setMapSites(mirrors[5],0);
        rooms.get(23).setMapSites(mirrors[6],2);
        rooms.get(43).setMapSites(mirrors[7],0);
        rooms.get(18).setMapSites(mirrors[8],2);
        rooms.get(28).setMapSites(mirrors[9],0);
        rooms.get(27).setMapSites(mirrors[10],0);
        rooms.get(13).setMapSites(mirrors[11],3);
        rooms.get(26).setMapSites(mirrors[12],0);
        rooms.get(15).setMapSites(mirrors[13],1);
    }
}
