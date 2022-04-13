package ogame.web.tabs;

import ogame.web.FinalXPath;
import ogame.web.utils.StringFactory;
import ogame.web.utils.log.AppLog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Zakladka Podgląd. Overview tab.
 * @version 1.1 - 05.2021
 */
public class Overview
{
    private static final String DIAMETER_PLANET_CONTENT = "//*[@id=\"diameterContentField\"]";
    private static final String TEMPERATURE_PLANET_CONTENT = "//*[@id=\"temperatureContentField\"]";
    private static final String SCORE_CONTENT = "//*[@id=\"scoreContentField\"]";
    private static final String HONOR_CONTENT = "//*[@id=\"honorContentField\"]";
    private static final String OVERVIEW_COMPONENT_ID = "overviewcomponent";
    private static final String OVERVIEW_BUTTON = "//*[@id=\"menuTable\"]/li[1]/a";
    private static final String COORDINATE = "//*[@id=\"positionContentField\"]/a";

    /**
     * Sprawdza czy jest widoczna zakladka Podgląd.
     * Checks that the preview tab is visible.
     * @param w ***
     * @return Jeżeli widoczna - true. If is visible - true.
     */
    public static boolean visible(WebDriver w) {
        try{
            //Sprawdzenie 1
            WebElement e =  w.findElement(By.xpath(OVERVIEW_BUTTON));
            String s = e.getAttribute("class");
            if(s.contains("selected"))
                return true;
            //Sprawdzenie 2
            e =  w.findElement(By.xpath(FinalXPath.MIDDLE_COMPONENT+"/div[2]"));
            s = e.getAttribute("id");
            return s.contains(OVERVIEW_COMPONENT_ID);
        }
        catch (Exception e){
            AppLog.printOnConsole(Overview.class.getName(),1,"When it checks, the tab is visible.");
        }
        return false;
    }

    /**
     * Klika w zakładkę.
     * Clicks on tab.
     * @param w ***
     * @return Zwróci true, jeżeli kliknie poprawnie. If click with success returns true.
     */
    public static boolean click(WebDriver w){
        try{
            if(visible(w)){ return true;
            }

            WebElement e =  w.findElement(By.xpath(OVERVIEW_BUTTON));
            e.click();
            return true;
        }
        catch (Exception e){
            AppLog.printOnConsole(Overview.class.getName(),1,"While trying to click on a tab.");
        }
        return false;
    }
    public static boolean clickAlways(WebDriver w){
        try{
            WebElement e =  w.findElement(By.xpath(OVERVIEW_BUTTON));
            e.click();
            return true;
        }
        catch (Exception e){
            AppLog.printOnConsole(Overview.class.getName(),1,"While trying to click on a tab.");
        }
        return false;
    }

    /**
     * Pobiera średnicę planety. Downloads the diameter of planet.
     * @param w ***
     * @return Zwroci -1 jeżeli wystąpi błąd. Returns -1 if errors execute.
     */
    public static int planetDiameter(WebDriver w) {
        if(visible(w)) {
            try {
                WebElement e =  w.findElement(By.xpath(DIAMETER_PLANET_CONTENT));
                String s = e.getText().split(" ")[0].replace("k","").replace("m","").replace(".","");
                return Integer.parseInt(s);
            }
            catch (Exception e) {
                AppLog.printOnConsole(Overview.class.getName(),1,"Doesn't download diameter of planet.");
            }
        }
        return -1;
    }

    /**
     * Pobiera zajętę pola na planecie. Download a built up fields of planet.
     * @param w ***
     * @return Zwroci -1 jeżeli wystąpi błąd. Returns -1 if errors execute.
     */
    public static int builtUpFields(WebDriver w) {
        if(visible(w)) {
            try {
                WebElement e =  w.findElement(By.xpath(DIAMETER_PLANET_CONTENT));
                String s = e.getText().split(" ")[1].split("/")[0].replace("(","");
                return Integer.parseInt(s);
            }
            catch (Exception e) {
                AppLog.printOnConsole(Overview.class.getName(),1,"Doesn't download built up fields of planet.");
            }
        }
        return -1;
    }

    /**
     * Pobiera maksymalną ilość pól na planecie. Downloads a maximum fields of planet.
     * @param w ***
     * @return Zwroci -1 jeżeli wystąpi błąd. Returns -1 if errors execute.
     */
    public static int maxPlanetFields(WebDriver w) {
        if(visible(w)) {
            try {
                WebElement e =  w.findElement(By.xpath(DIAMETER_PLANET_CONTENT));
                String s = e.getText().split(" ")[1].split("/")[1].replace(")","");
                return Integer.parseInt(s);
            }
            catch (Exception e) {
                AppLog.printOnConsole(Overview.class.getName(),1,"Doesn't download maximum fields of planet.");
            }
        }
        return -1;
    }

