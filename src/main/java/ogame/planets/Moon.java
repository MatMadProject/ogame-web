package ogame.planets;

import ogame.DataTechnology;
import ogame.buildings.Building;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Moon extends PlanetListObject implements Serializable {

    private static final long serialVersionUID = 1992L;
    private final List<Building> buildings;


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

    @Override
    public String toString() {
        return "Moon{" +
                "buildings=" + buildings +
                super.toString() +
                '}';
    }
}
