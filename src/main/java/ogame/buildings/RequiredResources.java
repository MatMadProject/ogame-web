package ogame.buildings;

public class RequiredResources {
    private final int metal, crystal, deuterium, energy;

    public RequiredResources(int metal, int crystal, int deuterium, int energy) {
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
