package ogame.planets;

import ogame.DataTechnology;
import ogame.Type;
import ogame.buildings.Building;
import ogame.tabs.FleetDispatch;
import ogame.utils.Waiter;
import org.openqa.selenium.WebDriver;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Planet extends PlanetListObject implements Serializable{

    private static final long serialVersionUID = 1992L;
    private Moon moon = null;
    private final ResourcesProduction resourcesProduction;
    private final Resources resources;
    private final List<Building> buildings;
    private long updateTimeInMilliSeconds;
    private boolean updateResourcesProduction = true;
    private boolean updateResourceBuilding = true;
    private boolean updateTechnologyBuilding = true;
    private boolean updatePlanetInformation = true;
    private boolean colonyDataAdded = false;

    public Planet(String id, int positionOnList) {
        super(positionOnList,id);
        this.resourcesProduction = new ResourcesProduction();
        this.resources = new Resources(0,0,0,0);
        buildings = getInstance();
    }

    public void setMoon(Moon moon) {
        this.moon = moon;
    }

    public void setUpdateTimeInMilliSeconds(long updateTimeInMilliSeconds) {
        this.updateTimeInMilliSeconds = updateTimeInMilliSeconds;
    }
    /*
    GETTERS
     */
    public Moon getMoon() {
        return moon;
    }

    public boolean hasMoon(){
        return moon != null;
    }

    public long getUpdateTimeInMilliSeconds() {
        return updateTimeInMilliSeconds;
    }

    public ResourcesProduction getResourcesProduction() {
        return resourcesProduction;
    }

    public boolean isUpdateResourcesProduction() {
        return updateResourcesProduction;
    }

    public void setUpdateResourcesProduction(boolean updateResourcesProduction) {
        this.updateResourcesProduction = updateResourcesProduction;
    }
    public boolean isUpdateResourceBuilding() {
        return updateResourceBuilding;
    }

    public void setUpdateResourceBuilding(boolean updateResourceBuilding) {
        this.updateResourceBuilding = updateResourceBuilding;
    }
    public boolean isUpdateTechnologyBuilding() {
        return updateTechnologyBuilding;
    }

    public void setUpdateTechnologyBuilding(boolean updateTechnologyBuilding) {
        this.updateTechnologyBuilding = updateTechnologyBuilding;
    }
    public Building getBuilding(String dataTechnologyValue) {
        return buildings.stream().
                filter(item -> item.getDataTechnology().getValue().equals(dataTechnologyValue)).
                findFirst().orElse(null);
    }
    public Building getBuilding(DataTechnology dataTechnology) {
        return buildings.stream().
                filter(item -> item.getDataTechnology() == dataTechnology).
                findFirst().orElse(null);
    }
    private List<Building> getInstance(){
        List<Building> buildings = new ArrayList<>();
        for(DataTechnology dataTechnology : DataTechnology.values()){
            if(dataTechnology.getType() == Type.PRODUCTION ||
                    dataTechnology.getType() == Type.TECHNOLOGIES)
                buildings.add(new Building(dataTechnology.name(),dataTechnology.getValue()));
        }
        return buildings;
    }
    public Resources getResources() {
        return resources;
    }

    public boolean isColonyDataAdded() {
        return colonyDataAdded;
    }

    public void setColonyDataAdded() {
        this.colonyDataAdded = true;
    }

    public boolean isUpdatePlanetInformation() {
        return updatePlanetInformation;
    }

    public void setUpdatePlanetInformation(boolean updatePlanetInformation) {
        this.updatePlanetInformation = updatePlanetInformation;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanetListObject planet = (PlanetListObject) o;
        return Objects.equals(super.getId(), planet.getId());
    }

    @Override
    public String toString() {
        return "Planet{" +
                "moon=" + moon +
                ", resourcesProduction=" + resourcesProduction +
                ", resources=" + resources +
                ", buildings=" + buildings +
                ", updateTimeInMilliSeconds=" + updateTimeInMilliSeconds +
                ", updateResourcesProduction=" + updateResourcesProduction +
                ", updateResourceBuilding=" + updateResourceBuilding +
                ", updateTechnologyBuilding=" + updateTechnologyBuilding +
                ", updatePlanetInformation=" + updatePlanetInformation +
                ", colonyDataAdded=" + colonyDataAdded +
                '}';
    }
    @Override
    public boolean setGalaxyObject(WebDriver w) {
        boolean selected;
        do{
            if(FleetDispatch.isTargetPlanetSelected(w))
                return true;
            FleetDispatch.clickTargetPlanet(w);
            Waiter.sleep(200, 200);
            if (getAntiLooping().check()) {
                getAntiLooping().reset();
                return false;
            }
            selected  = FleetDispatch.isTargetPlanetSelected(w);
        }while(selected);
        getAntiLooping().reset();
        return true;
    }
}
