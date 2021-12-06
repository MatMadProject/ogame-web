package ogame.ships;

public enum Mission {
    EXPEDITION(1),
    COLONIZE(2),
    COLLECT_DEBRIS(3),
    TRANSPORT(4),
    STATION(5),
    SPY(6),
    STOP(7),
    ATTACK(8),
    RELATIONSHIP_ATTACK(9),
    DESTROYE(10),
    UNDEFINED(0);
    private final int LIST_INDEX;

    Mission(int LIST_INDEX){
        this.LIST_INDEX = LIST_INDEX;
    }

    public int getListIndex() {
        return LIST_INDEX;
    }

    public static Mission getFromListIndex(int value){
        for(Mission mission : Mission.values()){
            if(mission.getListIndex() == value)
                return mission;
        }
        return UNDEFINED;
    }
}
