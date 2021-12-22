package ogame.eventbox;

public class FleetDetailsShip {
    public final String name;
    public final String value;

    public FleetDetailsShip(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "FleetDetailsShip{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
