package ogame.planets;

public class Coordinate {
    private String text;
    private int galaxy;
    private int system;
    private int planet;

    public Coordinate(String text) {
        this.text = text;

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
        text = "["+galaxy+":"+system+":"+planet+"]";
    }

    /*
    SETTERS
     */
    public void setText(String text) {
        this.text = text;
    }

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
        return text;
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
                "text='" + text + '\'' +
                ", galaxy=" + galaxy +
                ", system=" + system +
                ", planet=" + planet +
                '}';
    }
}
