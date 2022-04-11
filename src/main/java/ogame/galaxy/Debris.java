package ogame.galaxy;

import ogame.planets.*;
import ogame.ships.Ship;
import ogame.tabs.FleetDispatch;
import ogame.utils.Waiter;
import org.openqa.selenium.WebDriver;

import java.io.Serializable;

public class Debris extends GalaxyObject implements Serializable {

    private static final long serialVersionUID = 1992L;
    private Resources resources;
    private Ship requiredShip;

    public Debris(Resources resources, Ship ships) {
        this.resources = resources;
        this.requiredShip = ships;
    }

    public Debris() {
    }

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public Ship getRequiredShip() {
        return requiredShip;
    }

    public void setRequiredShip(Ship requiredShip) {
        this.requiredShip = requiredShip;
    }


    @Override
    public String toString() {
        return "Debris{" +
                "resources=" + resources +
                ", ships=" + requiredShip +
                ", coordinate=" + super.getCoordinate() +
                '}';
    }

    @Override
    public boolean setGalaxyObject(WebDriver w) {
        boolean selected;
        do{
            if(FleetDispatch.isTargetDebrisSelected(w))
                return true;
            FleetDispatch.clickTargetDebris(w);
            Waiter.sleep(200, 200);
            if (getAntiLooping().check()) {
                getAntiLooping().reset();
                    return false;
            }
            selected  = FleetDispatch.isTargetDebrisSelected(w);
        }while(selected);
        getAntiLooping().reset();
        return false;
    }
}