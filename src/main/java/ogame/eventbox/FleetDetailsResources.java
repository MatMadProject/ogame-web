package ogame.eventbox;

public class FleetDetailsResources {
    public final String name;
    public final String value;

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
