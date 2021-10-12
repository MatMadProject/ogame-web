package ogame.planets;

public class Resources {

    private int metal, crystal, deuterium, energy;

    public Resources(int metal, int crystal, int deuterium, int energy) {
        this.metal = metal;
        this.crystal = crystal;
        this.deuterium = deuterium;
        this.energy = energy;
    }

    public int getMetal() {
        return metal;
    }

    public int getCrystal() {
        return crystal;
    }

    public int getDeuterium() {
        return deuterium;
    }

    public int getEnergy() {
        return energy;
    }

    public void setMetal(int metal) {
        this.metal = metal;
    }

    public void setCrystal(int crystal) {
        this.crystal = crystal;
    }

    public void setDeuterium(int deuterium) {
        this.deuterium = deuterium;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public String toString() {
        return "RequiredResources{" +
                "metal=" + metal +
                ", crystal=" + crystal +
                ", deuterium=" + deuterium +
                ", energy=" + energy +
                '}';
    }
}
