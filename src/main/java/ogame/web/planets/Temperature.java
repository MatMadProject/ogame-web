package ogame.web.planets;

import java.io.Serializable;

public class Temperature implements Serializable {

    private static final long serialVersionUID = 1992L;
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
