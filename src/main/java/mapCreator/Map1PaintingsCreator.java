package mapCreator;

import baha.MazeFactory;
import baha.component.Painting;
import baha.component.Room;
import items.Key;

import java.util.HashMap;
import java.util.List;

public class Map1PaintingsCreator {
    public static void createMap1Paintings(List<Room> rooms, MazeFactory mazeGame, HashMap<String,Key> keys){
        final int numberOfPaintings=14;
        Painting[] paintings=new Painting[numberOfPaintings];
        for(int i=0;i<numberOfPaintings;i++){
            paintings[i] =mazeGame.MakePainting();
        }
        paintings[0].addItem(keys.get("the demon king room key"));
        paintings[1].addItem(keys.get("the human king room key"));
        paintings[3].addItem(keys.get("the ghost whale room key"));
        paintings[5].addItem(keys.get("the lightning fairy room key"));
        paintings[7].addItem(keys.get("the trolls king room key"));
        paintings[10].addItem(keys.get("the eagles king key"));
        paintings[12].addItem(keys.get("the stray dogs room key"));
        paintings[13].addItem(keys.get("the sage room key"));
        rooms.get(0).setMapSites(paintings[0],3);
        rooms.get(3).setMapSites(paintings[1],3);
        rooms.get(16).setMapSites(paintings[2],3);
        rooms.get(20).setMapSites(paintings[3],2);
        rooms.get(24).setMapSites(paintings[4],1);
        rooms.get(11).setMapSites(paintings[5],3);
        rooms.get(28).setMapSites(paintings[6],2);
        rooms.get(14).setMapSites(paintings[7],3);
        rooms.get(22).setMapSites(paintings[8],0);
        rooms.get(32).setMapSites(paintings[9],2);
        rooms.get(37).setMapSites(paintings[10],0);
        rooms.get(48).setMapSites(paintings[11],3);
        rooms.get(30).setMapSites(paintings[12],3);
        rooms.get(13).setMapSites(paintings[13],0);


    }
}
