package ogame.galaxy;

import ogame.planets.Coordinate;

public class GalaxyRow {
    private Coordinate coordinate;
    private String planetName;
    private boolean hasMoon;
    private boolean hasDebris;
    private Debris debris;
    private ActiveAlert activeAlertPlanet;
    private ActiveAlert activeAlertMoon;
    private String playerName;
    private String playerId;
    private String allianceName;
    private String allianceId;
    private HonorRank honorRank;
    private PlayerStatus playerStatus;

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public boolean isHasMoon() {
        return hasMoon;
    }

    public void setHasMoon(boolean hasMoon) {
        this.hasMoon = hasMoon;
    }

    public boolean isHasDebris() {
        return hasDebris;
    }

    public void setHasDebris(boolean hasDebris) {
        this.hasDebris = hasDebris;
    }

    public Debris getDebris() {
        return debris;
    }

    public void setDebris(Debris debris) {
        this.debris = debris;
    }

    public ActiveAlert getActiveAlertPlanet() {
        return activeAlertPlanet;
    }

    public void setActiveAlertPlanet(ActiveAlert activeAlertPlanet) {
        this.activeAlertPlanet = activeAlertPlanet;
    }

    public ActiveAlert getActiveAlertMoon() {
        return activeAlertMoon;
    }

    public void setActiveAlertMoon(ActiveAlert activeAlertMoon) {
        this.activeAlertMoon = activeAlertMoon;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getAllianceName() {
        return allianceName;
    }

    public void setAllianceName(String allianceName) {
        this.allianceName = allianceName;
    }

    public String getAllianceId() {
        return allianceId;
    }

    public void setAllianceId(String allianceId) {
        this.allianceId = allianceId;
    }

    public HonorRank getHonorRank() {
        return honorRank;
    }

    public void setHonorRank(HonorRank honorRank) {
        this.honorRank = honorRank;
    }

    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

    @Override
    public String toString() {
        return "GalaxyRow{" +
                "coordinate=" + coordinate +
                ", planetName='" + planetName + '\'' +
                ", hasMoon=" + hasMoon +
                ", hasDebris=" + hasDebris +
                ", debris=" + debris +
                ", activeAlertPlanet=" + activeAlertPlanet +
                ", activeAlertMoon=" + activeAlertMoon +
                ", playerName='" + playerName + '\'' +
                ", playerId='" + playerId + '\'' +
                ", allianceName='" + allianceName + '\'' +
                ", allianceId='" + allianceId + '\'' +
                ", honorRank=" + honorRank +
                ", playerStatus=" + playerStatus +
                '}';
    }
}
