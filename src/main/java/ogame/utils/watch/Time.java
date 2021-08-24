package ogame.utils.watch;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
    /**
     * PL
     * Aktualny czas w formacie hh:mm:ss.
     * EN
     * Actual time in format hh:mm:ss.
     * @return Actual time.
     */
    public static String get()
    {
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
    public static String get(long milliSecTime)
    {
        Date currentDate = new Date(milliSecTime);
        SimpleDateFormat watchFormat = new SimpleDateFormat("HH:mm:ss");
        return watchFormat.format(currentDate);
    }
}
