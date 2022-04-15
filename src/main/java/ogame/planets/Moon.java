package ogame.planets;

import ogame.DataTechnology;
import ogame.buildings.Building;
import ogame.tabs.FleetDispatch;
import ogame.utils.Waiter;
import org.openqa.selenium.WebDriver;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Moon extends PlanetListObject implements Serializable {

    private static final long serialVersionUID = 1992L;
    private final List<Building> buildings;
    private boolean updateTechnologyBuilding = true;
    private boolean updateMoonInformation = true;
    private boolean moonDataAdded = false;


    public Moon(int positionOnList,String id) {
        super(positionOnList, id);
        buildings = getInstance();
    }

    private List<Building> getInstance(){
        List<Building> list = new ArrayList<>();
        list.add(new Building(DataTechnology.ROBOTICS_FACTORY));
        list.add(new Building(DataTechnology.SHIPYARD));
        list.add(new Building(DataTechnology.MOON_BASE));
        list.add(new Building(DataTechnology.SENSOR_PHALANX));
        list.add(new Building(DataTechnology.JUMP_GATE));
        return list;
    }

    public boolean isUpdateTechnologyBuilding() {
        return updateTechnologyBuilding;
    }

    public boolean isUpdateMoonInformation() {
        return updateMoonInformation;
    }

    public void setUpdateTechnologyBuilding(boolean updateTechnologyBuilding) {
        this.updateTechnologyBuilding = updateTechnologyBuilding;
    }

    public void setUpdateMoonInformation(boolean updateMoonInformation) {
        this.updateMoonInformation = updateMoonInformation;
    }

    public boolean isMoonDataAdded() {
        return moonDataAdded;
    }

    public void setMoonDataAdded(boolean moonDataAdded) {
        this.moonDataAdded = moonDataAdded;
    }

    @Override
    public String toString() {
        return "Moon{" +
                "buildings=" + buildings +
                ", updateTechnologyBuilding=" + updateTechnologyBuilding +
                ", updateMoonInformation=" + updateMoonInformation +
                ", moonDataAdded=" + moonDataAdded +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Moon)) return false;
        Moon moon = (Moon) o;
        return Objects.equals(super.getId(), moon.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(isUpdateMoonInformation());
    }

    @Override
    public boolean setGalaxyObject(WebDriver w) {
        boolean selected;
        do{
            if(FleetDispatch.isTargetMoonSelected(w))
                return true;
            FleetDispatch.clickTargetMoon(w);
            Waiter.sleep(200, 200);
            if (getAntiLooping().check()) {
                getAntiLooping().reset();
                return false;
            }
            selected  = FleetDispatch.isTargetMoonSelected(w);
        }while(selected);
        getAntiLooping().reset();
        return true;
    }
}
