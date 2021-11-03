package ogame.planets;

import ogame.buildings.Building;
import ogame.buildings.DataTechnology;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Moon implements Serializable {

    private static final long serialVersionUID = 1992L;
    private final int positionOnList;
    private int diameter;
    private Temperature temperature = null;
    private Fields fields = null;
    private String name = "none";
    private Coordinate coordinate = null;
    private List<Building> buildings;


    public Moon(int positionOnList) {
        this.positionOnList = positionOnList;

        buildings = new ArrayList<>();
//        for(DataTechnology dataTechnology : DataTechnology.values()){
//            buildings.add(new Building(dataTechnology.name(),dataTechnology.getValue()));
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

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    /*
        GETTERS
        */
    public int getPositionOnList() {
        return positionOnList;
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

    public int getDiameter() {
        return diameter;
    }

    @Override
    public String toString() {
        return "Moon{" +
                "positionOnList=" + positionOnList +
                ", diameter=" + diameter +
                ", temperature=" + temperature +
                ", fields=" + fields +
                ", name='" + name + '\'' +
                ", coordinate=" + coordinate +
                '}';
    }
}