    /**
     * Pobiera minimalną temperaturę na planecie. Downloads a minimum temperature of planet.
     * @param w ***
     * @return Zwroci -1 jeżeli wystąpi błąd. Returns -1 if errors execute.
     */
    public static int minTemperature(WebDriver w) {
        if(visible(w)) {
            try {
                WebElement e =  w.findElement(By.xpath(TEMPERATURE_PLANET_CONTENT));
                String [] tab = e.getText().split(" ");
                for(String s : tab){
                    if(StringFactory.isDigit(s))
                        return Integer.parseInt(s);
                }
            }
            catch (Exception e) {
                AppLog.printOnConsole(Overview.class.getName(),1,"Doesn't download minimum temperature of planet.");
            }
        }
        return -1;
    }

    /**
     * Pobiera maksymalną temperaturę na planecie. Downloads a maximum temperature of planet.
     * @param w ***
     * @return Zwroci -1 jeżeli wystąpi błąd. Returns -1 if errors execute.
     */
    public static int maxTemperature(WebDriver w) {
        if(visible(w)) {
            try {
                WebElement e =  w.findElement(By.xpath(TEMPERATURE_PLANET_CONTENT));
                String [] tab = e.getText().split(" ");
                for(int i = 2; i < tab.length; i++){
                    if(StringFactory.isDigit(tab[i]))
                        return Integer.parseInt(tab[i]);
                }

            }
            catch (Exception e){
                AppLog.printOnConsole(Overview.class.getName(),1,"Doesn't download maximum temperature of planet.");
            }
        }
        return -1;
    }

    /**
     * Pobiera współrzędne planety.
     * Downloads coordinate of planet.
     * @param w ***
     * @return Zwroci -1 jeżeli wystąpi błąd. Returns -1 if errors execute.
     */
    public static String coordinate(WebDriver w) {
        if(visible(w)) {
            try {
                WebElement e =  w.findElement(By.xpath(COORDINATE));

                return e.getText();
            }
            catch (Exception e) {
                AppLog.printOnConsole(Overview.class.getName(),1,"Doesn't download coordinate of planet.");
            }
        }
        return "[0:000:00]";
    }

    /**
     * Pobiera ilość punktów gracza. Downloads a player points.
     * @param w ***
     * @return Zwroci -1 jeżeli wystąpi błąd. Returns -1 if errors execute.
     */
    public static int points(WebDriver w) {
        if(visible(w)) {
            try {
                WebElement e =  w.findElement(By.xpath(SCORE_CONTENT));
                String s = e.getText().split(" ")[0].replace(".","");
                return Integer.parseInt(s);
            }
            catch (Exception e) {
                AppLog.printOnConsole(Overview.class.getName(),1,"Doesn't download value of player points.");
            }
        }
        return -1;
    }

    /**
     * Pobiera miejsce gracza w statystykach. Downloads a player positon.
     * @param w ***
     * @return Zwroci -1 jeżeli wystąpi błąd. Returns -1 if errors execute.
     */
    public static int position(WebDriver w) {
        if(visible(w)) {
            try {
                WebElement e =  w.findElement(By.xpath(SCORE_CONTENT));
                String s = e.getText().split(" ")[2];
                //Pozycja 1.000 i niższa.
                if(s.length() > 3)
                    s = s.replace(".","");

                return Integer.parseInt(s);
            }
            catch (Exception e) {
                AppLog.printOnConsole(Overview.class.getName(),1,"Doesn't download value of player position.");
            }
        }
        return -1;
    }

    /**
     * Pobiera ilość punktów honoru.
     * Downloads value of player honor points.
     * @param w ***
     * @return Zwroci -1 jeżeli wystąpi błąd. Returns -1 if errors execute.
     */
    public static int honorPoints(WebDriver w) {
        if(visible(w)) {
            try {
                WebElement e =  w.findElement(By.xpath(HONOR_CONTENT));
                String s = e.getText();
                //Ilość mniejsza niż -1000 lub większa niż 1000.
                if(s.length() > 3)
                    s = s.replace(".","");

                return Integer.parseInt(s);
            }
            catch (Exception e) {
                AppLog.printOnConsole(Overview.class.getName(),1,"Doesn't download value of honor points.");
            }
        }
        return -1;
    }
}
