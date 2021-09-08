package ogame.buildings;

public enum DataTechnology {
    METAL_MINE (1,1),
    CRYSTAL_MINE (2,2),
    DEUTERIUM_SYNTHESIZER (3,3),
    SOLAR_PLANT (4,4),
    FUSION_PLANT (12,5),
    SOLAR_SATELITE (212,6),
    RESBUGGY (217,7),
    METAL_STORAGE (22,8),
    CRYSTAL_STORAGE (23,9),
    DEUTERIUM_STORAGE (24,10),
    UNDEFINED (0,0);

    private final int VALUE;
    private final int LIST_INDEX;

    DataTechnology(int VALUE, int LIST_INDEX) {
        this.VALUE = VALUE;
        this.LIST_INDEX = LIST_INDEX;
    }

    public int getValue() {
        return VALUE;
    }
    public int getListIndex() {
        return LIST_INDEX;
    }

    public static DataTechnology getFromValue(int value){
        for(DataTechnology dataTechnology : DataTechnology.values()){
            if(dataTechnology.getValue() == value)
                return dataTechnology;
        }
        return UNDEFINED;
//        switch (value){
//            case 1:
//                return METAL_MINE;
//            case 2:
//                return CRYSTAL_MINE;
//            case 3:
//                return DEUTERIUM_SYNTHESIZER;
//            case 4:
//                return SOLAR_PLANT;
//            case 12:
//                return FUSION_PLANT;
//            case 212:
//                return SOLAR_SATELITE;
//            case 217:
//                return RESBUGGY;
//            case 22:
//                return METAL_STORAGE;
//            case 23:
//                return CRYSTAL_STORAGE;
//            case 24:
//                return DEUTERIUM_STORAGE;
//            default:
//                return UNDEFINED;
//        }
    }

    public static DataTechnology getFromListIndex(int value){
        for(DataTechnology dataTechnology : DataTechnology.values()){
            if(dataTechnology.getListIndex() == value)
                return dataTechnology;
        }
        return UNDEFINED;
//        switch (value){
//            case 1:
//                return METAL_MINE;
//            case 2:
//                return CRYSTAL_MINE;
//            case 3:
//                return DEUTERIUM_SYNTHESIZER;
//            case 4:
//                return SOLAR_PLANT;
//            case 5:
//                return FUSION_PLANT;
//            case 6:
//                return SOLAR_SATELITE;
//            case 7:
//                return RESBUGGY;
//            case 8:
//                return METAL_STORAGE;
//            case 9:
//                return CRYSTAL_STORAGE;
//            case 10:
//                return DEUTERIUM_STORAGE;
//            default:
//                return UNDEFINED;
//        }
    }
}
