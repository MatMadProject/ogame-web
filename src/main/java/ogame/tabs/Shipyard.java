package ogame.tabs;

import ogame.DataTechnology;
import ogame.FinalXPath;
import ogame.Status;
import ogame.Type;
import ogame.utils.WebElementPath;
import ogame.utils.WebElementUtil;
import ogame.utils.log.AppLog;
import ogame.watch.ProductionTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Shipyard {

    private static final String SHIPYARD_BUTTON = "//*[@id=\"menuTable\"]/li[6]/a";
    private static final String SHIPYARD_COMPONENT_ID = "shipyardcomponent";
    private static final String SHIP_DETAILS_VISIBLE = "slide-up";
    private static final String SHIP_SHOWS_DETAILS = "showsDetails";
    private static final String PRODUCTION_TIME = FinalXPath.TECHNOLOGY_DETAILS.concat("/div[2]/div/ul");
    private static final String BUILD_BUTTON = FinalXPath.TECHNOLOGY_DETAILS.concat("/div[2]/div/div[3]/button");
    private static final String SOLAR_SATELITE_PRODUCTION = FinalXPath.TECHNOLOGY_DETAILS.concat("/div[2]/div/ul/li[2]/span");
    private static final String BUILD_DURATION = "build_duration";
    private static final String BUILD_AMOUNT_INPUT = "//*[@id=\"build_amount\"]";

    private static final WebElementPath MILITARY_SHIP_CONTENER = new WebElementPath("//*[@id=\"technologies_battle\"]/ul/li[","]");
    private static final WebElementPath MILITARY_SHIP_VALUE = new WebElementPath("//*[@id=\"technologies_battle\"]/ul/li[","]/span/span/span[1]");
    private static final WebElementPath CIVIL_SHIP_CONTENER = new WebElementPath("//*[@id=\"technologies_civil\"]/ul/li[","]");
    private static final WebElementPath CIVIL_SHIP_VALUE = new WebElementPath("//*[@id=\"technologies_civil\"]/ul/li[","]/span/span/span[1]");

    public static boolean visible(WebDriver w) {
        try{
            //Sprawdzenie 1
            WebElement e =  w.findElement(By.xpath(SHIPYARD_BUTTON));
            String s = e.getAttribute("class");
            if(s.contains("selected"))
                return true;
            //Sprawdzenie 2
            e =  w.findElement(By.xpath(FinalXPath.MIDDLE_COMPONENT+"/div[2]"));
            s = e.getAttribute("id");
            return s.contains(SHIPYARD_COMPONENT_ID);
        }
        catch (Exception e){
            AppLog.printOnConsole(Shipyard.class.getName(),1,"When it checks, the tab is visible.");
        }
        return false;
    }

    public static boolean click(WebDriver w){
        try{
            if(visible(w)){ return true;
            }
            WebElement e =  w.findElement(By.xpath(SHIPYARD_BUTTON));
            e.click();
            return true;
        }
        catch (Exception e){
            AppLog.printOnConsole(Shipyard.class.getName(),1,"While trying to click on a tab.");
        }
        return false;
    }

    public static boolean visibleShipDetails(WebDriver w) {
        try{
            WebElement e =  w.findElement(By.xpath(FinalXPath.TECHNOLOGY_DETAILS_WRAPPER));
            String s = e.getAttribute("class");
            return s.equals(SHIP_DETAILS_VISIBLE);
        }
        catch (Exception e){
            AppLog.printOnConsole(Shipyard.class.getName(),1,"When it checks, the ship details is visible.");
        }
        return false;
    }
    @Deprecated
    public static boolean visibleShipDetails(WebDriver w, int pos, Type type) {
        try{
            WebElement e = null;
            if(type == Type.BATTLE){
                MILITARY_SHIP_CONTENER.setEdit(pos);
                e = w.findElement(By.xpath(MILITARY_SHIP_CONTENER.get()));
            }
            if(type == Type.CIVIL){
                CIVIL_SHIP_CONTENER.setEdit(pos);
                e = w.findElement(By.xpath(CIVIL_SHIP_CONTENER.get()));
            }

            if(e != null)
                return WebElementUtil.attrContainsText(e,"class", SHIP_SHOWS_DETAILS);
        }
        catch (Exception e){
            AppLog.printOnConsole(Shipyard.class.getName(),1,"When it checks, the ship details is visible.");
        }
        return false;
    }

    public static boolean visibleShipDetails(WebDriver w, DataTechnology dataTechnology) {
        try{
            WebElement e = null;
            if(dataTechnology.getType() == Type.BATTLE){
                MILITARY_SHIP_CONTENER.setEdit(dataTechnology.getListIndex());
                e = w.findElement(By.xpath(MILITARY_SHIP_CONTENER.get()));
            }
            if(dataTechnology.getType() == Type.CIVIL){
                CIVIL_SHIP_CONTENER.setEdit(dataTechnology.getListIndex());
                e = w.findElement(By.xpath(CIVIL_SHIP_CONTENER.get()));
            }
            if(e != null)
                return WebElementUtil.attrContainsText(e,"class", SHIP_SHOWS_DETAILS);
        }
        catch (Exception e){
            AppLog.printOnConsole(Shipyard.class.getName(),1,"When it checks, " + dataTechnology + " ship details is visible.");
        }
        return false;
    }

    @Deprecated
    public static Status statusOfShip(WebDriver w, int pos, Type type) {
        try {
            WebElement e = null;
            if(type == Type.BATTLE){
                MILITARY_SHIP_CONTENER.setEdit(pos);
                e = w.findElement(By.xpath(MILITARY_SHIP_CONTENER.get()));
            }
            if(type == Type.CIVIL){
                CIVIL_SHIP_CONTENER.setEdit(pos);
                e = w.findElement(By.xpath(CIVIL_SHIP_CONTENER.get()));
            }
            if(e != null){
                String s = e.getAttribute("data-status");
                return Status.getStatus(s);
            }
        }
        catch (Exception ex) {
            AppLog.printOnConsole(Shipyard.class.getName(),1,"Doesn't download status of " + DataTechnology.getFromListIndex(pos, type));
        }
        return Status.UNDEFINED;
    }

    public static Status statusOfShip(WebDriver w,DataTechnology dataTechnology) {
        try {
            WebElement e = null;
            if(dataTechnology.getType() == Type.BATTLE){
                MILITARY_SHIP_CONTENER.setEdit(dataTechnology.getListIndex());
                e = w.findElement(By.xpath(MILITARY_SHIP_CONTENER.get()));
            }
            if(dataTechnology.getType() == Type.CIVIL){
                CIVIL_SHIP_CONTENER.setEdit(dataTechnology.getListIndex());
                e = w.findElement(By.xpath(CIVIL_SHIP_CONTENER.get()));
            }
            if(e != null){
                String s = e.getAttribute("data-status");
                return Status.getStatus(s);
            }
        }
        catch (Exception ex) {
            AppLog.printOnConsole(Shipyard.class.getName(),1,"Doesn't download status of " + dataTechnology);
        }
        return Status.UNDEFINED;
    }

    public static ProductionTime productionTimeOfShip(WebDriver w){
        try {
            if(visibleShipDetails(w)){
                WebElement e =  w.findElement(By.xpath(PRODUCTION_TIME));
                List<WebElement> list = e.findElements(By.tagName("li"));
                for(WebElement element : list){
                    if(WebElementUtil.attrContainsText(element,"class",BUILD_DURATION)){
                        e = element.findElement(By.tagName("time"));
                        String s = e.getAttribute("datetime");
                        return new ProductionTime(s);
                    }
                }
            }
        }
        catch (Exception ex) {
            AppLog.printOnConsole(Shipyard.class.getName(),1,"While try download production time.");
        }
        return new ProductionTime("PT0S");
    }

    @Deprecated
    public static boolean clickOnShip(WebDriver w, int pos, Type type){
        try{
            WebElement e = null;
            if(type == Type.BATTLE){
                MILITARY_SHIP_CONTENER.setEdit(pos);
                e = w.findElement(By.xpath(MILITARY_SHIP_CONTENER.get()));
            }
            if(type == Type.CIVIL){
                CIVIL_SHIP_CONTENER.setEdit(pos);
                e = w.findElement(By.xpath(CIVIL_SHIP_CONTENER.get()));
            }
            if(e != null){
                if(visibleShipDetails(w,pos,type))
                    return true;
                e.click();
                return true;
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(Shipyard.class.getName(),1,"While trying to click on a ship: " + DataTechnology.getFromListIndex(pos, type));
        }
        return false;
    }

    public static boolean clickOnShip(WebDriver w, DataTechnology dataTechnology){
        try{
            WebElement e = null;
            if(dataTechnology.getType() == Type.BATTLE){
                MILITARY_SHIP_CONTENER.setEdit(dataTechnology.getListIndex());
                e = w.findElement(By.xpath(MILITARY_SHIP_CONTENER.get()));
            }
            if(dataTechnology.getType() == Type.CIVIL){
                CIVIL_SHIP_CONTENER.setEdit(dataTechnology.getListIndex());
                e = w.findElement(By.xpath(CIVIL_SHIP_CONTENER.get()));
            }

            if(e != null){
                if(visibleShipDetails(w,dataTechnology))
                    return true;
                e.click();
                return true;
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(Shipyard.class.getName(),1,"While trying to click on a " + dataTechnology);
        }
        return false;
    }

    @Deprecated
    public static String dataTechnologyOfShip(WebDriver w, int pos, Type type) {
        try {
            WebElement e = null;
            if(type == Type.BATTLE){
                MILITARY_SHIP_CONTENER.setEdit(pos);
                e = w.findElement(By.xpath(MILITARY_SHIP_CONTENER.get()));
            }
            if(type == Type.CIVIL){
                CIVIL_SHIP_CONTENER.setEdit(pos);
                e = w.findElement(By.xpath(CIVIL_SHIP_CONTENER.get()));
            }
            if(e != null)
                return e.getAttribute("data-technology");
        }
        catch (Exception ex) {
            AppLog.printOnConsole(Shipyard.class.getName(),1,"Doesn't download data technology of " + DataTechnology.getFromListIndex(pos, type));
        }
        return "-1";
    }

    public static String dataTechnologyOfShip(WebDriver w, DataTechnology dataTechnology) {
        try {
            WebElement e = null;
            if(dataTechnology.getType() == Type.BATTLE){
                MILITARY_SHIP_CONTENER.setEdit(dataTechnology.getListIndex());
                e = w.findElement(By.xpath(MILITARY_SHIP_CONTENER.get()));
            }
            if(dataTechnology.getType() == Type.CIVIL){
                CIVIL_SHIP_CONTENER.setEdit(dataTechnology.getListIndex());
                e = w.findElement(By.xpath(CIVIL_SHIP_CONTENER.get()));
            }
            if(e != null)
                return e.getAttribute("data-technology");

        }
        catch (Exception ex) {
            AppLog.printOnConsole(Shipyard.class.getName(),1,"Doesn't download data technology of " + dataTechnology);
        }
        return "-1";
    }

    @Deprecated
    public static String localNameOfShip(WebDriver w, int pos, Type type) {
        try {
            WebElement e = null;
            if(type == Type.BATTLE){
                MILITARY_SHIP_CONTENER.setEdit(pos);
                e = w.findElement(By.xpath(MILITARY_SHIP_CONTENER.get()));
            }
            if(type == Type.CIVIL){
                CIVIL_SHIP_CONTENER.setEdit(pos);
                e = w.findElement(By.xpath(CIVIL_SHIP_CONTENER.get()));
            }
            if(e != null)
                return e.getAttribute("aria-label");

        }
        catch (Exception ex) {
            AppLog.printOnConsole(Shipyard.class.getName(),1,"Doesn't download local name of " + DataTechnology.getFromListIndex(pos, type));
        }
        return "null";
    }

    public static String localNameOfShip(WebDriver w, DataTechnology dataTechnology) {
        try {
            WebElement e = null;
            if(dataTechnology.getType() == Type.BATTLE){
                MILITARY_SHIP_CONTENER.setEdit(dataTechnology.getListIndex());
                e = w.findElement(By.xpath(MILITARY_SHIP_CONTENER.get()));
            }
            if(dataTechnology.getType() == Type.CIVIL){
                CIVIL_SHIP_CONTENER.setEdit(dataTechnology.getListIndex());
                e = w.findElement(By.xpath(CIVIL_SHIP_CONTENER.get()));
            }
            if(e != null)
                return e.getAttribute("aria-label");

        }
        catch (Exception ex) {
            AppLog.printOnConsole(Shipyard.class.getName(),1,"Doesn't download local name of " + dataTechnology);
        }
        return "null";
    }

    public static int valueShip(WebDriver w, DataTechnology ship){
        try {
            WebElement e = null;
            if(ship.getType() == Type.BATTLE){
                MILITARY_SHIP_VALUE.setEdit(ship.getListIndex());
                e = w.findElement(By.xpath(MILITARY_SHIP_VALUE.get()));
            }
            if(ship.getType() == Type.CIVIL){
                CIVIL_SHIP_VALUE.setEdit(ship.getListIndex());
                e = w.findElement(By.xpath(CIVIL_SHIP_VALUE.get()));
            }
            if(e != null)
                return Integer.parseInt(e.getText());

        }
        catch (Exception ex) {
            AppLog.printOnConsole(Shipyard.class.getName(),1,"Doesn't download value of " + ship);
        }
        return -1;
    }

    @Deprecated
    public static int valueShip(WebDriver w, int pos, Type type) {
        try {
            WebElement e = null;
            if(type == Type.BATTLE){
                MILITARY_SHIP_CONTENER.setEdit(pos);
                e = w.findElement(By.xpath(MILITARY_SHIP_CONTENER.get()));
            }
            if(type == Type.CIVIL){
                CIVIL_SHIP_CONTENER.setEdit(pos);
                e = w.findElement(By.xpath(CIVIL_SHIP_CONTENER.get()));
            }
            if(e != null)
                return Integer.parseInt(e.getText());

        }
        catch (Exception ex) {
            AppLog.printOnConsole(Shipyard.class.getName(),1,"Doesn't download value of " + DataTechnology.getFromListIndex(pos, type));
        }
        return -1;
    }

    public static boolean clickBuiltShip(WebDriver w){
        try {
            if(visibleShipDetails(w)){
                WebElement e =  w.findElement(By.xpath(BUILD_BUTTON));
                e.click();
                return true;
            }
        }
        catch (Exception ex) {
            AppLog.printOnConsole(Shipyard.class.getName(),1,"While try click built ship.");
        }
        return false;
    }

    public static boolean inputShipAmount(WebDriver w, int amount){
        try {
            if(visibleShipDetails(w)){
                WebElement e =  w.findElement(By.xpath(BUILD_AMOUNT_INPUT));
                e.click();
                e.sendKeys(String.valueOf(amount));
                return true;
            }
        }
        catch (Exception ex) {
            AppLog.printOnConsole(Shipyard.class.getName(),1,"While try input ship amount.");
        }
        return false;
    }

    public static int solarSateliteProduction(WebDriver w){
        try {
            if(visibleShipDetails(w,DataTechnology.SOLAR_SATELITE)) {
                WebElement e = w.findElement(By.xpath(SOLAR_SATELITE_PRODUCTION));
                String s = e.getAttribute("data-value");
                return Integer.parseInt(s);
            }
        }
        catch (Exception ex) {
            AppLog.printOnConsole(Shipyard.class.getName(),1,"While try download solar production.");
        }
        return -1;
    }

    public static long startDateOfUpgradeBuilding(WebDriver w, DataTechnology dataTechnology){
        if(statusOfShip(w,dataTechnology) == Status.ACTIVE){
            try {
                WebElement e = null;
                if(dataTechnology.getType() == Type.BATTLE){
                    MILITARY_SHIP_CONTENER.setEdit(dataTechnology.getListIndex());
                    e = w.findElement(By.xpath(MILITARY_SHIP_CONTENER.get()));
                }
                if(dataTechnology.getType() == Type.CIVIL){
                    CIVIL_SHIP_CONTENER.setEdit(dataTechnology.getListIndex());
                    e = w.findElement(By.xpath(CIVIL_SHIP_CONTENER.get()));
                }
                if(e != null)
                    return Long.parseLong(e.getAttribute("data-start"));

            }
            catch (Exception ex) {
                AppLog.printOnConsole(Shipyard.class.getName(),1,"Doesn't download start data of " + dataTechnology);
            }
        }
        return -1;
    }

    public static long endDateOfUpgradeBuilding(WebDriver w, DataTechnology dataTechnology){
        if(statusOfShip(w,dataTechnology) == Status.ACTIVE){
            try {
                WebElement e = null;
                if(dataTechnology.getType() == Type.BATTLE){
                    MILITARY_SHIP_CONTENER.setEdit(dataTechnology.getListIndex());
                    e = w.findElement(By.xpath(MILITARY_SHIP_CONTENER.get()));
                }
                if(dataTechnology.getType() == Type.CIVIL){
                    CIVIL_SHIP_CONTENER.setEdit(dataTechnology.getListIndex());
                    e = w.findElement(By.xpath(CIVIL_SHIP_CONTENER.get()));
                }
                if(e != null)
                    return Long.parseLong(e.getAttribute("data-end"));

            }
            catch (Exception ex) {
                AppLog.printOnConsole(Shipyard.class.getName(),1,"Doesn't download end data of " + dataTechnology);
            }
        }
        return -1;
    }

    public static long productionTimeOfUpgradedBuildingInSeconds(WebDriver w, DataTechnology dataTechnology){
        if(statusOfShip(w,dataTechnology) == Status.ACTIVE){
            try {
                WebElement e = null;
                if(dataTechnology.getType() == Type.BATTLE){
                    MILITARY_SHIP_CONTENER.setEdit(dataTechnology.getListIndex());
                    e = w.findElement(By.xpath(MILITARY_SHIP_CONTENER.get()));
                }
                if(dataTechnology.getType() == Type.CIVIL){
                    CIVIL_SHIP_CONTENER.setEdit(dataTechnology.getListIndex());
                    e = w.findElement(By.xpath(CIVIL_SHIP_CONTENER.get()));
                }
                if(e != null)
                    return Long.parseLong(e.getAttribute("data-total"));

            }
            catch (Exception ex) {
                AppLog.printOnConsole(Shipyard.class.getName(),1,"Doesn't download production of " + dataTechnology);
            }
        }
        return -1;
    }
}
