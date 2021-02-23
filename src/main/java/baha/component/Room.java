package baha.component;

import baha.MapSite;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import items.FlashLight;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

@JsonDeserialize(as = Room.class)
public class Room implements MapSite, Observer {
    private final int roomNo;
    private final MapSite[] mapSites = new MapSite[5];
    private boolean lightsOn;
    private boolean roomLightPrevState = true;
    private boolean switchLightExists;
    private String name="Room";

    public Room() {
        roomNo=-1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSwitchLightExists() {
        return switchLightExists;
    }

    public Room(int roomNo) {
        this.roomNo = roomNo;
    }

    public boolean isLightsOn() {
        return lightsOn;
    }

    public void setLightsOn(boolean lightsState) {
        this.lightsOn = lightsState;
    }

    public void switchLight() {
        if (switchLightExists) {
            roomLightPrevState = !roomLightPrevState;
        }
    }

    public int getRoomNo() {
        return roomNo;
    }

    public MapSite[] getMapSites() {
        return mapSites;
    }
    @JsonIgnore
    public MapSite getMapSite(int index){return mapSites[index];}

    public void setMapSites(MapSite mapSite, int side) {
        this.mapSites[side] = mapSite;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNo=" + roomNo +
                ", mapSites=" + Arrays.toString(mapSites) +
                ", dark=" + lightsOn +
                ", switchLightExists=" + switchLightExists +
                '}';
    }

    public String RoomInfo(){
        String lightStatus=isLightsOn()?" lit.\n":" dark.\n";
        String switchLightStatus=isSwitchLightExists()?"switch light exist.\n":"switch light doesn't exist.\n";
        return "you are in room number "+roomNo+".\nthis room is "+lightStatus+" and "+switchLightStatus+".";
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof FlashLight) {
            boolean isFlashOn = ((FlashLight) o).getStatus();
            lightsOn = isFlashOn || roomLightPrevState;
        }
    }
}
