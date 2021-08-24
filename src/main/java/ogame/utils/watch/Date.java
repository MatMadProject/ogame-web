package ogame.utils.watch;

import java.text.SimpleDateFormat;

public class Date
{
    /**
     * PL
     * Aktualnd data w formacie dd.MM.yyyy.
     * EN
     * Actual date in format dd.MM.yyyy.
     * @return Actual date.
     */
    public static String get()
    {
        long currentDateTime = System.currentTimeMillis();
        java.util.Date currentDate = new java.util.Date(currentDateTime);
        SimpleDateFormat watchFormat = new SimpleDateFormat("dd.MM.yyyy");
        return watchFormat.format(currentDate);
    }

    /**
     * PL
     * Aktualnd data w formacie yyyy.MM.dd.
     * EN
     * Actual date in format yyyy.MM.dd.
     * @return Actual date.
     */
    public static String getSQL()
    {
        long currentDateTime = System.currentTimeMillis();
        java.util.Date currentDate = new java.util.Date(currentDateTime);
        SimpleDateFormat watchFormat = new SimpleDateFormat("yyyy.MM.dd");
        return watchFormat.format(currentDate);
    }

    /**
     * PL
     * Date w formacie dd.MM.yyyy.
     * EN
     * Date in format dd.MM.yyyy.
     * @param milliSecTime Czas w milisekundach; Time in milliseconds.
     * @return Date.
     */
    public static String get(long milliSecTime)
    {
        java.util.Date currentDate = new java.util.Date(milliSecTime);
        SimpleDateFormat watchFormat = new SimpleDateFormat("dd.MM.yyyy");
        return watchFormat.format(currentDate);
    }
}
