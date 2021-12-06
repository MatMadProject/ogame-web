package ogame.ships;


public enum DataTechnology {

    FIGHTER_LIGHT("204",1,Type.BATTLE),
    FIGHTER_HEAVY("205",2,Type.BATTLE),
    CRUISER("205",3,Type.BATTLE),
    BATTLE_SHIP("206",4,Type.BATTLE),
    INTERCEPTOR("215",5,Type.BATTLE),
    BOMBER("211",6,Type.BATTLE),
    DESTROYER("213",7,Type.BATTLE),
    DEATH_STAR("214",8,Type.BATTLE),
    REAPER("218",9,Type.BATTLE),
    EXPLORER("219",10,Type.BATTLE),
    TRANSPORTER_SMALL("202",1,Type.CIVIL),
    TRANSPORTER_LARGE("203",2,Type.CIVIL),
    COLONY_SHIP("208",3,Type.CIVIL),
    RECYCLER("209",4,Type.CIVIL),
    ESPIONAGE_PROBE("210",5,Type.CIVIL),
    UNDEFINED("0",0,Type.BATTLE);

    private final String VALUE;
    private final int LIST_INDEX;
    private final Type TYPE;

    DataTechnology(String VALUE, int LIST_INDEX, Type type) {
        this.VALUE = VALUE;
        this.LIST_INDEX = LIST_INDEX;
        TYPE = type;
    }

    public String getValue() {
        return VALUE;
    }
    public int getListIndex() {
        return LIST_INDEX;
    }

    public Type getType() {
        return TYPE;
    }

    public static DataTechnology getFromValue(String value){
        for(DataTechnology dataTechnology : DataTechnology.values()){
            if(dataTechnology.getValue().equals(value))
                return dataTechnology;
        }
        return UNDEFINED;
    }

    public static DataTechnology getFromListIndex(int value){
        for(DataTechnology dataTechnology : DataTechnology.values()){
            if(dataTechnology.getListIndex() == value)
                return dataTechnology;
        }
        return UNDEFINED;
    }
}
