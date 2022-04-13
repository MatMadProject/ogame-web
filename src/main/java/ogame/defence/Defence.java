package ogame.defence;

import ogame.DataTechnology;
import ogame.Status;
import ogame.buildings.RequiredResources;
import ogame.watch.ProductionTime;

import java.io.Serializable;
import java.util.Objects;

public class Defence implements Serializable {
    private static final long serialVersionUID = 1992L;
    private int value;
    private String localName;
    private final String name;
    private Status status;
    private ProductionTime productionTime;
    private RequiredResources requiredResources;
    private final DataTechnology dataTechnology;

    public Defence(String name, DataTechnology dataTechnology) {
        this.name = name;
        this.dataTechnology = dataTechnology;
        this.requiredResources = requiredResources(dataTechnology);
    }

    public Defence(DataTechnology dataTechnology) {
        this.dataTechnology = dataTechnology;
        this.name = dataTechnology.name();
        this.requiredResources = requiredResources(dataTechnology);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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

    private RequiredResources requiredResources(DataTechnology dataTechnology){
        switch (dataTechnology){
            case ROCKET_LAUNCHER:
                return new RequiredResources(2000,0,0,0);
            case LASER_CANNON_LIGHT:
                return new RequiredResources(1500,500,0,0);
            case LASER_CANNON_HEAVY:
                return new RequiredResources(6000,2000,0,0);
            case GAUSS_CANNON:
                return new RequiredResources(20000,15000,2000,0);
            case ION_CANNON:
                return new RequiredResources(5000,3000,0,0);
            case PLASMA_CANNON:
                return new RequiredResources(50000,50000,30000,0);
            case SHIELD_DOME_SMALL:
                return new RequiredResources(10000,10000,0,0);
            case SHIELD_DOME_LARGE:
                return new RequiredResources(50000,50000,0,0);
            case MISSILE_INTERCEPTOR:
                return new RequiredResources(8000,0,2000,0);
            case MISSILE_INTERPLANETARY:
                return new RequiredResources(12500,2500,10000,0);
            default:
                return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Defence defence = (Defence) o;
        return dataTechnology == defence.dataTechnology;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataTechnology);
    }

    @Override
    public String toString() {
        return "Cannon{" +
                "value=" + value +
                ", localName='" + localName + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", productionTime=" + productionTime +
                ", requiredResources=" + requiredResources +
                ", dataTechnology=" + dataTechnology +
                '}';
    }
}
