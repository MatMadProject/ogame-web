package ogame.eventbox;

import ogame.planets.Coordinate;

import java.io.Serializable;
import java.util.Objects;

public class Event implements Serializable {
    private static final long serialVersionUID = 1992L;

    private final String ID;
    private int missionType;
    private Type type;
    private boolean returning;
    private long arrivalTime;
    private GalaxyObject origin;
    private Coordinate originCoordinate;
    private String fleetDetails;
    private GalaxyObject destination;
    private Coordinate destinationCoordinate;


    public Event(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public int getMissionType() {
        return missionType;
    }

    public void setMissionType(int missionType) {
        this.missionType = missionType;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isReturn() {
        return returning;
    }

    public void setReturn(boolean returning) {
        this.returning = returning;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(long arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public GalaxyObject getOrigin() {
        return origin;
    }

    public void setOrigin(GalaxyObject origin) {
        this.origin = origin;
    }

    public Coordinate getOriginCoordinate() {
        return originCoordinate;
    }

    public void setOriginCoordinate(Coordinate originCoordinate) {
        this.originCoordinate = originCoordinate;
    }

    public String getFleetDetails() {
        return fleetDetails;
    }

    public void setFleetDetails(String fleetDetails) {
        this.fleetDetails = fleetDetails;
    }

    public GalaxyObject getDestination() {
        return destination;
    }

    public void setDestination(GalaxyObject destination) {
        this.destination = destination;
    }

    public Coordinate getDestinationCoordinate() {
        return destinationCoordinate;
    }

    public void setDestinationCoordinate(Coordinate destinationCoordinate) {
        this.destinationCoordinate = destinationCoordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(ID, event.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        return "Event{" +
                "ID='" + ID + '\'' +
                ", missionType=" + missionType +
                ", type=" + type +
                ", returning=" + returning +
                ", arrivalTime=" + arrivalTime +
                ", origin=" + origin +
                ", originCoordinate=" + originCoordinate +
                ", fleetDetails='" + fleetDetails + '\'' +
                ", destination=" + destination +
                ", destinationCoordinate=" + destinationCoordinate +
                '}';
    }
}
