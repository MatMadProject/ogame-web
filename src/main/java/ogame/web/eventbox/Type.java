package ogame.web.eventbox;

import java.io.Serializable;

public enum Type implements Serializable {

    FRIENDLY("friendly"),
    HOSTILE("hostile"),
    UNDEFINED("undefined");

    private static final long serialVersionUID = 1992L;
    private final String value;
    Type(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Type getFromValue(String value){
        for(Type type : Type.values()){
            if(type.getValue().equals(value))
                return type;
        }
        return UNDEFINED;
    }
}
