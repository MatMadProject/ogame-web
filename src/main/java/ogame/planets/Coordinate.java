package ogame.planets;

import java.io.Serializable;
import java.util.Objects;

public class Coordinate implements Serializable {

    private static final long serialVersionUID = 1992L;
    private int galaxy;
    private int system;
    private int planet;

    public Coordinate(String text) {

        StringBuilder sb = new StringBuilder(text);

        int a = sb.indexOf(":");
        int b = sb.lastIndexOf(":");
        int l = sb.length();

        galaxy = Integer.parseInt(sb.substring(1,a));
        system = Integer.parseInt(sb.substring(a+1,b));
        planet = Integer.parseInt(sb.substring(b+1,l-1));
    }

    public Coordinate(int galaxy, int system, int planet) {
        this.galaxy = galaxy;
        this.system = system;
        this.planet = planet;
    }

    /*
    SETTERS
     */

    public void setGalaxy(int galaxy) {
        this.galaxy = galaxy;
    }

    public void setSystem(int system) {
        this.system = system;
    }

    public void setPlanet(int planet) {
        this.planet = planet;
    }
    /*
    GETTERS
     */

    public String getText() {
        return "["+galaxy+":"+system+":"+planet+"]";
    }

    public int getGalaxy() {
        return galaxy;
    }

    public int getSystem() {
        return system;
    }

    public int getPlanet() {
        return planet;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "galaxy=" + galaxy +
                ", system=" + system +
                ", planet=" + planet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return galaxy == that.galaxy && system == that.system && planet == that.planet;
    }

    @Override
    public int hashCode() {
        return Objects.hash(galaxy, system, planet);
    }
}
