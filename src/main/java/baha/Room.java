package baha;

import items.FlashLight;

import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

public class Room implements MapSite, Observer {
    private final int roomNo;
    private final MapSite[] mapSites = new MapSite[5];
    int playerDirection = 0;
    private boolean LightsOn;
    private boolean roomLightPrevState = true;

    public boolean isSwitchLightExists() {
        return switchLightExists;
    }

    private boolean switchLightExists;

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
                ", playerDirection=" + playerDirection +
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
