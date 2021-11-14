package ogame.tabs;

import ogame.FinalXPath;
import ogame.Status;
import ogame.buildings.RequiredResources;
import ogame.researches.DataTechnology;
import ogame.researches.Type;
import ogame.utils.WebElementPath;
import ogame.utils.WebElementUtil;
import ogame.utils.log.AppLog;
import ogame.watch.ProductionTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Research {
    private static final String RESEARCH_COMPONENT_ID = "researchcomponent";
    private static final String RESEARCH_DETAILS_VISIBLE = "slide-up";
    private static final String RESEARCH_SHOWS_DETAILS = "showsDetails";
    private static final String BUILD_DURATION = "build_duration";
    private static final String ERROR_BOX_ACCEPT_DECISION = "//*[@id=\"errorBoxDecision\"]/div[2]/div/div[1]/a";
    private static final String ERROR_BOX_DECLINE_DECISION = "//*[@id=\"errorBoxDecision\"]/div[2]/div/div[1]/a";
    private static final String RESEARCH_BUTTON = "//*[@id=\"menuTable\"]/li[5]/a";
    private static final String RESEARCH_UPGRADE_BUTTON = "/span/button";
    private static final String RESEARCH_LEVEL = "/span/span";
    private static final String RESEARCH_STOP_UPGRADE_BUTTON = FinalXPath.TECHNOLOGY_DETAILS.concat("/div[1]/a");
    private static final String PRODUCTION_TIME = FinalXPath.TECHNOLOGY_DETAILS.concat("/div[2]/div/ul");
    private static final String REQUIRED_RESOURCES_CONTAINER = FinalXPath.TECHNOLOGY_DETAILS.concat("/div[2]/div/div[1]");

    private static final WebElementPath TECHNOLOGIES_BASIC_CONTAINER = new WebElementPath(" //*[@id=\"technologies_basic\"]/ul/li[","]");
    private static final WebElementPath TECHNOLOGIES_DRIVE_CONTAINER = new WebElementPath("//*[@id=\"technologies_drive\"]/ul/li[","]");
    private static final WebElementPath TECHNOLOGIES_ADVANCED_CONTAINER = new WebElementPath("//*[@id=\"technologies_advanced\"]/ul/li[","]");
    private static final WebElementPath TECHNOLOGIES_COMBAT_CONTAINER = new WebElementPath("//*[@id=\"technologies_combat\"]/ul/li[","]");


    public static boolean visible(WebDriver w) {
        try{
            WebElement e =  w.findElement(By.xpath(FinalXPath.MIDDLE_COMPONENT+"/div[2]"));
            String s = e.getAttribute("id");
            return s.contains(RESEARCH_COMPONENT_ID);
        }
        catch (Exception e){
            AppLog.printOnConsole(Research.class.getName(),1,"When it checks, the tab is visible.");
        }
        return false;
    }
    public static boolean visibleResearchDetails(WebDriver w) {
        try{
            WebElement e =  w.findElement(By.xpath(FinalXPath.TECHNOLOGY_DETAILS_WRAPPER));
            String s = e.getAttribute("class");
            return s.equals(RESEARCH_DETAILS_VISIBLE);
        }
        catch (Exception e){
            AppLog.printOnConsole(Research.class.getName(),1,"When it checks, the research details is visible.");
        }
        return false;
    }
    public static boolean visibleResearchDetails(WebDriver w, int pos, Type type) {
        try{
            WebElement e = null;
            if(type == Type.BASIC){
                TECHNOLOGIES_BASIC_CONTAINER.setEdit(pos);
                e = w.findElement(By.xpath(TECHNOLOGIES_BASIC_CONTAINER.get()));
            }
            if(type == Type.ADVANCED){
                TECHNOLOGIES_ADVANCED_CONTAINER.setEdit(pos);
                e = w.findElement(By.xpath(TECHNOLOGIES_ADVANCED_CONTAINER.get()));
            }
            if(type == Type.COMBAT){
                TECHNOLOGIES_COMBAT_CONTAINER.setEdit(pos);
                e = w.findElement(By.xpath(TECHNOLOGIES_COMBAT_CONTAINER.get()));
            }
            if(type == Type.DRIVE){
                TECHNOLOGIES_DRIVE_CONTAINER.setEdit(pos);
                e = w.findElement(By.xpath(TECHNOLOGIES_DRIVE_CONTAINER.get()));
            }
            if(e != null)
                return WebElementUtil.attrContainsText(e,"class", RESEARCH_SHOWS_DETAILS);
        }
        catch (Exception e){
            AppLog.printOnConsole(Research.class.getName(),1,"When it checks, the research details is visible.");
        }
        return false;
    }
    public static boolean click(WebDriver w){
        try{
            if(visible(w)){ return true;
            }
            WebElement e =  w.findElement(By.xpath(RESEARCH_BUTTON));
            e.click();
            return true;
        }
        catch (Exception e){
            AppLog.printOnConsole(Research.class.getName(),1,"While trying to click on a tab.");
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
            AppLog.printOnConsole(Research.class.getName(),1,"While trying to click on a error box - accept decision.");
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
            AppLog.printOnConsole(Research.class.getName(),1,"While trying to click on a error box - decline decision.");
        }
        return false;
    }
    public static boolean upgrade(WebDriver w, int pos, Type type){
        try {
            if(!statusOfResearch(w,pos,type).equals(Status.ON))
                return false;
            WebElement e = null;
            if(type == Type.BASIC){
                TECHNOLOGIES_BASIC_CONTAINER.setEdit(pos);
                e = w.findElement(By.xpath(TECHNOLOGIES_BASIC_CONTAINER.get().concat(RESEARCH_UPGRADE_BUTTON)));
            }
            if(type == Type.ADVANCED){
                TECHNOLOGIES_ADVANCED_CONTAINER.setEdit(pos);
                e = w.findElement(By.xpath(TECHNOLOGIES_ADVANCED_CONTAINER.get().concat(RESEARCH_UPGRADE_BUTTON)));
            }
            if(type == Type.COMBAT){
                TECHNOLOGIES_COMBAT_CONTAINER.setEdit(pos);
                e = w.findElement(By.xpath(TECHNOLOGIES_COMBAT_CONTAINER.get().concat(RESEARCH_UPGRADE_BUTTON)));
            }
            if(type == Type.DRIVE){
                TECHNOLOGIES_DRIVE_CONTAINER.setEdit(pos);
                e = w.findElement(By.xpath(TECHNOLOGIES_DRIVE_CONTAINER.get().concat(RESEARCH_UPGRADE_BUTTON)));
            }
            if(e != null){
                e.click();
                return true;
            }
        }
        catch (Exception ex) {
            AppLog.printOnConsole(Research.class.getName(),1,"While try upgrade " + DataTechnology.getFromListIndex(pos));
        }
        return false;
    }
    public static Status statusOfResearch(WebDriver w, int pos, Type type) {
        try {
            WebElement e = null;
            if(type == Type.BASIC){
                TECHNOLOGIES_BASIC_CONTAINER.setEdit(pos);
                e = w.findElement(By.xpath(TECHNOLOGIES_BASIC_CONTAINER.get()));
            }
            if(type == Type.ADVANCED){
                TECHNOLOGIES_ADVANCED_CONTAINER.setEdit(pos);
                e = w.findElement(By.xpath(TECHNOLOGIES_ADVANCED_CONTAINER.get()));
            }
            if(type == Type.COMBAT){
                TECHNOLOGIES_COMBAT_CONTAINER.setEdit(pos);
                e = w.findElement(By.xpath(TECHNOLOGIES_COMBAT_CONTAINER.get()));
            }
            if(type == Type.DRIVE){
                TECHNOLOGIES_DRIVE_CONTAINER.setEdit(pos);
                e = w.findElement(By.xpath(TECHNOLOGIES_DRIVE_CONTAINER.get()));
            }
            if(e != null){
                String s = e.getAttribute("data-status");
                return Status.getStatus(s);
            }
        }
        catch (Exception ex) {
            AppLog.printOnConsole(Research.class.getName(),1,"Doesn't download status of " + DataTechnology.getFromListIndex(pos));
        }
        return Status.UNDEFINED;
    }
    public static boolean stopUpgrade(WebDriver w, int pos, Type type){
        try {
            if(!statusOfResearch(w,pos,type).equals(Status.ACTIVE))
                return false;
            if(visibleResearchDetails(w,pos,type)){
                WebElement e = w.findElement(By.xpath(RESEARCH_STOP_UPGRADE_BUTTON));
                e.click();
                return true;
            }
        }
        catch (Exception ex) {
            AppLog.printOnConsole(Research.class.getName(),1,"While try stop upgrade " + DataTechnology.getFromListIndex(pos));
        }
        return false;
    }
    //*[@id="technologydetails"]/div[2]/div/ul/li/time
    public static ProductionTime productionTimeOfResearch(WebDriver w){
        try {
            if(visibleResearchDetails(w)){
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
            AppLog.printOnConsole(Research.class.getName(),1,"While try download production time.");
        }
        return new ProductionTime("PT0S");
    }
    public static RequiredResources getRequiredResources(WebDriver w, int pos, Type type){
        if(visibleResearchDetails(w, pos, type)){
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

    public static boolean clickOnResearch(WebDriver w, int pos, Type type){
        try{
            WebElement e = null;
            if(type == Type.BASIC){
                TECHNOLOGIES_BASIC_CONTAINER.setEdit(pos);
                e = w.findElement(By.xpath(TECHNOLOGIES_BASIC_CONTAINER.get()));
            }
            if(type == Type.ADVANCED){
                TECHNOLOGIES_ADVANCED_CONTAINER.setEdit(pos);
                e = w.findElement(By.xpath(TECHNOLOGIES_ADVANCED_CONTAINER.get()));
            }
            if(type == Type.COMBAT){
                TECHNOLOGIES_COMBAT_CONTAINER.setEdit(pos);
                e = w.findElement(By.xpath(TECHNOLOGIES_COMBAT_CONTAINER.get()));
            }
            if(type == Type.DRIVE){
                TECHNOLOGIES_DRIVE_CONTAINER.setEdit(pos);
                e = w.findElement(By.xpath(TECHNOLOGIES_DRIVE_CONTAINER.get()));
            }
            if(e != null){
                if(visibleResearchDetails(w,pos,type))
                    return true;
                e.click();
                return true;
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(Research.class.getName(),1,"While trying to click on a research: " + DataTechnology.getFromListIndex(pos));
        }
        return false;
    }

    public static int levelOfResearch(WebDriver w, int pos, Type type) {
        try {
            WebElement e = null;
            if(type == Type.BASIC){
                TECHNOLOGIES_BASIC_CONTAINER.setEdit(pos);
                e = w.findElement(By.xpath(TECHNOLOGIES_BASIC_CONTAINER.get().concat(RESEARCH_LEVEL)));
            }
            if(type == Type.ADVANCED){
                TECHNOLOGIES_ADVANCED_CONTAINER.setEdit(pos);
                e = w.findElement(By.xpath(TECHNOLOGIES_ADVANCED_CONTAINER.get().concat(RESEARCH_LEVEL)));
            }
            if(type == Type.COMBAT){
                TECHNOLOGIES_COMBAT_CONTAINER.setEdit(pos);
                e = w.findElement(By.xpath(TECHNOLOGIES_COMBAT_CONTAINER.get().concat(RESEARCH_LEVEL)));
            }
            if(type == Type.DRIVE){
                TECHNOLOGIES_DRIVE_CONTAINER.setEdit(pos);
                e = w.findElement(By.xpath(TECHNOLOGIES_DRIVE_CONTAINER.get().concat(RESEARCH_LEVEL)));
            }
            if(e != null){
                String s = e.getText();
                return Integer.parseInt(s);
            }
        }
        catch (Exception ex) {
            AppLog.printOnConsole(Research.class.getName(),1,"Doesn't download level of " + DataTechnology.getFromListIndex(pos));
        }
        return -1;
    }

    public static String dataTechnologyOfResearch(WebDriver w, int pos, Type type) {
        try {
            WebElement e = null;
            if(type == Type.BASIC){
                TECHNOLOGIES_BASIC_CONTAINER.setEdit(pos);
                e = w.findElement(By.xpath(TECHNOLOGIES_BASIC_CONTAINER.get()));
            }
            if(type == Type.ADVANCED){
                TECHNOLOGIES_ADVANCED_CONTAINER.setEdit(pos);
                e = w.findElement(By.xpath(TECHNOLOGIES_ADVANCED_CONTAINER.get()));
            }
            if(type == Type.COMBAT){
                TECHNOLOGIES_COMBAT_CONTAINER.setEdit(pos);
                e = w.findElement(By.xpath(TECHNOLOGIES_COMBAT_CONTAINER.get()));
            }
            if(type == Type.DRIVE){
                TECHNOLOGIES_DRIVE_CONTAINER.setEdit(pos);
                e = w.findElement(By.xpath(TECHNOLOGIES_DRIVE_CONTAINER.get()));
            }
            if(e != null){
                return e.getAttribute("data-technology");
            }
        }
        catch (Exception ex) {
            AppLog.printOnConsole(Research.class.getName(),1,"Doesn't download data technology of " + DataTechnology.getFromListIndex(pos));
        }
        return "-1";
    }

    public static String localNameOfResearch(WebDriver w, int pos, Type type) {
        try {
            WebElement e = null;
            if(type == Type.BASIC){
                TECHNOLOGIES_BASIC_CONTAINER.setEdit(pos);
                e = w.findElement(By.xpath(TECHNOLOGIES_BASIC_CONTAINER.get()));
            }
            if(type == Type.ADVANCED){
                TECHNOLOGIES_ADVANCED_CONTAINER.setEdit(pos);
                e = w.findElement(By.xpath(TECHNOLOGIES_ADVANCED_CONTAINER.get()));
            }
            if(type == Type.COMBAT){
                TECHNOLOGIES_COMBAT_CONTAINER.setEdit(pos);
                e = w.findElement(By.xpath(TECHNOLOGIES_COMBAT_CONTAINER.get()));
            }
            if(type == Type.DRIVE){
                TECHNOLOGIES_DRIVE_CONTAINER.setEdit(pos);
                e = w.findElement(By.xpath(TECHNOLOGIES_DRIVE_CONTAINER.get()));
            }
            if(e != null)
                return e.getAttribute("aria-label");

        }
        catch (Exception ex) {
            AppLog.printOnConsole(Research.class.getName(),1,"Doesn't download local name of " + DataTechnology.getFromListIndex(pos));
        }
        return "null";
    }
}
