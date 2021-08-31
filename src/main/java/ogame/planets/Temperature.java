package ogame.planets;

public class Temperature {
    private final int min;
    private final int max;

    public Temperature(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "min=" + min +
                ", max=" + max +
                '}';
    }
}
