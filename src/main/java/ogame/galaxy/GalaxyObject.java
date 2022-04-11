package ogame.galaxy;

import ogame.OgameObject;
import ogame.actions.GalaxyObjectAction;
import ogame.planets.Coordinate;
import ogame.tabs.FleetDispatch;
import ogame.utils.Waiter;
import org.openqa.selenium.WebDriver;

import java.io.Serializable;

public abstract class GalaxyObject extends OgameObject implements GalaxyObjectAction, Serializable {

    private Coordinate coordinate = null;
    private static final long serialVersionUID = 1992L;
    public GalaxyObject(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
    public GalaxyObject() {
    }

    @Override
    public boolean inputCoordinate(WebDriver webDriver) {
        boolean coordinateInputCorrect;
        do{
            coordinateInputCorrect = FleetDispatch.setCoordinate(webDriver,coordinate);
            Waiter.sleep(200,300);
            if(getAntiLooping().check()){
                getAntiLooping().reset();
                return false;
            }
        }while(!coordinateInputCorrect);
        getAntiLooping().reset();
        return true;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }
}
