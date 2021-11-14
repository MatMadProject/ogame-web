package ogame.buildings;

import ogame.planets.Type;

import java.io.Serializable;

public enum DataTechnology implements Serializable {
    METAL_MINE ("1",1,Type.PRODUCTION),
    CRYSTAL_MINE ("2",2,Type.PRODUCTION),
    DEUTERIUM_SYNTHESIZER ("3",3,Type.PRODUCTION),
    SOLAR_PLANT ("4",4,Type.PRODUCTION),
    FUSION_PLANT ("12",5,Type.PRODUCTION),
    SOLAR_SATELITE ("212",6,Type.PRODUCTION),
    RESBUGGY ("217",7,Type.PRODUCTION),
    METAL_STORAGE ("22",8,Type.PRODUCTION),
    CRYSTAL_STORAGE ("23",9,Type.PRODUCTION),
    DEUTERIUM_STORAGE ("24",10,Type.PRODUCTION),
    ROBOTICS_FACTORY ("14",1, Type.TECHNOLOGIES),
    SHIPYARD ("21",2, Type.TECHNOLOGIES),
    RESEARCH_LABORATORY ("31",3, Type.TECHNOLOGIES),
    ALLIANCE_DEPOT ("341",4, Type.TECHNOLOGIES),
    MISSILE_SILO ("44",5, Type.TECHNOLOGIES),
    NANITE_FACTORY ("25",6, Type.TECHNOLOGIES),
    TERRAFORMER ("33",7, Type.TECHNOLOGIES),
    REPAIR_DOCK ("36",8, Type.TECHNOLOGIES),
    UNDEFINED ("0",0, Type.TECHNOLOGIES);

    private static final long serialVersionUID = 1992L;
    private final String VALUE;
    private final int LIST_INDEX;
    private final Type TYPE;

    DataTechnology(String VALUE, int LIST_INDEX, Type type) {
        this.VALUE = VALUE;
        this.LIST_INDEX = LIST_INDEX;
        this.TYPE = type;
    }

    public String getValue() {
        return VALUE;
    }

    public Type getType() {
        return TYPE;
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
