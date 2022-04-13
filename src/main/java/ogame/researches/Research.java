package ogame.researches;

import ogame.DataTechnology;
import ogame.Status;
import ogame.watch.ProductionTime;
import ogame.buildings.RequiredResources;

import java.io.Serializable;
import java.util.Objects;

public class Research implements Serializable {

    private static final long serialVersionUID = 1992L;
    private int level;
    private String localName;
    private final String name;
    private Status status;
    private ProductionTime productionTime;
    private RequiredResources requiredResources;
    private final DataTechnology dataTechnology;

    public Research(String name, String dataTechnology) {
        this.name = name;
        this.dataTechnology = DataTechnology.getFromValue(dataTechnology);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ProductionTime getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(ProductionTime productionTime) {
        this.productionTime = productionTime;
    }

    public RequiredResources getRequiredResources() {
        return requiredResources;
    }

    public void setRequiredResources(RequiredResources requiredResources) {
        this.requiredResources = requiredResources;
    }

    public DataTechnology getDataTechnology() {
        return dataTechnology;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Research research = (Research) o;
        return dataTechnology == research.dataTechnology;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataTechnology);
    }

    @Override
    public String toString() {
        return "Research{" +
                "level=" + level +
                ", localName='" + localName + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", productionTime=" + productionTime +
                ", requiredResources=" + requiredResources +
                ", dataTechnology=" + dataTechnology +
                '}';
    }
}
