package ogame.utils;

public class WebElementPath {
    private final String openFinal;
    private final String closeFinal;
    private String edit;

    public WebElementPath(String openFinal, String closeFinal, String edit) {
        this.openFinal = openFinal;
        this.closeFinal = closeFinal;
        this.edit = edit;
    }

    public WebElementPath(String openFinal, String closeFinal) {
        this.openFinal = openFinal;
        this.closeFinal = closeFinal;
    }

    public void setEdit(String edit) {
        this.edit = edit;
    }

    public void setEdit(int edit) {
        this.edit = String.valueOf(edit);
    }

    public String get(){
        return openFinal+edit+closeFinal;
    }
}
