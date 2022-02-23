package ogame.ships;

import ogame.DataTechnology;
import ogame.Status;
import ogame.buildings.RequiredResources;
import ogame.watch.ProductionTime;

import java.io.Serializable;
import java.util.Objects;

public class Ship implements Serializable {

    private static final long serialVersionUID = 1992L;
    private int value;
    private int capacity;
    private String localName;
    private final String name;
    private Status status;
    private ProductionTime productionTime;
    private RequiredResources requiredResources;
    private final DataTechnology dataTechnology;
    private boolean selectAll;

    public Ship(String name, DataTechnology dataTechnology) {
        this.name = name;
        this.dataTechnology = dataTechnology;
        setRequiredResources(requiredResources(dataTechnology));
        setCapacity(capacity(dataTechnology));
    }

    public Ship(DataTechnology dataTechnology) {
        this.dataTechnology = dataTechnology;
        this.name = dataTechnology.name();
        setRequiredResources(requiredResources(dataTechnology));
        setCapacity(capacity(dataTechnology));
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

    public boolean isSelectAll() {
        return selectAll;
    }

    public void setSelectAll(boolean selectAll) {
        this.selectAll = selectAll;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public DataTechnology getDataTechnology() {
        return dataTechnology;
    }

    private RequiredResources requiredResources(DataTechnology dataTechnology){
        switch (dataTechnology){
            case FIGHTER_LIGHT:
                return new RequiredResources(3000,1000,0,0);
            case FIGHTER_HEAVY:
                return new RequiredResources(6000,4000,0,0);
            case CRUISER:
                return new RequiredResources(20000,7000,2000,0);
            case BATTLE_SHIP:
                return new RequiredResources(45000,15000,0,0);
            case INTERCEPTOR:
                return new RequiredResources(30000,40000,15000,0);
            case BOMBER:
                return new RequiredResources(50000,25000,15000,0);
            case DESTROYER:
                return new RequiredResources(60000,50000,15000,0);
            case DEATH_STAR:
                return new RequiredResources(5000000,4000000,1000000,0);
            case REAPER:
                return new RequiredResources(85000,55000,20000,0);
            case EXPLORER:
                return new RequiredResources(8000,15000,8000,0);
            case TRANSPORTER_SMALL:
                return new RequiredResources(2000,2000,0,0);
            case TRANSPORTER_LARGE:
                return new RequiredResources(6000,6000,0,0);
            case COLONY_SHIP:
                return new RequiredResources(10000,20000,10000,0);
            case RECYCLER:
                return new RequiredResources(10000,6000,2000,0);
            case ESPIONAGE_PROBE:
                return new RequiredResources(0,1000,0,0);
            case SOLAR_SATELITE:
                return new RequiredResources(0,2000,500,0);
            case RESBUGGY:
                return new RequiredResources(2000,2000,1000,0);
            default:
                return null;
        }
    }

    private int capacity(DataTechnology dataTechnology){
        switch (dataTechnology){
            case FIGHTER_LIGHT:
                return 50;
            case FIGHTER_HEAVY:
                return 100;
            case CRUISER:
                return 800;
            case BATTLE_SHIP:
                return 1500;
            case INTERCEPTOR:
                return 750;
            case BOMBER:
                return 500;
            case DESTROYER:
                return 2000;
            case DEATH_STAR:
                return 1000000;
            case REAPER:
            case EXPLORER:
                return 10000;
            case TRANSPORTER_SMALL:
                return 5000;
            case TRANSPORTER_LARGE:
                return 25000;
            case COLONY_SHIP:
                return 7500;
            case RECYCLER:
                return 20000;
            case ESPIONAGE_PROBE:
            case SOLAR_SATELITE:
            case RESBUGGY:
            default:
                return 0;
        }
    }

    public long currentCapacity(int levelHyperspaceTechnology){
        int bonus = (capacity/20) * levelHyperspaceTechnology;
        return capacity + bonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return dataTechnology == ship.dataTechnology;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataTechnology);
    }

    @Override
    public String toString() {
        return "Ship{" +
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
