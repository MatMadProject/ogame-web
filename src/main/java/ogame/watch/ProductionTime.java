package ogame.watch;

import java.io.Serializable;

public class ProductionTime implements Serializable {

    private static final long serialVersionUID = 1992L;
    private int seconds;
    private int minutes;
    private int hours;
    private int days;
    private final String DATETIME;

    public ProductionTime(String datetime){
        this.DATETIME = datetime;

        if(datetime.contains("D")){
            String [] tab = datetime.split("T");
            days = Integer.parseInt(tab[0].replace("D","").replace("P",""));
            tab = tab[1].split("H");
            hours = Integer.parseInt(tab[0]);
            tab = tab[1].split("M");
            minutes = Integer.parseInt(tab[0]);
            seconds = Integer.parseInt(tab[1].replace("S",""));
        }
        else if(datetime.contains("H")){
            String [] tab = datetime.split("T");
            tab = tab[1].split("H");
            hours = Integer.parseInt(tab[0]);
            tab = tab[1].split("M");
            minutes = Integer.parseInt(tab[0]);
            seconds = Integer.parseInt(tab[1].replace("S",""));
        }
        else if(datetime.contains("M")){
            String [] tab = datetime.split("T");
            tab = tab[1].split("M");
            minutes = Integer.parseInt(tab[0]);
            seconds = Integer.parseInt(tab[1].replace("S",""));
        }
        else{
            String [] tab = datetime.split("T");
            seconds = Integer.parseInt(tab[1].replace("S",""));
        }

    }

    public long timeInSeconds(){
        return seconds + minutes * 60L + (long) hours * 60 * 60 + (long) days * 24 * 60 * 60;
    }

    public String time(){
        return days + ":" + hours + ":" + minutes + ":" + seconds;
    }

    @Override
    public String toString() {
        return "ProductionTime{" +
                "seconds=" + seconds +
                ", minutes=" + minutes +
                ", hours=" + hours +
                ", days=" + days +
                ", DATETIME='" + DATETIME + '\'' +
                '}';
    }
}
