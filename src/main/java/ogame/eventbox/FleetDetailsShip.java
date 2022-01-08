package ogame.eventbox;

public class FleetDetailsShip {
    private final String name;
    private final String value;

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
