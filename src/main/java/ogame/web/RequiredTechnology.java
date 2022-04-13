package ogame.web;

public class RequiredTechnology {

    private final int requiredLevel;
    private final DataTechnology requiredTechnology;

    public RequiredTechnology(int requiredLevel, DataTechnology requiredTechnology) {
        this.requiredLevel = requiredLevel;
        this.requiredTechnology = requiredTechnology;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public DataTechnology getRequiredTechnology() {
        return requiredTechnology;
    }

    @Override
    public String toString() {
        return "RequiredTechnology{" +
                "requiredLevel=" + requiredLevel +
                ", requiredTechnology=" + requiredTechnology +
                '}';
    }
}
