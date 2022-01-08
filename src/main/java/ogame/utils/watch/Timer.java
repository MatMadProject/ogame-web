package ogame.utils.watch;

import java.io.Serializable;
import java.time.Duration;

public class Timer implements Serializable {

    private static final long serialVersionUID = 1992L;
    private final long startDate;
    private long finishDate;
    private long timeInMiliseconds;

    public Timer(long startDate, long finishDate) {
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public long getStartDate() {
        return startDate;
    }

    public long getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(long finishDate) {
        this.finishDate = finishDate;
    }

    public long getTimeInMiliseconds() {
        return timeInMiliseconds;
    }

    public void setTimeInMiliseconds(long timeInMiliseconds) {
        this.timeInMiliseconds = timeInMiliseconds;
    }

    public boolean isTimeLeft(long currentTime){
        return currentTime > finishDate;
    }

    public long timeLeftInSeconds(long currentTime){
        if(finishDate == 0){
            return ((startDate + timeInMiliseconds) - currentTime)/1000;
        }

        return (finishDate - currentTime)/1000;
    }
    public static long timeMilliseconds(long timeMillisecnods, long timeMillisecnods2){
        return timeMillisecnods - timeMillisecnods2;
    }
    public static long timeSeconds(long timeSecnods, long timeSecnods2){
        return timeSecnods - timeSecnods2;
    }

    public String leftTime(){
        Duration duration = Duration.ofMillis(finishDate - System.currentTimeMillis());
        long seconds = duration.getSeconds();
        long hh = seconds / 3600;
        long mm = (seconds % 3600) / 60;
        long ss = seconds % 60;

        return String.format("%02d:%02d:%02d", hh, mm, ss);
    }
}
