package ogame;

public enum Status {
    UNDEFINED("undefined",-1),
    ACTIVE("active",0),
    DISABLED ("disabled",1),
    OFF ("off",2),
    ON ("on",3);

    private final String NAME;
    private final int ID;

    Status(String name, int id) {
        this.NAME = name;
        this.ID = id;
    }

    public String getName() {
        return NAME;
    }

    public int getID() {
        return ID;
    }

    public static Status getStatus(int id){
        switch (id){
            case 0:
                return ACTIVE;
            case 1:
                return DISABLED;
            case 2:
                return OFF;
            case 3:
                return ON;
            default:
                return UNDEFINED;
        }
    }

    public static Status getStatus(String name){
        switch (name){
            case "active":
                return ACTIVE;
            case "disabled":
                return DISABLED;
            case "off":
                return OFF;
            case "on":
                return ON;
            default:
                return UNDEFINED;
        }
    }
}
