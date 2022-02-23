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

public class Defence {

    private static final String DEFENCE_BUTTON = "//*[@id=\"menuTable\"]/li[7]/a";
    private static final String DEFENCE_COMPONENT_ID = "defensescomponent";
    private static final String DEFENC_DETAILS_VISIBLE = "slide-up";
    private static final String DEFENCE_SHOWS_DETAILS = "showsDetails";
    private static final String PRODUCTION_TIME = FinalXPath.TECHNOLOGY_DETAILS.concat("/div[2]/div/ul");
    private static final String BUILD_DURATION = "build_duration";
    private static final String BUILD_BUTTON = FinalXPath.TECHNOLOGY_DETAILS.concat("/div[2]/div/div[3]/button");
    private static final String BUILD_SHIELD_BUTTON = FinalXPath.TECHNOLOGY_DETAILS.concat("/div[2]/div/div[2]/button");
    private static final String BUILD_AMOUNT_INPUT = "//*[@id=\"build_amount\"]";

    private static final WebElementPath DEFENCE_CONTENER = new WebElementPath("//*[@id=\"technologies\"]/ul/li[","]");

    public static boolean visible(WebDriver w) {
        try{
            //Sprawdzenie 1
            WebElement e =  w.findElement(By.xpath(DEFENCE_BUTTON));
            String s = e.getAttribute("class");
            if(s.contains("selected"))
                return true;
            //Sprawdzenie 2
            e =  w.findElement(By.xpath(FinalXPath.MIDDLE_COMPONENT+"/div[2]"));
            s = e.getAttribute("id");
            return s.contains(DEFENCE_COMPONENT_ID);
        }
        catch (Exception e){
            AppLog.printOnConsole(Defence.class.getName(),1,"When it checks, the tab is visible.");
        }
        return false;
    }

    public static boolean click(WebDriver w){
        try{
            if(visible(w)){ return true;
            }
            WebElement e =  w.findElement(By.xpath(DEFENCE_BUTTON));
            e.click();
            return true;
        }
        catch (Exception e){
            AppLog.printOnConsole(Defence.class.getName(),1,"While trying to click on a tab.");
        }
        return false;
    }

    public static boolean visibleDefenceDetails(WebDriver w) {
        try{
            WebElement e =  w.findElement(By.xpath(FinalXPath.TECHNOLOGY_DETAILS_WRAPPER));
            String s = e.getAttribute("class");
            return s.equals(DEFENC_DETAILS_VISIBLE);
        }
        catch (Exception e){
            AppLog.printOnConsole(Defence.class.getName(),1,"When it checks, the ship details is visible.");
        }
        return false;
    }

    public static boolean visibleDefenceDetails(WebDriver w, DataTechnology dataTechnology) {
        try{
            DEFENCE_CONTENER.setEdit(dataTechnology.getListIndex());
            WebElement e = w.findElement(By.xpath(DEFENCE_CONTENER.get()));

            if(e != null)
                return WebElementUtil.attrContainsText(e,"class", DEFENCE_SHOWS_DETAILS);
        }
        catch (Exception e){
            AppLog.printOnConsole(Shipyard.class.getName(),1,"When it checks, " + dataTechnology + " defence details is visible.");
        }
        return false;
    }

    public static Status statusOfDefence(WebDriver w, DataTechnology dataTechnology) {
        try {
            DEFENCE_CONTENER.setEdit(dataTechnology.getListIndex());
            WebElement e = w.findElement(By.xpath(DEFENCE_CONTENER.get()));

            if(e != null){
                String s = e.getAttribute("data-status");
                return Status.getStatus(s);
            }
        }
        catch (Exception ex) {
            AppLog.printOnConsole(Defence.class.getName(),1,"Doesn't download status of " + dataTechnology);
        }
        return Status.UNDEFINED;
    }

