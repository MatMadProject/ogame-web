package ogame.planets;

import ogame.OgameWeb;
import ogame.utils.Waiter;

public class Planet {
    private final String id;
    private final int positionOnList;
    private int diameter;
    private Temperature temperature = null;
    private Fields fields = null;
    private String name = "none";
    private Coordinate coordinate = null;
    private Moon moon = null;
    private long updateTime;


    public Planet(String id, int positionOnList) {
        this.id = id;
        this.positionOnList = positionOnList;
    }
    /*
    Execute
     */
    public void click(){
        if(positionOnList != 0)
            PlanetsList.clickOnPlanet(OgameWeb.webDriver,positionOnList);
    }
    public void clickOnMoon(){
        if(positionOnList != 0)
            PlanetsList.clickOnMoon(OgameWeb.webDriver,positionOnList);
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
