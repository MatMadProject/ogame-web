package ogame.galaxy;

import ogame.planets.Resources;
import ogame.ships.Ship;

public class Debris {

    private Resources resources;
    private Ship ships;

    public Debris(Resources resources, Ship ships) {

        this.resources = resources;
        this.ships = ships;
    }

    public Debris() {
    }

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public Ship getShips() {
        return ships;
    }

    public void setShips(Ship ships) {
        this.ships = ships;
    }

    @Override
    public String toString() {
        return "Debris{" +
                "resources=" + resources +
                ", ships=" + ships +
                '}';
    }
}
