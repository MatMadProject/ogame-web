package ogame.planets;

public class Planet {
    private final String id;
    private final int positionOnList;
    private int diameter;
    private Temperature temperature = null;
    private Fields fields = null;
    private String name = "none";
    private Coordinate coordinate = null;
    private Moon moon = null;


    public Planet(String id, int positionOnList) {
        this.id = id;
        this.positionOnList = positionOnList;
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
