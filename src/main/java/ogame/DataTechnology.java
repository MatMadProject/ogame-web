package ogame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public enum DataTechnology {
    RESEARCH_LABORATORY ("31",3, Type.TECHNOLOGIES),
    //Researches
    ENERGY_TECHOLOGY ("113",1, Type.BASIC, new ArrayList<>(
            Collections.singletonList(new RequiredTechnology(1, RESEARCH_LABORATORY)))),
    LASER_TECHOLOGY ("120",2, Type.BASIC, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(1,RESEARCH_LABORATORY),
                    new RequiredTechnology(2,ENERGY_TECHOLOGY)))),
    ION_TECHOLOGY ("121",3, Type.BASIC, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(4,RESEARCH_LABORATORY),
                    new RequiredTechnology(4,ENERGY_TECHOLOGY),
                    new RequiredTechnology(5,LASER_TECHOLOGY)))),
    HYPERSPACE_TECHOLOGY ("114",4, Type.BASIC, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(7,RESEARCH_LABORATORY),
                    new RequiredTechnology(5,ENERGY_TECHOLOGY),
                    new RequiredTechnology(5,ION_TECHOLOGY)))),
    PLASMA_TECHOLOGY ("122",5, Type.BASIC, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(4,RESEARCH_LABORATORY),
                    new RequiredTechnology(8,ENERGY_TECHOLOGY),
                    new RequiredTechnology(10,LASER_TECHOLOGY),
                    new RequiredTechnology(5,ION_TECHOLOGY)))),
    COMBUSTION_DRIVE_TECHOLOGY ("115",1, Type.DRIVE, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(1,RESEARCH_LABORATORY),
                    new RequiredTechnology(1,ENERGY_TECHOLOGY)))),
    IMPULSE_DRIVE_TECHOLOGY ("117",2, Type.DRIVE, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(2,RESEARCH_LABORATORY),
                    new RequiredTechnology(1,ENERGY_TECHOLOGY)))),
    HYPERSPACE_DRIVE_TECHOLOGY ("118",3, Type.DRIVE, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(7,RESEARCH_LABORATORY),
                    new RequiredTechnology(3,HYPERSPACE_TECHOLOGY)))),
    ESPIONAGE_TECHOLOGY ("106",1, Type.ADVANCED, new ArrayList<>(
            Collections.singletonList(new RequiredTechnology(3, RESEARCH_LABORATORY)))),
    COMPUTER_TECHOLOGY ("108",2, Type.ADVANCED, new ArrayList<>(
            Collections.singletonList(new RequiredTechnology(1, RESEARCH_LABORATORY)))),
    ASTROPHYSICS_TECHOLOGY ("124",3, Type.ADVANCED, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(3,RESEARCH_LABORATORY),
                    new RequiredTechnology(4,ESPIONAGE_TECHOLOGY),
                    new RequiredTechnology(3,IMPULSE_DRIVE_TECHOLOGY)))),
    RESEARCH_NETWORK_TECHOLOGY ("123",4, Type.ADVANCED, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(10,RESEARCH_LABORATORY),
                    new RequiredTechnology(8,COMPUTER_TECHOLOGY),
                    new RequiredTechnology(8,HYPERSPACE_TECHOLOGY)))),
    GRAVITON_TECHOLOGY ("199",5, Type.ADVANCED, new ArrayList<>(
            Collections.singletonList(new RequiredTechnology(12, RESEARCH_LABORATORY)))),
    WEAPONS_TECHOLOGY ("109",1, Type.COMBAT,  new ArrayList<>(
            Collections.singletonList(new RequiredTechnology(4, RESEARCH_LABORATORY)))),
    SHIELDING_TECHOLOGY ("110",2, Type.COMBAT,  new ArrayList<>(
            Arrays.asList(new RequiredTechnology(6,RESEARCH_LABORATORY),
                    new RequiredTechnology(3,ENERGY_TECHOLOGY)))),
    ARMOR_TECHOLOGY ("111",3, Type.COMBAT, new ArrayList<>(
            Collections.singletonList(new RequiredTechnology(2, RESEARCH_LABORATORY)))),
    //Buildings
    METAL_MINE ("1",1, Type.PRODUCTION),
    CRYSTAL_MINE ("2",2,Type.PRODUCTION),
    DEUTERIUM_SYNTHESIZER ("3",3,Type.PRODUCTION),
    SOLAR_PLANT ("4",4,Type.PRODUCTION),
    METAL_STORAGE ("22",8,Type.PRODUCTION),
    CRYSTAL_STORAGE ("23",9,Type.PRODUCTION),
    DEUTERIUM_STORAGE ("24",10,Type.PRODUCTION),
    ROBOTICS_FACTORY ("14",1, Type.TECHNOLOGIES),
    SHIPYARD ("21",2, Type.TECHNOLOGIES, new ArrayList<>(
            Collections.singletonList(new RequiredTechnology(2, ROBOTICS_FACTORY)))),
    ALLIANCE_DEPOT ("34",4, Type.TECHNOLOGIES),
    MISSILE_SILO ("44",5, Type.TECHNOLOGIES,new ArrayList<>(
            Collections.singletonList(new RequiredTechnology(1, SHIPYARD)))),
    REPAIR_DOCK ("36",8, Type.TECHNOLOGIES, new ArrayList<>(
            Collections.singletonList(new RequiredTechnology(2, SHIPYARD)))),
    NANITE_FACTORY ("15",6, Type.TECHNOLOGIES, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(10,ROBOTICS_FACTORY),
                    new RequiredTechnology(10,COMPUTER_TECHOLOGY)))),
    TERRAFORMER ("33",7, Type.TECHNOLOGIES, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(1,NANITE_FACTORY),
                    new RequiredTechnology(12,ENERGY_TECHOLOGY)))),
    FUSION_PLANT ("12",5,Type.PRODUCTION, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(5,DEUTERIUM_SYNTHESIZER),
                    new RequiredTechnology(3,ENERGY_TECHOLOGY)))),
    SOLAR_SATELITE_B ("212",6,Type.PRODUCTION, new ArrayList<>(
            Collections.singletonList(new RequiredTechnology(1, SHIPYARD)))),
    RESBUGGY_B ("217",7,Type.PRODUCTION, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(5,SHIPYARD),
                    new RequiredTechnology(4,COMBUSTION_DRIVE_TECHOLOGY),
                    new RequiredTechnology(4,ARMOR_TECHOLOGY),
                    new RequiredTechnology(4,LASER_TECHOLOGY)))),
    //Ships
    FIGHTER_LIGHT("204",1, Type.BATTLE, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(1,SHIPYARD),
                    new RequiredTechnology(8,COMBUSTION_DRIVE_TECHOLOGY)))),
    FIGHTER_HEAVY("205",2,Type.BATTLE, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(2,SHIPYARD),
                    new RequiredTechnology(2,ARMOR_TECHOLOGY),
                    new RequiredTechnology(2,IMPULSE_DRIVE_TECHOLOGY)))),
    CRUISER("206",3,Type.BATTLE, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(5,SHIPYARD),
                    new RequiredTechnology(4,IMPULSE_DRIVE_TECHOLOGY),
                    new RequiredTechnology(2,ION_TECHOLOGY)))),
    BATTLE_SHIP("207",4,Type.BATTLE, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(7,SHIPYARD),
                    new RequiredTechnology(4,HYPERSPACE_DRIVE_TECHOLOGY)))),
    INTERCEPTOR("215",5,Type.BATTLE, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(8,SHIPYARD),
                    new RequiredTechnology(5,HYPERSPACE_TECHOLOGY),
                    new RequiredTechnology(5,HYPERSPACE_DRIVE_TECHOLOGY),
                    new RequiredTechnology(12,LASER_TECHOLOGY)))),
    BOMBER("211",6,Type.BATTLE, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(8,SHIPYARD),
                    new RequiredTechnology(6,IMPULSE_DRIVE_TECHOLOGY),
                    new RequiredTechnology(3,PLASMA_TECHOLOGY)))),
    DESTROYER("213",7,Type.BATTLE, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(9,SHIPYARD),
                    new RequiredTechnology(5,HYPERSPACE_TECHOLOGY),
                    new RequiredTechnology(6,HYPERSPACE_DRIVE_TECHOLOGY)))),
    DEATH_STAR("214",8,Type.BATTLE, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(12,SHIPYARD),
                    new RequiredTechnology(6,HYPERSPACE_TECHOLOGY),
                    new RequiredTechnology(7,HYPERSPACE_DRIVE_TECHOLOGY),
                    new RequiredTechnology(1,GRAVITON_TECHOLOGY)))),
    REAPER("218",9,Type.BATTLE, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(10,SHIPYARD),
                    new RequiredTechnology(6,HYPERSPACE_TECHOLOGY),
                    new RequiredTechnology(7,HYPERSPACE_DRIVE_TECHOLOGY),
                    new RequiredTechnology(6,SHIELDING_TECHOLOGY)))),
    EXPLORER("219",10,Type.BATTLE, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(5,SHIPYARD),
                    new RequiredTechnology(2,HYPERSPACE_DRIVE_TECHOLOGY),
                    new RequiredTechnology(4,SHIELDING_TECHOLOGY)))),
    TRANSPORTER_SMALL("202",1,Type.CIVIL, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(2,SHIPYARD),
                    new RequiredTechnology(2,COMBUSTION_DRIVE_TECHOLOGY)))),
    TRANSPORTER_LARGE("203",2,Type.CIVIL, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(4,SHIPYARD),
                    new RequiredTechnology(6,COMBUSTION_DRIVE_TECHOLOGY)))),
    COLONY_SHIP("208",3,Type.CIVIL, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(4,SHIPYARD),
                    new RequiredTechnology(3,IMPULSE_DRIVE_TECHOLOGY)))),
    RECYCLER("209",4,Type.CIVIL, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(4,SHIPYARD),
                    new RequiredTechnology(6,COMBUSTION_DRIVE_TECHOLOGY),
                    new RequiredTechnology(2, SHIELDING_TECHOLOGY)))),
    ESPIONAGE_PROBE("210",5,Type.CIVIL, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(3,SHIPYARD),
                    new RequiredTechnology(3,COMBUSTION_DRIVE_TECHOLOGY),
                    new RequiredTechnology(2,ESPIONAGE_TECHOLOGY)))),
    SOLAR_SATELITE ("212",6,Type.CIVIL, new ArrayList<>(
            Collections.singletonList(new RequiredTechnology(1, SHIPYARD)))),
    RESBUGGY ("217",7,Type.CIVIL, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(5,SHIPYARD),
                    new RequiredTechnology(4,COMBUSTION_DRIVE_TECHOLOGY),
                    new RequiredTechnology(4,ARMOR_TECHOLOGY),
                    new RequiredTechnology(4,LASER_TECHOLOGY)))),

    //DEFENCE
    ROCKET_LAUNCHER ("401",1,Type.DEFENCE, new ArrayList<>(
            Collections.singletonList(new RequiredTechnology(1, SHIPYARD)))),
    LASER_CANNON_LIGHT ("402",2,Type.DEFENCE, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(2,SHIPYARD),
                    new RequiredTechnology(1,ENERGY_TECHOLOGY),
                    new RequiredTechnology(3,LASER_TECHOLOGY)))),
    LASER_CANNON_HEAVY ("403",3,Type.DEFENCE, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(4,SHIPYARD),
                    new RequiredTechnology(3,ENERGY_TECHOLOGY),
                    new RequiredTechnology(6,LASER_TECHOLOGY)))),
    GAUSS_CANNON ("404",4,Type.DEFENCE, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(6,SHIPYARD),
                    new RequiredTechnology(6,ENERGY_TECHOLOGY),
                    new RequiredTechnology(3,WEAPONS_TECHOLOGY),
                    new RequiredTechnology(1,SHIELDING_TECHOLOGY)))),
    ION_CANNON ("405",5,Type.DEFENCE, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(4,SHIPYARD),
                    new RequiredTechnology(4,ION_TECHOLOGY)))),
    PLASMA_CANNON ("406",6,Type.DEFENCE, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(8,SHIPYARD),
                    new RequiredTechnology(7,PLASMA_TECHOLOGY)))),
    SHIELD_DOME_SMALL ("407",7,Type.DEFENCE, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(1,SHIPYARD),
                    new RequiredTechnology(2,SHIELDING_TECHOLOGY)))),
    SHIELD_DOME_LARGE ("408",8,Type.DEFENCE, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(6,SHIPYARD),
                    new RequiredTechnology(6,SHIELDING_TECHOLOGY)))),
    MISSILE_INTERCEPTOR ("502",9,Type.DEFENCE, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(1,SHIPYARD),
                    new RequiredTechnology(2,MISSILE_SILO)))),
    MISSILE_INTERPLANETARY ("503",10,Type.DEFENCE, new ArrayList<>(
            Arrays.asList(new RequiredTechnology(1,SHIPYARD),
                    new RequiredTechnology(3,MISSILE_SILO),
                    new RequiredTechnology(1,IMPULSE_DRIVE_TECHOLOGY)))),
    UNDEFINED("0",0,Type.BATTLE);

    private final String VALUE;
    private final int LIST_INDEX;
    private ArrayList<RequiredTechnology> requiredTechnologies;
    private final Type TYPE;

    DataTechnology(String VALUE, int LIST_INDEX, Type type) {
        this.VALUE = VALUE;
        this.LIST_INDEX = LIST_INDEX;
        TYPE = type;
    }

    DataTechnology(String VALUE, int LIST_INDEX, Type type, ArrayList<RequiredTechnology> requiredTechnologies) {
        this.VALUE = VALUE;
        this.LIST_INDEX = LIST_INDEX;
        TYPE = type;
        this.requiredTechnologies = requiredTechnologies;
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

    public ArrayList<RequiredTechnology> getRequiredTechnologies() {
        return requiredTechnologies;
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
