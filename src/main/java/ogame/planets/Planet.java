package ogame.planets;

import ogame.DataTechnology;
import ogame.OgameWeb;
import ogame.Type;
import ogame.buildings.Building;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Planet implements Serializable {

    private static final long serialVersionUID = 1992L;
    private final String id;
    private int positionOnList;
    private int diameter;
    private Temperature temperature = null;
    private Fields fields = null;
    private String name = "none";
    private Coordinate coordinate = null;
    private Moon moon = null;
    private ResourcesProduction resourcesProduction;
    private Resources resources;
    private List<Building> buildings;
    private long updateTime;
    private boolean updateResourcesProduction = true;
    private boolean updateResourceBuilding = true;
    private boolean updateTechnologyBuilding = true;
    private boolean updatePlanetInformation = true;
    private boolean colonyDataAdded = false;

    public Planet(String id, int positionOnList) {
        this.id = id;
        this.positionOnList = positionOnList;
        this.resourcesProduction = new ResourcesProduction();
        this.resources = new Resources(0,0,0,0);

        buildings = new ArrayList<>();
        for(DataTechnology dataTechnology : DataTechnology.values()){
            if(dataTechnology.getType() == Type.PRODUCTION ||
                    dataTechnology.getType() == Type.TECHNOLOGIES)
                buildings.add(new Building(dataTechnology.name(),dataTechnology.getValue()));
        }
    }
    /*
    Execute
     */
    public boolean click(){
        if(positionOnList != 0)
            return PlanetsList.clickOnPlanet(OgameWeb.webDriver,positionOnList);
        return false;
    }
    public boolean clickOnMoon(){
        if(positionOnList != 0)
            return PlanetsList.clickOnMoon(OgameWeb.webDriver,positionOnList);
        return false;
    }
    /*
    SETTERS
     */

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setMoon(Moon moon) {
        this.moon = moon;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    /*
    GETTERS
     */

    public String getId() {
        return id;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public Fields getFields() {
        return fields;
    }

    public String getName() {
        return name;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Moon getMoon() {
        return moon;
    }

    public int getDiameter() {
        return diameter;
    }

    public int getPositionOnList() {
        return positionOnList;
    }

    public long getUpdateTime() {
        return updateTime;
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
        for(Building building : buildings)
            if(building.getDataTechnology().getValue().equals(dataTechnologyValue))
                return building;

        return null;
    }

    public Building getBuilding(DataTechnology dataTechnology) {
        for(Building building : buildings)
            if(building.getDataTechnology() == dataTechnology)
                return building;

        return null;
    }

    public Resources getResources() {
        return resources;
    }

    public void setPositionOnList(int positionOnList) {
        this.positionOnList = positionOnList;
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
        Planet planet = (Planet) o;
        return Objects.equals(id, planet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Planet{" +
                "id='" + id + '\'' +
                ", positionOnList=" + positionOnList +
                ", diameter=" + diameter +
                ", temperature=" + temperature +
                ", fields=" + fields +
                ", name='" + name + '\'' +
                ", coordinate=" + coordinate +
                ", moon=" + moon +
                '}';
    }
}
