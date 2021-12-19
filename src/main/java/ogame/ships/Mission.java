package ogame.ships;

public enum Mission {
    EXPEDITION(1,15),
    COLONIZE(2,7),
    COLLECT_DEBRIS(3,8),
    TRANSPORT(4, 3),
    STATION(5,4),
    SPY(6,6),
    STOP(7),
    ATTACK(8,1),
    RELATIONSHIP_ATTACK(9),
    DESTROYE(10),
    UNDEFINED(0,0);
    private final int LIST_INDEX;
    private int DATA_MISSION_TYPE;

    Mission(int LIST_INDEX){
        this.LIST_INDEX = LIST_INDEX;
    }

    Mission(int LIST_INDEX, int DATA_MISSION_TYPE){
        this.LIST_INDEX = LIST_INDEX;
        this.DATA_MISSION_TYPE = DATA_MISSION_TYPE;
    }

    public int getListIndex() {
        return LIST_INDEX;
    }

    public int getDATA_MISSION_TYPE() {
        return DATA_MISSION_TYPE;
    }

    public static Mission getFromListIndex(int value){
        for(Mission mission : Mission.values()){
            if(mission.getListIndex() == value)
                return mission;
        }
        return UNDEFINED;
    }

    public static Mission getFromDataMissionType(int value){
        for(Mission mission : Mission.values()){
            if(mission.getDATA_MISSION_TYPE() == value)
                return mission;
        }
        return UNDEFINED;
    }
}
