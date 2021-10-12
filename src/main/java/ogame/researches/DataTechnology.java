package ogame.researches;

public enum DataTechnology {

    ENERGY_TECHOLOGY ("113",1, Type.BASIC),
    LASER_TECHOLOGY ("120",2, Type.BASIC),
    ION_TECHOLOGY ("121",3, Type.BASIC),
    HYPERSPACE_TECHOLOGY ("114",4, Type.BASIC),
    PLASMA_TECHOLOGY ("122",5, Type.BASIC),
    COMBUSTION_DRIVE_TECHOLOGY ("115",1, Type.DRIVE),
    IMPULSE_DRIVE_TECHOLOGY ("117",2, Type.DRIVE),
    HYPERSPACE_DRIVE_TECHOLOGY ("118",3, Type.DRIVE),
    ESPIONAGE_TECHOLOGY ("106",1, Type.ADVANCED),
    COMPUTER_TECHOLOGY ("108",2, Type.ADVANCED),
    ASTROPHYSICS_TECHOLOGY ("124",3, Type.ADVANCED),
    RESEARCH_NETWORK_TECHOLOGY ("123",4, Type.ADVANCED),
    GRAVITON_TECHOLOGY ("199",5, Type.ADVANCED),
    WEAPONS_TECHOLOGY ("109",1, Type.COMBAT),
    SHIELDING_TECHOLOGY ("110",2, Type.COMBAT),
    ARMOR_TECHOLOGY ("111",3, Type.COMBAT),
    UNDEFINED ("0",0, Type.BASIC);

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
