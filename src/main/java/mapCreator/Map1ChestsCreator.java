package mapCreator;

import baha.Chest;
import baha.Painting;
import baha.Room;
import items.Key;

import java.util.HashMap;
import java.util.List;

public class Map1ChestsCreator {
    public static void createMap1Chests(List<Room> rooms, MazeFactory mazeGame, HashMap<String,Key> keys){
        final int numberOfChests=4;
        Chest[] chests=new Chest[numberOfChests];
        for(int i=0;i<numberOfChests;i++){
            chests[i] =mazeGame.MakeChest();
        }
        chests[0].addItem(keys.get("the sea dragon room key"));
        chests[0].setNeededKeyName("the demon cat room key");
        chests[1].addItem(keys.get("the goblins king room key"));
        chests[1].setNeededKeyName("the orcs king room key");
        chests[2].addItem(keys.get("the wargs king room key"));
        chests[2].setNeededKeyName("the lightning fairy room key");
        chests[3].addItem(keys.get("the gaints room key"));
        chests[3].addItem(keys.get("the wizards king room key"));
        chests[3].setNeededKeyName("the eagles king key");


        rooms.get(46).setMapSites(chests[0],0 );
        rooms.get(18).setMapSites(chests[1],1 );
        rooms.get(28).setMapSites(chests[2],1 );
        rooms.get(21).setMapSites(chests[3],2 );

    }
}
