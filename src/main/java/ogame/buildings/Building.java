package ogame.buildings;

import ogame.Status;
import ogame.watch.ProductionTime;

public class Building {

    private int level;
    private String localName;
    private final String name;
    private Status status;
    private ProductionTime productionTime;
    private RequiredResources requiredResources;
    private final DataTechnology dataTechnology;

    public Building(String name, String dataTechnology) {
        this.name = name;
        this.dataTechnology = DataTechnology.getFromValue(dataTechnology);
    }

    public int getLevel() {
        return level;
    }

    public String getLocalName() {
        return localName;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public ProductionTime getProductionTime() {
        return productionTime;
    }

    public RequiredResources getRequiredResources() {
        return requiredResources;
    }

    public DataTechnology getDataTechnology() {
        return dataTechnology;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setProductionTime(ProductionTime productionTime) {
        this.productionTime = productionTime;
    }

    public void setRequiredResources(RequiredResources requiredResources) {
        this.requiredResources = requiredResources;
    }

    @Override
    public String toString() {
        return "Building{" +
                "level=" + level +
                ", localName='" + localName + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", productionTime=" + productionTime +
                ", requiredResources=" + requiredResources +
                ", dataTechnology='" + dataTechnology + '\'' +
                '}';
    }
}
