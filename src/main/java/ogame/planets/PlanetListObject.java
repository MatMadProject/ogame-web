package ogame.planets;

import ogame.OgameObject;
import ogame.actions.PlanetListAction;
import ogame.utils.Waiter;
import org.openqa.selenium.WebDriver;

import java.util.Objects;


public class PlanetListObject extends OgameObject implements PlanetListAction {

    private final int positionOnList;
    private final String id;
    private int diameter;
    private Temperature temperature = null;
    private Fields fields = null;
    private String name = "none";
    private Coordinate coordinate = null;

    public PlanetListObject(int positionOnList, String id) {
        this.positionOnList = positionOnList;
        this.id = id;
    }

    public int getPositionOnList() {
        return positionOnList;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean clickOnList(WebDriver w) {
        PlanetListObject selected;
        do{
            if(this instanceof Moon){
                if(PlanetsList.clickOnMoon(w,positionOnList))
                    return true;
                Waiter.sleep(200, 200);
                if (getAntiLooping().check()) {
                    getAntiLooping().reset();
                    return false;
                }
                selected = PlanetsList.selectedMoon(w);
            }else{
                if(PlanetsList.clickOnPlanet(w,positionOnList))
                    return true;

                Waiter.sleep(200, 200);
                if (getAntiLooping().check()) {
                    getAntiLooping().reset();
                    return false;
                }
                selected = PlanetsList.selectedPlanet(w);
            }
        }while(Objects.requireNonNull(selected).getPositionOnList() == positionOnList);
        getAntiLooping().reset();
        return false;
    }

    @Override
    public String toString() {
        return "PlanetListObject{" +
                "positionOnList=" + positionOnList +
                ", id='" + id + '\'' +
                ", diameter=" + diameter +
                ", temperature=" + temperature +
                ", fields=" + fields +
                ", name='" + name + '\'' +
                ", coordinate=" + coordinate +
                '}';
    }

}
