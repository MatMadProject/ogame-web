package ogame.tabs;

import ogame.FinalXPath;
import ogame.Status;
import ogame.buildings.DataTechnology;
import ogame.buildings.RequiredResources;
import ogame.utils.WebElementPath;
import ogame.utils.WebElementUtil;
import ogame.utils.log.AppLog;
import ogame.watch.ProductionTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Facilities {

    private static final String FACILITIES_COMPONENT_ID = "facilitiescomponent";
    private static final String BUILDING_DETAILS_VISIBLE = "slide-up";
    private static final String BUILDING_SHOWS_DETAILS = "showsDetails";
    private static final String BUILDING_UPGRADE_BUTTON = "/span/button";
    private static final String BUILD_DURATION = "build_duration";
    private static final String FACILITIES_BUTTON = "//*[@id=\"menuTable\"]/li[3]/a";
    private static final String ERROR_BOX_ACCEPT_DECISION = "//*[@id=\"errorBoxDecision\"]/div[2]/div/div[1]/a";
    private static final String ERROR_BOX_DECLINE_DECISION = "//*[@id=\"errorBoxDecision\"]/div[2]/div/div[1]/a";
    private static final String BUILDING_STOP_UPGRADE_BUTTON = FinalXPath.TECHNOLOGY_DETAILS.concat("/div[1]/a");
    private static final String PRODUCTION_TIME = FinalXPath.TECHNOLOGY_DETAILS.concat("/div[2]/div/ul");
    private static final String ENERGY_SPAN = FinalXPath.TECHNOLOGY_DETAILS.concat("/div[2]/div/ul/li[2]/span");
    private static final String REQUIRED_RESOURCES_CONTAINER = FinalXPath.TECHNOLOGY_DETAILS.concat("/div[2]/div/div[1]");
    private static final String BUIILDING_LEVEL = "/span/span";

    private static final WebElementPath BUILDINGS_CONTAINER = new WebElementPath("//*[@id=\"technologies\"]/ul/li[","]");


    public static boolean visible(WebDriver w) {
        try{
            WebElement e =  w.findElement(By.xpath(FinalXPath.MIDDLE_COMPONENT+"/div[2]"));
            String s = e.getAttribute("id");
            return s.contains(FACILITIES_COMPONENT_ID);
        }
        catch (Exception e){
            AppLog.printOnConsole(Facilities.class.getName(),1,"When it checks, the tab is visible.");
        }
        return false;
    }

    public static boolean visibleBuildingDetails(WebDriver w) {
        try{
            WebElement e =  w.findElement(By.xpath(FinalXPath.TECHNOLOGY_DETAILS_WRAPPER));
            String s = e.getAttribute("class");
            return s.equals(BUILDING_DETAILS_VISIBLE);
        }
        catch (Exception e){
            AppLog.printOnConsole(Facilities.class.getName(),1,"When it checks, the building details is visible.");
        }
        return false;
    }

    public static boolean visibleBuildingDetails(WebDriver w, int pos) {
        try{
            BUILDINGS_CONTAINER.setEdit(pos);
            WebElement e = w.findElement(By.xpath(BUILDINGS_CONTAINER.get()));
            return WebElementUtil.attrContainsText(e,"class",BUILDING_SHOWS_DETAILS);
        }
        catch (Exception e){
            AppLog.printOnConsole(Facilities.class.getName(),1,"When it checks, the building details is visible.");
        }
        return false;
    }

    public static boolean click(WebDriver w){
        try{
            if(visible(w)){ return true;
            }
            WebElement e =  w.findElement(By.xpath(FACILITIES_BUTTON));
            e.click();
            return true;
        }
        catch (Exception e){
            AppLog.printOnConsole(Facilities.class.getName(),1,"While trying to click on a tab.");
        }
        return false;
    }

    public static boolean acceptDecisionOnErrorBox(WebDriver w){
        try{
            WebElement e =  w.findElement(By.xpath(ERROR_BOX_ACCEPT_DECISION));
            e.click();
            return true;
        }
        catch (Exception e){
            AppLog.printOnConsole(Facilities.class.getName(),1,"While trying to click on a error box - accept decision.");
        }
        return false;
    }

    public static boolean declineDecisionOnErrorBox(WebDriver w){
        try{
            WebElement e =  w.findElement(By.xpath(ERROR_BOX_DECLINE_DECISION));
            e.click();
            return true;
        }
        catch (Exception e){
            AppLog.printOnConsole(Facilities.class.getName(),1,"While trying to click on a error box - decline decision.");
        }
        return false;
    }

    public static boolean upgradeBuilding(WebDriver w, int pos){
        try {
            if(!statusOfBuilding(w,pos).equals(Status.ON))
                return false;
            BUILDINGS_CONTAINER.setEdit(pos);
            WebElement e = w.findElement(By.xpath(BUILDINGS_CONTAINER.get().concat(BUILDING_UPGRADE_BUTTON)));
            e.click();
            return true;
        }
        catch (Exception ex) {
            AppLog.printOnConsole(Supplies.class.getName(),1,"While try upgrade " + DataTechnology.getFromListIndex(pos));
        }
        return false;
    }

    public static Status statusOfBuilding(WebDriver w, int pos) {
        try {
            BUILDINGS_CONTAINER.setEdit(pos);
            WebElement e = w.findElement(By.xpath(BUILDINGS_CONTAINER.get()));
            String s = e.getAttribute("data-status");
            return Status.getStatus(s);
        }
        catch (Exception ex) {
            AppLog.printOnConsole(Facilities.class.getName(),1,"Doesn't download status of " + DataTechnology.getFromListIndex(pos));
        }
        return Status.UNDEFINED;
    }

    public static boolean stopUpgradeBuilding(WebDriver w, int pos){
        try {
            if(!statusOfBuilding(w,pos).equals(Status.ACTIVE))
                return false;
            if(visibleBuildingDetails(w,pos)){
                WebElement e = w.findElement(By.xpath(BUILDING_STOP_UPGRADE_BUTTON));
                e.click();
                return true;
            }
        }
        catch (Exception ex) {
            AppLog.printOnConsole(Facilities.class.getName(),1,"While try stop upgrade " + DataTechnology.getFromListIndex(pos));
        }
        return false;
    }

    public static ProductionTime productionTimeOfBuilding(WebDriver w){
        try {
            if(visibleBuildingDetails(w)){
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
            AppLog.printOnConsole(Facilities.class.getName(),1,"While try download production time.");
        }
        return new ProductionTime("PT0S");
    }

    public static RequiredResources getRequiredResources(WebDriver w, int pos){
        if(visibleBuildingDetails(w,pos)){
            int metal = 0, crystal = 0, deuterium = 0, energy = 0;
            String s;
            WebElement e =  w.findElement(By.xpath(REQUIRED_RESOURCES_CONTAINER));
            List<WebElement> list = e.findElements(By.tagName("li"));
            for(WebElement element : list){
                if(WebElementUtil.attrContainsText(element,"class","metal")){
                    s = element.getAttribute("data-value");
                    metal = Integer.parseInt(s);
                }
                if(WebElementUtil.attrContainsText(element,"class","crystal")){
                    s = element.getAttribute("data-value");
                    crystal = Integer.parseInt(s);
                }
                if(WebElementUtil.attrContainsText(element,"class","deuterium")){
                    s = element.getAttribute("data-value");
                    deuterium = Integer.parseInt(s);
                }
                if(WebElementUtil.attrContainsText(element,"class","energy")){
                    s = element.getAttribute("data-value");
                    energy = Integer.parseInt(s);
                }
            }
            return new RequiredResources(metal,crystal,deuterium,energy);
        }
        return new RequiredResources(-1,-1,-1,-1);
    }

    public static boolean clickOnBuilding(WebDriver w, int pos){
        try{
            BUILDINGS_CONTAINER.setEdit(pos);
            WebElement e = w.findElement(By.xpath(BUILDINGS_CONTAINER.get()));
            if(visibleBuildingDetails(w,pos))
                return true;
            e.click();
            return true;
        }
        catch (Exception e){
            AppLog.printOnConsole(Facilities.class.getName(),1,"While trying to click on a building: " + DataTechnology.getFromListIndex(pos));
        }
        return false;
    }

    public static int levelOfBuilding(WebDriver w, int pos) {
        try {
            BUILDINGS_CONTAINER.setEdit(pos);
            WebElement e = w.findElement(By.xpath(BUILDINGS_CONTAINER.get().concat(BUIILDING_LEVEL)));
            String s = e.getText();
            return Integer.parseInt(s);
        }
        catch (Exception ex) {
            AppLog.printOnConsole(Facilities.class.getName(),1,"Doesn't download level of " + DataTechnology.getFromListIndex(pos));
        }
        return -1;
    }

    public static String dataTechnologyOfBuilding(WebDriver w, int pos) {
        try {
            BUILDINGS_CONTAINER.setEdit(pos);
            WebElement e = w.findElement(By.xpath(BUILDINGS_CONTAINER.get()));
            String s = e.getAttribute("data-technology");
            return s;
        }
        catch (Exception ex) {
            AppLog.printOnConsole(Facilities.class.getName(),1,"Doesn't download data technology of " + DataTechnology.getFromListIndex(pos));
        }
        return "-1";
    }

    public static String localNameOfBuilding(WebDriver w, int pos) {
        try {
            BUILDINGS_CONTAINER.setEdit(pos);
            WebElement e = w.findElement(By.xpath(BUILDINGS_CONTAINER.get()));
            return e.getAttribute("aria-label");
        }
        catch (Exception ex) {
            AppLog.printOnConsole(Facilities.class.getName(),1,"Doesn't download local name of " + DataTechnology.getFromListIndex(pos));
        }
        return "null";
    }
}
