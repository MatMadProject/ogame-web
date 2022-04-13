package ogame.web.utils.watch;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Time {
    /**
     * PL
     * Aktualny czas w formacie hh:mm:ss.
     * EN
     * Actual time in format hh:mm:ss.
     * @return Actual time.
     */
    public static String get() {
        long currentDateTime = System.currentTimeMillis();
        Date currentDate = new Date(currentDateTime);
        SimpleDateFormat watchFormat = new SimpleDateFormat("HH:mm:ss");
        return watchFormat.format(currentDate);
    }

    /**
     * PL
     * Czas w formacie hh:mm:ss.
     * EN
     * Time in format hh:mm:ss.
     * @param milliSecTime Czas w milisekundach; Time in milliseconds.
     * @return Time.
     */
    public static String get(long milliSecTime) {
        Date currentDate = new Date(milliSecTime);
        SimpleDateFormat watchFormat = new SimpleDateFormat("HH:mm:ss");
        return watchFormat.format(currentDate);
    }

    /**
     * PL
     * Czas w formacie hh:mm:ss.
     * EN
     * Time in format hh:mm:ss.
     * @return Time.
     */
    public static String getFormattedFromSeconds(long timeInSeconds) {
        Duration duration = Duration.ofSeconds(timeInSeconds);
        long seconds = duration.getSeconds();
        long hh = seconds / 3600;
        long mm = (seconds % 3600) / 60;
        long ss = seconds % 60;

        return String.format("%02d:%02d:%02d", hh, mm, ss);
    }
}
