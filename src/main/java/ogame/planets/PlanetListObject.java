package ogame.planets;


import ogame.actions.PlanetListAction;
import ogame.galaxy.GalaxyObject;
import ogame.utils.Waiter;
import org.openqa.selenium.WebDriver;

import java.io.Serializable;
import java.util.Objects;


public class PlanetListObject extends GalaxyObject implements PlanetListAction, Serializable {

    private static final long serialVersionUID = 1992L;
    private int positionOnList;
    private final String id;
    private int diameter;
    private Temperature temperature = null;
    private Fields fields = null;
    private String name = "none";


    public PlanetListObject(int positionOnList, String id) {
        this.positionOnList = positionOnList;
        this.id = id;
    }

    public int getPositionOnList() {
        return positionOnList;
    }

    public void setPositionOnList(int positionOnList) {
        this.positionOnList = positionOnList;
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
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlanetListObject)) return false;
        PlanetListObject that = (PlanetListObject) o;
        return super.equals(that);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public boolean setGalaxyObject(WebDriver webDriver) {
        return false;
    }

    @Override
    public boolean inputCoordinate(WebDriver webDriver) {
        return super.inputCoordinate(webDriver);
    }
}
