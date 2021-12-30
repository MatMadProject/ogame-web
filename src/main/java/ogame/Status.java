package ogame;

import java.io.Serializable;

public enum Status implements Serializable {

    UNDEFINED("undefined",-1),
    ACTIVE("active",0),
    DISABLED ("disabled",1),
    OFF ("off",2),
    ON ("on",3);

    private static final long serialVersionUID = 1992L;
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
        for(Status status : Status.values()){
            if(status.getID() == id)
                return status;
        }
        return UNDEFINED;
    }

    public static Status getStatus(String name){
        for(Status status : Status.values()){
            if(status.getName().equals(name))
                return status;
        }
        return UNDEFINED;
    }
}
