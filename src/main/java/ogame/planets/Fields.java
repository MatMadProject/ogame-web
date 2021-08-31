package ogame.planets;

public class Fields {
    private int builtUp;
    private int max;

    public Fields(int builtUp, int max) {
        this.builtUp = builtUp;
        this.max = max;
    }

    /*
    SETTERS
     */

    public void setBuiltUp(int builtUp) {
        this.builtUp = builtUp;
    }

    public void setMax(int max) {
        this.max = max;
    }
    /*
    GETTERS
     */

    public int getBuiltUp() {
        return builtUp;
    }

    public int getMax() {
        return max;
    }

    @Override
    public String toString() {
        return "Fields{" +
                "builtUp=" + builtUp +
                ", max=" + max +
                '}';
    }
}
