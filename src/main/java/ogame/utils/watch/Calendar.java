package ogame.utils.watch;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Calendar {
    /**
     * PL
     * Aktualny czas i data w formacie dd.mm.yyyy hh:mm:ss.
     * EN
     * Actual time and date in format dd.mm.yyyy hh:mm:ss.
     * @return Actual time and date.
     */
    public static String getDateTime() {
        return Date.get()+" "+Time.get();
    }

    /**
     * PL
     * Aktualny czas i data w formacie dd.mm.yyyy hh:mm:ss.
     * EN
     * Actual time and date in format dd.mm.yyyy hh:mm:ss.
     * @return Actual time and date.
     */
    public static String getDateTime(long milisecTime) {

        return Date.get(milisecTime)+" "+Time.get(milisecTime);
    }
    /**
     * PL
     * Aktualny czas i data w formacie dd.mm.yyyy hh:mm:ss.
     * EN
     * Actual time and date in format dd.mm.yyyy hh:mm:ss.
     * @return Actual time and date.
     */
    public static String getDateTimeSQL() {
        return Date.getSQL()+" "+Time.get();
    }

    /**
     * PL
     * Aktualny czas i data w formacie dd.mm.yyyy hh:mm:ss.
     * EN
     * Actual time and date in format dd.mm.yyyy hh:mm:ss.
     * @return Actual time and date.
     */
    public static String getDateTimeSQL(long milisecTime) {
        return Date.getSQL(milisecTime)+" "+Time.get(milisecTime);
    }
    /**
     * EN
     * @param dateTimeSQLFormatted Date in format yyyy-mm-dd hh:mm:ss.
     * @return Time in milliseconds from formatted String.
     */
    public static long getDateTimeInMilliseconds(String dateTimeSQLFormatted) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");

        return sdf.parse(dateTimeSQLFormatted).getTime();
    }
}
