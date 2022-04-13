package ogame.web.galaxy;

import ogame.web.planets.Coordinate;
import org.openqa.selenium.WebDriver;

import java.io.Serializable;

public class Expedition extends GalaxyObject implements Serializable {

    public Expedition(Coordinate coordinate){
        super.setCoordinate(coordinate);
    }

    @Override
    public boolean setGalaxyObject(WebDriver webDriver) {
        return false;
    }
}
