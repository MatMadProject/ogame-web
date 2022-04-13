package ogame.buildings;

import java.io.Serializable;

public class RequiredResources implements Serializable {

    private static final long serialVersionUID = 1992L;
    private final long metal, crystal, deuterium, energy;

    public RequiredResources(long metal, long crystal, long deuterium, long energy) {
        this.metal = metal;
        this.crystal = crystal;
        this.deuterium = deuterium;
        this.energy = energy;
    }

    public long getMetal() {
        return metal;
    }

    public long getCrystal() {
        return crystal;
    }

    public long getDeuterium() {
        return deuterium;
    }

    public long getEnergy() {
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
