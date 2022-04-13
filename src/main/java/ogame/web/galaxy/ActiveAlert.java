package ogame.web.galaxy;

import ogame.web.utils.watch.Calendar;

public class ActiveAlert {

    private final int ALERT_TIME_IN_MINUTES;
    private final long timeStampInMilliseconds;

    public ActiveAlert(int alertTime) {
        this.ALERT_TIME_IN_MINUTES = alertTime;
        timeStampInMilliseconds = System.currentTimeMillis();
    }

    public int getActiveTime() {
        return ALERT_TIME_IN_MINUTES;
    }

    public long getTimeStampInMilliseconds() {
        return timeStampInMilliseconds;
    }

    @Override
    public String toString() {
        return "ActiveAlert{" +
                "alertTimeInMinutes=" + ALERT_TIME_IN_MINUTES +
                ", timeStampInMilliseconds=" + Calendar.getDateTimeSQL(timeStampInMilliseconds) +
                '}';
    }
}
