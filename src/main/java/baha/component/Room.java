package baha.component;

import baha.MapSite;
import items.FlashLight;

import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

public class Room implements MapSite, Observer {
    private final int roomNo;
    private final MapSite[] mapSites = new MapSite[5];
    private boolean LightsOn;
    private boolean roomLightPrevState = true;
    private boolean switchLightExists;


    public boolean isSwitchLightExists() {
        return switchLightExists;
    }

    public Room(int roomNo) {
        this.roomNo = roomNo;
    }

    public boolean isLightsOn() {
        return LightsOn;
    }

    public void setLightsOn(boolean lightsState) {
        this.LightsOn = lightsState;
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
                ", dark=" + LightsOn +
                ", switchLightExists=" + switchLightExists +
                '}';
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof FlashLight) {
            boolean isFlashOn = ((FlashLight) o).getStatus();
            LightsOn = isFlashOn || roomLightPrevState;
        }
    }
}
