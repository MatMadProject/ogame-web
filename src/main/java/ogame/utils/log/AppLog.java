package ogame.utils.log;

import ogame.utils.StringFactory;
import ogame.utils.watch.*;

public class AppLog
{
    private final String className;
    private final String logText;
    private final String time;
    private static final int INFO_TYPE = 0;
    private static final int ERROR_TYPE = 1;
    private final static int LENGTH_OF_TYPE = 10;
    private final static int LENGTH_OF_CLASS = 50;
    private final static int LENGTH_OF_LOG = 150;
    private static boolean CONSOLE_PRINT = true;
    private static boolean [] TYPE_PRINT = {
            true, /*0*/
            true  /*1*/
    };

    public AppLog(String className, String logText) {
        this.className = className;
        this.logText =  logText;
        time = Calendar.getDateTime();
    }

    public AppLog(Class clas, String logText) {
        this.className =clas.getName();
        this.logText =  logText;
        time = Calendar.getDateTime();
    }

    public AppLog(String className, String logText, boolean error) {
        this.className = className;
        if(error)
            this.logText =  "ERROR " + logText;
        else
            this.logText =  logText;

        time = Calendar.getDateTime();
    }

    public String getClassName() {
        return className;
    }

    String getLogText() {
        return logText;
    }

    String getTime() {
        return time;
    }
    /**
     * PL
     * Nazwa typu loga.
     * EN
     * The name of log type.
     * @param type ***
     * @return ***
     */
    private  static String getType(int type){
        StringBuilder s = new StringBuilder();
        switch (type){
            case 0:
                s.append(StringFactory.init("INFO",LENGTH_OF_TYPE));
                break;
            case 1:
                s.append(StringFactory.init("ERROR",LENGTH_OF_TYPE));
                break;
            default:
                s.append(StringFactory.init("BAD TYPE",LENGTH_OF_TYPE));
                break;
        }
        return s.toString();
    }
    /**
     * PL
     * Indeks typu loga.
     * EN
     * The index of log type.
     * @param type ***
     * @return ***
     */
    private static int getType(String type){

        if(type.contains("INFO"))
            return INFO_TYPE;
        if(type.contains("ERROR"))
            return ERROR_TYPE;

        return -1;
    }
    /**
     * PL
     * Drukuje loga w konsoli.
     * EN
     * Prints log on console.
     * @param clas Klasa z której wywoływana jest metoda - max 50 znaków; The class where method is executed - max 50chars.
     * @param logText Tekst loga - max 150 znaków; Text log - max 150 chars.
     */
    public static void printOnConsole(Class clas, String logText){
        if(CONSOLE_PRINT){
            System.out.println(Calendar.getDateTime() + " " + StringFactory.init(clas.getName(),LENGTH_OF_CLASS) + " " +
                    StringFactory.init(logText,LENGTH_OF_LOG));
        }
    }
    /**
     * PL
     * Drukuje loga w konsoli.
     * EN
     * Prints log on console.
     * @param className Nazwa klasy z której wywoływana jest metoda - max 50 znaków; The class name where method is executed - max 50chars.
     * @param logText Tekst loga - max 150 znaków; Text log - max 150 chars.
     */
    public static void printOnConsole(String className, String logText){
        if(CONSOLE_PRINT){
            System.out.println(Calendar.getDateTime() + " " + StringFactory.init(className,LENGTH_OF_CLASS) + " " +
                    StringFactory.init(logText,LENGTH_OF_LOG));
        }
    }
    /**
     * PL
     * Sprawdza czy aktywne jest drukowanie loga o określonym typie.
     * EN
     * Checks printing of the described log type is active.
     * @param logType Typ loga. Log type.
     * @return True - if is active; False - if is not active or type does not exist.
     */
    private static boolean isTypeActiveToPrint(int logType){
        return logType <= TYPE_PRINT.length - 1 && TYPE_PRINT[logType];
    }
    /**
     * PL
     * Drukuje loga w konsoli.
     * EN
     * Prints log on console.
     * @param clas Klasa z której wywoływana jest metoda - max 50 znaków; The class where method is executed - max 50 chars.
     * @param logType Typ loga. Log type.
     * @param logText Tekst loga - max 150 znaków; Text log - max 150 chars.
     */
    public static void printOnConsole(Class clas, int logType, String logText){
        if(CONSOLE_PRINT && isTypeActiveToPrint(logType)){
            System.out.println(Calendar.getDateTime() + " " + StringFactory.init(getType(logType),LENGTH_OF_TYPE) + " " +
                    StringFactory.init(clas.getName(),LENGTH_OF_CLASS) + " " + StringFactory.init(logText,LENGTH_OF_LOG));
        }
    }

    /**
     * PL
     * Drukuje loga w konsoli.
     * EN
     * Prints log on console.
     * @param className Nazwa klasy z której wywoływana jest metoda - max 50 znaków; The class name where method is executed - max 50 chars.
     * @param logType Typ loga. Log type.
     * @param logText Tekst loga - max 150 znaków; Text log - max 150 chars.
     */
    public static void printOnConsole(String className, int logType, String logText){
        if(CONSOLE_PRINT && isTypeActiveToPrint(logType)){
            System.out.println(Calendar.getDateTime() + " " + StringFactory.init(getType(logType),LENGTH_OF_TYPE) + " " +
                    StringFactory.init(className,LENGTH_OF_CLASS) + " " + StringFactory.init(logText,LENGTH_OF_LOG));
        }
    }

    /**
     * PL
     * Drukuje loga w konsoli oraz dodaje log do pliku.
     * EN
     * Prints log on console and add to file.
     * @param className Nazwa klasy z której wywoływana jest metoda - max 50 znaków; The class name where method is executed - max 50 chars.
     * @param logType Typ loga. Log type.
     * @param logText Tekst loga - max 150 znaków; Text log - max 150 chars.
     */
    public static void print(String className, int logType, String logText){
        //todo Dodawanie do loga do pliku
//        if(CONSOLE_PRINT && isTypeActiveToPrint(logType)){
//            System.out.println(Calendar.getDateTime() + " " + StringFactory.init(getType(logType),LENGTH_OF_TYPE) + " " +
//                    StringFactory.init(clas.getName(),LENGTH_OF_CLASS) + " " + StringFactory.init(logText,LENGTH_OF_LOG));
//        }
        printOnConsole(className, logType,logText);
    }
}
