package ogame.eventbox;

public class FleetDetailsResources {
    private final String name;
    private final String value;

    public FleetDetailsResources(String name, String value) {
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
        return "FleetDetailsResources{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
