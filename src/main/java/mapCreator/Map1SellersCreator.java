package mapCreator;

import baha.MazeFactory;
import baha.component.Room;
import baha.component.Seller;
import items.Key;

import java.util.HashMap;
import java.util.List;

public class Map1SellersCreator {
    public static void createMap1Sellers(List<Room> rooms, MazeFactory mazeGame, HashMap<String,Key> keys){
        final int numberOfSellers=5;
        Seller[] sellers=new Seller[numberOfSellers];
        for(int i=0;i<numberOfSellers;i++){
            sellers[i] =mazeGame.MakeSeller();
        }
        sellers[0].addItem(keys.get("the fairy queen room key"));
        sellers[1].addItem(keys.get("the jungle nymph room key"));
        sellers[2].addItem(keys.get("the demon cat room key"));
        sellers[2].addItem(keys.get("demon of wrath room key"));
        sellers[3].addItem(keys.get("the ice demon room key"));
        sellers[4].addItem(keys.get("the mumakil room key"));
        rooms.get(10).setMapSites(sellers[0],0);
        rooms.get(25).setMapSites(sellers[1],3);
        rooms.get(24).setMapSites(sellers[2],0);
        rooms.get(34).setMapSites(sellers[3],3);
        rooms.get(47).setMapSites(sellers[4],2);

    }
}
