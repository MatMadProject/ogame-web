package ogame;

import java.util.ArrayList;

public enum DataTechnology {
    //Buildings
    METAL_MINE ("1",1, Type.PRODUCTION),
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
    //Researches
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
    //Ships
    FIGHTER_LIGHT("204",1, Type.BATTLE),
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

    public static DataTechnology getFromListIndex(int value, Type type){
        for(DataTechnology dataTechnology : dataTechnologyList(type)){
            if(dataTechnology.getListIndex() == value && dataTechnology.getType() == type)
                return dataTechnology;
        }
        return UNDEFINED;
    }

    public static ArrayList<DataTechnology> dataTechnologyList(Type type){
        ArrayList<DataTechnology> list = new ArrayList<>();
        for(DataTechnology dataTechnology : DataTechnology.values()){
            if(dataTechnology.getType() == type)
               list.add(dataTechnology);
        }
        return list;
    }
}
