package ogame.utils.watch;

public class Timer {
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
}