    public static ProductionTime productionTimeOfDefence(WebDriver w){
        try {
            if(visibleDefenceDetails(w)){
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
            AppLog.printOnConsole(Defence.class.getName(),1,"While try download production time.");
        }
        return new ProductionTime("PT0S");
    }

    public static boolean clickOnDefence(WebDriver w, DataTechnology dataTechnology){
        try{
            DEFENCE_CONTENER.setEdit(dataTechnology.getListIndex());
            WebElement e = w.findElement(By.xpath(DEFENCE_CONTENER.get()));

            if(e != null){
                if(visibleDefenceDetails(w,dataTechnology))
                    return true;
                e.click();
                return true;
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(Defence.class.getName(),1,"While trying to click on a " + dataTechnology);
        }
        return false;
    }

    public static String dataTechnologyOfDefence(WebDriver w, DataTechnology dataTechnology) {
        try {
            DEFENCE_CONTENER.setEdit(dataTechnology.getListIndex());
            WebElement e = w.findElement(By.xpath(DEFENCE_CONTENER.get()));

            if(e != null)
                return e.getAttribute("data-technology");

        }
        catch (Exception ex) {
            AppLog.printOnConsole(Defence.class.getName(),1,"Doesn't download data technology of " + dataTechnology);
        }
        return "-1";
    }

    public static String localNameOfDefence(WebDriver w, DataTechnology dataTechnology) {
        try {
            DEFENCE_CONTENER.setEdit(dataTechnology.getListIndex());
            WebElement e = w.findElement(By.xpath(DEFENCE_CONTENER.get()));

            if(e != null)
                return e.getAttribute("aria-label");
        }
        catch (Exception ex) {
            AppLog.printOnConsole(Defence.class.getName(),1,"Doesn't download local name of " + dataTechnology);
        }
        return "null";
    }

    public static int valueDefence(WebDriver w, DataTechnology defence){
        try {
            DEFENCE_CONTENER.setEdit(defence.getListIndex());
            WebElement e = w.findElement(By.xpath(DEFENCE_CONTENER.get()));

            if(e != null)
                return Integer.parseInt(e.getText());

        }
        catch (Exception ex) {
            AppLog.printOnConsole(Defence.class.getName(),1,"Doesn't download value of " + defence);
        }
        return -1;
    }

    public static boolean clickBuiltDefence(WebDriver w){
        try {
            if(visibleDefenceDetails(w)){
                WebElement e =  w.findElement(By.xpath(BUILD_BUTTON));
                e.click();
                return true;
            }
        }
        catch (Exception ex) {
            AppLog.printOnConsole(Defence.class.getName(),1,"While try click built defence.");
        }
        return false;
    }

    public static boolean clickBuiltDefenceShield(WebDriver w){
        try {
            if(visibleDefenceDetails(w)){
                WebElement e =  w.findElement(By.xpath(BUILD_SHIELD_BUTTON));
                e.click();
                return true;
            }
        }
        catch (Exception ex) {
            AppLog.printOnConsole(Defence.class.getName(),1,"While try click built defence shield.");
        }
        return false;
    }

    public static boolean inputDefenceAmount(WebDriver w, int amount){
        try {
            if(visibleDefenceDetails(w)){
                WebElement e =  w.findElement(By.xpath(BUILD_AMOUNT_INPUT));
                e.click();
                e.sendKeys(String.valueOf(amount));
                return true;
            }
        }
        catch (Exception ex) {
            AppLog.printOnConsole(Defence.class.getName(),1,"While try input defence amount.");
        }
        return false;
    }

    public static long startDateOfUpgrade(WebDriver w, DataTechnology dataTechnology){
        if(statusOfDefence(w,dataTechnology) == Status.ACTIVE){
            try {
                DEFENCE_CONTENER.setEdit(dataTechnology.getListIndex());
                WebElement e = w.findElement(By.xpath(DEFENCE_CONTENER.get()));

                if(e != null)
                    return Long.parseLong(e.getAttribute("data-start"));
            }
            catch (Exception ex) {
                AppLog.printOnConsole(Defence.class.getName(),1,"Doesn't download start data of " + dataTechnology);
            }
        }
        return -1;
    }

    public static long endDateOfUpgrade(WebDriver w, DataTechnology dataTechnology){
        if(statusOfDefence(w,dataTechnology) == Status.ACTIVE){
            try {
                DEFENCE_CONTENER.setEdit(dataTechnology.getListIndex());
                WebElement e = w.findElement(By.xpath(DEFENCE_CONTENER.get()));

                if(e != null)
                    return Long.parseLong(e.getAttribute("data-end"));
            }
            catch (Exception ex) {
                AppLog.printOnConsole(Defence.class.getName(),1,"Doesn't download end data of " + dataTechnology);
            }
        }
        return -1;
    }

    public static long productionTimeOfUpgradedDefenceInSeconds(WebDriver w, DataTechnology dataTechnology){
        if(statusOfDefence(w,dataTechnology) == Status.ACTIVE){
            try {
                DEFENCE_CONTENER.setEdit(dataTechnology.getListIndex());
                WebElement e = w.findElement(By.xpath(DEFENCE_CONTENER.get()));

                if(e != null)
                    return Long.parseLong(e.getAttribute("data-total"));
            }
            catch (Exception ex) {
                AppLog.printOnConsole(Defence.class.getName(),1,"Doesn't download production time of " + dataTechnology);
            }
        }
        return -1;
    }
}
