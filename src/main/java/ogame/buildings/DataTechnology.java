package ogame.buildings;

public enum DataTechnology {
    METAL_MINE ("1",1),
    CRYSTAL_MINE ("2",2),
    DEUTERIUM_SYNTHESIZER ("3",3),
    SOLAR_PLANT ("4",4),
    FUSION_PLANT ("12",5),
    SOLAR_SATELITE ("212",6),
    RESBUGGY ("217",7),
    METAL_STORAGE ("22",8),
    CRYSTAL_STORAGE ("23",9),
    DEUTERIUM_STORAGE ("24",10),
    ROBOTICS_FACTORY ("14",1),
    SHIPYARD ("21",2),
    RESEARCH_LABORATORY ("31",3),
    ALLIANCE_DEPOT ("341",4),
    MISSILE_SILO ("44",5),
    NANITE_FACTORY ("25",6),
    TERRAFORMER ("33",7),
    REPAIR_DOCK ("36",8),
    UNDEFINED ("0",0);

    private final String VALUE;
    private final int LIST_INDEX;

    DataTechnology(String VALUE, int LIST_INDEX) {
        this.VALUE = VALUE;
        this.LIST_INDEX = LIST_INDEX;
    }

    public String getValue() {
        return VALUE;
    }
    public int getListIndex() {
        return LIST_INDEX;
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
