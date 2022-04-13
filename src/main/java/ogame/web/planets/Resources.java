package ogame.web.planets;

import java.io.Serializable;

public class Resources implements Serializable {

    private static final long serialVersionUID = 1992L;
    private long metal, crystal, deuterium, energy;

    public Resources(int metal, int crystal, int deuterium, int energy) {
        this.metal = metal;
        this.crystal = crystal;
        this.deuterium = deuterium;
        this.energy = energy;
    }

    public Resources(long metal, long crystal, long deuterium, int energy) {
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

    public void setMetal(long metal) {
        this.metal = metal;
    }

    public void setCrystal(long crystal) {
        this.crystal = crystal;
    }

    public void setDeuterium(long deuterium) {
        this.deuterium = deuterium;
    }

    public void setEnergy(long energy) {
        this.energy = energy;
    }

    public long sum(){
        return metal + crystal + deuterium;
    }

    @Override
    public String toString() {
        return "Resources{" +
                "metal=" + metal +
                ", crystal=" + crystal +
                ", deuterium=" + deuterium +
                ", energy=" + energy +
                '}';
    }
}
