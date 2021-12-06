package ogame.tabs;

import ogame.FinalXPath;
import ogame.ships.DataTechnology;
import ogame.ships.Mission;
import ogame.ships.Type;
import ogame.utils.WebElementPath;
import ogame.utils.WebElementUtil;
import ogame.utils.log.AppLog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class FleetDispatch {

    private static final String FLEET_DISPATCH_BUTTON = "//*[@id=\"menuTable\"]/li[8]/a";
    private static final String FLEET_DISPATCH_COMPONENT_ID = "fleetdispatchcomponent";
    private static final String WARNING_NO_FLEET_ON_PLANET = "//*[@id=\"warning\"]";
    private static final String FLEET_SLOTS = "//*[@id=\"slots\"]/div[1]/span";
    private static final String EXPEDITON_SLOTS = "//*[@id=\"slots\"]/div[2]/span";
    private static final String SEND_ALL = "//*[@id=\"sendall\"]";
    private static final String RESET_ALL = "//*[@id=\"resetall\"]";
    private static final String CONTINUE_TO_FLEET_2 = "//*[@id=\"continueToFleet2\"]";
    private static final String FLEET_1_CONTENT = "//*[@id=\"fleet1\"]";
    private static final String FLEET_2_CONTENT = "//*[@id=\"fleet2\"]";
    private static final String DISTANCE = "//*[@id=\"distanceValue\"]";
    private static final String TARGET_PLANET = " //*[@id=\"pbutton\"]";
    private static final String TARGET_MOON = " //*[@id=\"mbutton\"]";
    private static final String TARGET_DEBRIS = " //*[@id=\"dbutton\"]";
    private static final String SELECTED = "selected";
    private static final String TARGET_COORDINATE = "//*[@id=\"targetPlanet\"]";
    private static final String TARGET_PLANET_NAME = TARGET_COORDINATE;
    private static final String TARGET_PLAYER_NAME = "//*[@id=\"statusBarFleet\"]/ul/li[3]/span[2]";
    private static final String TARGET_GALAXY = "//*[@id=\"galaxy\"]";
    private static final String TARGET_SYSTEM = "//*[@id=\"system\"]";
    private static final String TARGET_POSITION = "//*[@id=\"position\"]";
    private static final String FLY_DURATION = "//*[@id=\"duration\"]";
    private static final String DEUTER_CONSUMPTION = "//*[@id=\"consumption\"]/span";
    private static final String FREE_STORAGE = "//*[@id=\"storage\"]/span";
    private static final String MAX_STORAGE = "//*[@id=\"maxresources\"]";
    private static final String ALL_RESOURCES = "//*[@id=\"allresources\"]/img";
    private static final String MAX_METAL = "//*[@id=\"selectMaxMetal\"]/img";
    private static final String MAX_CRYSTAL = "//*[@id=\"selectMaxCrystal\"]/img";
    private static final String MAX_DEUTERIUM = "//*[@id=\"selectMaxDeuterium\"]/img";
    private static final String MIN_METAL = "//*[@id=\"selectMinMetal\"]/img";
    private static final String MIN_CRYSTAL = "//*[@id=\"selectMinCrystal\"]/img";
    private static final String MIN_DEUTERIUM = "//*[@id=\"selectMinDeuterium\"]/img";
    private static final String INPUT_METAL = "//*[@id=\"metal\"]";
    private static final String INPUT_CRYSTAL = "//*[@id=\"crystal\"]";
    private static final String INPUT_DEUTERIUM = "//*[@id=\"deuterium\"]";
    private static final String SEND_FLEET_BUTTON = "//*[@id=\"sendFleet\"]";

    private static final WebElementPath MISSIONS_CONTAINER_TAG_A = new WebElementPath("//*[@id=\"missions\"]/li[","]/a");
    private static final WebElementPath MISSIONS_CONTAINER = new WebElementPath("//*[@id=\"missions\"]/li[","]");
    private static final WebElementPath SPEED_CONTAINER = new WebElementPath("//*[@id=\"speedPercentage\"]/div[2]/div[","]");
    private static final WebElementPath MILITARY_SHIP_CONTENER = new WebElementPath("//*[@id=\"military\"]/li[","]/span");
    private static final WebElementPath MILITARY_SHIP_INPUT = new WebElementPath("//*[@id=\"military\"]/li[","]/input");
    private static final WebElementPath CIVIL_SHIP_CONTENER = new WebElementPath("//*[@id=\"civil\"]/li[","]/span");
    private static final WebElementPath CIVIL_SHIP_INPUT = new WebElementPath("//*[@id=\"civil\"]/li[","]/input");

    public static boolean visible(WebDriver w) {
        try{
            //Sprawdzenie 1
            WebElement e =  w.findElement(By.xpath(FLEET_DISPATCH_BUTTON));
            String s = e.getAttribute("class");
            if(s.contains("selected"))
                return true;
            //Sprawdzenie 2
            e =  w.findElement(By.xpath(FinalXPath.MIDDLE_COMPONENT+"/div[2]"));
            s = e.getAttribute("id");
            return s.contains(FLEET_DISPATCH_COMPONENT_ID);
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"When it checks, the tab is visible.");
        }
        return false;
    }

    public static boolean isFleet1Visible(WebDriver w){
        try{
            //Sprawdzenie 1
            WebElement e =  w.findElement(By.xpath(FLEET_1_CONTENT));
            return !WebElementUtil.attrContainsText(e,"style","none");
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"When it checks, the fleet 1 is visible.");
        }
        return false;
    }

    public static boolean isFleet2Visible(WebDriver w){
        try{
            //Sprawdzenie 1
            WebElement e =  w.findElement(By.xpath(FLEET_2_CONTENT));
            return !WebElementUtil.attrContainsText(e,"style","none");
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"When it checks, the fleet 2 is visible.");
        }
        return false;
    }

    /**
     * Checks is any ship on planet.
     * @param w ***
     * @return Returns true if is one ship or more on planet.
     */
    public static boolean isAnyFleetOnPlanet(WebDriver w){
        try{
            WebElement e =  w.findElement(By.xpath(WARNING_NO_FLEET_ON_PLANET));
            return false;
        } catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"When it checks is any fleet on planet.");
        }
        return true;
    }

    public static boolean sendAll(WebDriver w){
        try{
            if(visible(w)){
                WebElement e =  w.findElement(By.xpath(SEND_ALL));
                WebElementUtil.scrollToElement(w,e);
                e.click();
                return true;
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While trying send all ships.");
        }
        return false;
    }

    public static boolean resetAll(WebDriver w){
        try{
            if(visible(w)){
                WebElement e =  w.findElement(By.xpath(RESET_ALL));
                WebElementUtil.scrollToElement(w,e);
                e.click();
                return true;
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While trying reset all ships.");
        }
        return false;
    }

    public static boolean clickContinueToFleet2(WebDriver w){
        try{
            if(visible(w)){
                WebElement e =  w.findElement(By.xpath(CONTINUE_TO_FLEET_2));
                WebElementUtil.scrollToElement(w,e);
                e.click();
                return true;
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While trying click continue to fleet 2.");
        }
        return false;
    }
    public static boolean isClickContinueToFleet2ON(WebDriver w){
        try{
            if(visible(w)){
                WebElement e =  w.findElement(By.xpath(CONTINUE_TO_FLEET_2));
                return WebElementUtil.attrContainsText(e,"class","continue on");
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While trying download data from button continue to fleet 2.");
        }
        return false;
    }

    public static boolean click(WebDriver w){
        try{
            WebElement e =  w.findElement(By.xpath(FLEET_DISPATCH_BUTTON));
            e.click();
            return true;
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While trying to click on a tab.");
        }
        return false;
    }

    public static int maxFleetSlots(WebDriver w){
        if(visible(w)){
            try{
                WebElement e =  w.findElement(By.xpath(FLEET_SLOTS));
                String slots = e.getText();
                return Integer.parseInt(slots.split(":")[1].split("/")[1]);
            }
            catch (Exception e){
                AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While trying download max fleet slots.");
            }
        }
        return -1;
    }

    public static int currentFleetSlots(WebDriver w){
        if(visible(w)){
            try{
                WebElement e =  w.findElement(By.xpath(FLEET_SLOTS));
                String slots = e.getText();
                return Integer.parseInt(slots.split(":")[1].split("/")[0]);
            }
            catch (Exception e){
                AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While trying download current fleet slots.");
            }
        }
        return -1;
    }

    public static int maxExpeditionSlots(WebDriver w){
        if(visible(w)){
            try{
                WebElement e =  w.findElement(By.xpath(EXPEDITON_SLOTS));
                String slots = e.getText();
                return Integer.parseInt(slots.split(":")[1].split("/")[1]);
            }
            catch (Exception e){
                AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While trying download max expedition slots.");
            }
        }
        return -1;
    }

    public static int currentExpeditionSlots(WebDriver w){
        if(visible(w)){
            try{
                WebElement e =  w.findElement(By.xpath(EXPEDITON_SLOTS));
                String slots = e.getText();
                return Integer.parseInt(slots.split(":")[1].split("/")[0].replace(" ",""));
            }
            catch (Exception e){
                AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While trying download current expedition slots.");
            }
        }
        return -1;
    }

    public static int distance(WebDriver w){
        if(isFleet2Visible(w)){
            try{
                WebElement e =  w.findElement(By.xpath(DISTANCE));
                String distance = e.getText();
                return Integer.parseInt(distance.replace(".",""));
            }
            catch (Exception e){
                AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While trying download distance.");
            }
        }
        return -1;
    }

    public static boolean clickTargetPlanet(WebDriver w){
        try{
            if(isFleet2Visible(w)){
                WebElement e =  w.findElement(By.xpath(TARGET_PLANET));
                WebElementUtil.scrollToElement(w,e);
                e.click();
                return true;
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While trying click target planet.");
        }
        return false;
    }

    public static boolean isTargetPlanetSelected(WebDriver w){
        try{
            if(isFleet2Visible(w)){
                WebElement e =  w.findElement(By.xpath(TARGET_PLANET));
                return WebElementUtil.attrContainsText(e,"class",SELECTED);
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While trying download is target planet selected.");
        }
        return false;
    }

    public static boolean clickTargetMoon(WebDriver w){
        try{
            if(isFleet2Visible(w)){
                WebElement e =  w.findElement(By.xpath(TARGET_MOON));
                WebElementUtil.scrollToElement(w,e);
                e.click();
                return true;
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While trying click target moon");
        }
        return false;
    }

    public static boolean isTargetMoonSelected(WebDriver w){
        try{
            if(isFleet2Visible(w)){
                WebElement e =  w.findElement(By.xpath(TARGET_MOON));
                return WebElementUtil.attrContainsText(e,"class",SELECTED);
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While trying download is target moon selected.");
        }
        return false;
    }

    public static boolean isTargetDebrisSelected(WebDriver w){
        try{
            if(isFleet2Visible(w)){
                WebElement e =  w.findElement(By.xpath(TARGET_DEBRIS));
                return WebElementUtil.attrContainsText(e,"class",SELECTED);
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While trying download is target debris selected.");
        }
        return false;
    }

    public static boolean clickTargetDebris(WebDriver w){
        try{
            if(isFleet2Visible(w)){
                WebElement e =  w.findElement(By.xpath(TARGET_DEBRIS));
                WebElementUtil.scrollToElement(w,e);
                e.click();
                return true;
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While trying click target debris.");
        }
        return false;
    }


    public static String targetCoordinate(WebDriver w){
        try{
            if(isFleet2Visible(w)){
                WebElement e =  w.findElement(By.xpath(TARGET_COORDINATE));
                String text = e.getText();
                return text.split(" ")[0];
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While trying download target coordinate.");
        }
        return "null";
    }

    public static String targetPlanetName(WebDriver w){
        try{
            if(isFleet2Visible(w)){
                WebElement e =  w.findElement(By.xpath(TARGET_PLANET_NAME));
                String text = e.getText();
                return text.split(" ")[1];
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While trying download target planet name.");
        }
        return "null";
    }
//    @Deprecated
//    public static String targetPlayerName(WebDriver w){
//        try{
//            if(isFleet2Visible(w)){
//                WebElement e =  w.findElement(By.xpath(TARGET_PLAYER_NAME));
//                String text = e.getText();
//                return text;
//            }
//        }
//        catch (Exception e){
//            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While trying download target player name.");
//        }
//        return "null";
//    }

    public static boolean setGalaxy(WebDriver w, int galaxy){
        try{
            if(isFleet2Visible(w)){
                WebElement e =  w.findElement(By.xpath(TARGET_GALAXY));
                e.click();
                e.sendKeys(String.valueOf(galaxy));
                return true;
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While trying set galaxy.");
        }
        return false;
    }

    public static boolean setSystem(WebDriver w, int system){
        try{
            if(isFleet2Visible(w)){
                WebElement e =  w.findElement(By.xpath(TARGET_SYSTEM));
                e.click();
                e.sendKeys(String.valueOf(system));
                return true;
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While trying set system.");
        }
        return false;
    }

    public static boolean setPosition(WebDriver w, int position){
        try{
            if(isFleet2Visible(w)){
                WebElement e =  w.findElement(By.xpath(TARGET_POSITION));
                e.click();
                e.sendKeys(String.valueOf(position));
                return true;
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While trying set position.");
        }
        return false;
    }

    public static boolean selectMission(WebDriver w, Mission mission){
        try{
            if(isFleet2Visible(w)){
                MISSIONS_CONTAINER_TAG_A.setEdit(mission.getListIndex());
                WebElement e =  w.findElement(By.xpath(MISSIONS_CONTAINER_TAG_A.get()));
                WebElementUtil.scrollToElement(w,e);
                e.click();
                return true;
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While try select mission.");
        }
        return false;
    }

    public static boolean isMissionSelected(WebDriver w, Mission mission){
        try{
            if(isFleet2Visible(w)){
                MISSIONS_CONTAINER_TAG_A.setEdit(mission.getListIndex());
                WebElement e =  w.findElement(By.xpath(MISSIONS_CONTAINER_TAG_A.get()));
                return WebElementUtil.attrContainsText(e,"class","selected");
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While try checks is mission.");
        }
        return false;
    }

    public static Mission selectedMission(WebDriver w){
        try{
            if(isFleet2Visible(w)){
                for(int i = 1; i <= 10; i++){
                    MISSIONS_CONTAINER_TAG_A.setEdit(i);
                    WebElement e =  w.findElement(By.xpath(MISSIONS_CONTAINER_TAG_A.get()));
                    if(WebElementUtil.attrContainsText(e,"class","selected"))
                        return Mission.getFromListIndex(i);
                }
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While try downloads selected mission.");
        }
        return null;
    }

    public static ArrayList<Mission> onMissions(WebDriver w){
        ArrayList<Mission> listMissions = new ArrayList<>();
        try{
            if(isFleet2Visible(w)){
                for(int i = 1; i <= 10; i++){
                    MISSIONS_CONTAINER.setEdit(i);
                    WebElement e =  w.findElement(By.xpath(MISSIONS_CONTAINER.get()));
                    if(WebElementUtil.attrContainsText(e,"class","on"))
                        listMissions.add(Mission.getFromListIndex(i));
                }
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While try downloads on missions.");
        }
        return listMissions;
    }

    public static ArrayList<Mission> offMissions(WebDriver w){
        ArrayList<Mission> listMissions = new ArrayList<>();
        try{
            if(isFleet2Visible(w)){
                for(int i = 1; i <= 10; i++){
                    MISSIONS_CONTAINER.setEdit(i);
                    WebElement e =  w.findElement(By.xpath(MISSIONS_CONTAINER.get()));
                    if(WebElementUtil.attrContainsText(e,"class","off"))
                        listMissions.add(Mission.getFromListIndex(i));
                }
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While try downloads off missions.");
        }
        return listMissions;
    }

    public static long flyDurationMilliseconds(WebDriver w){
        try{
            if(isFleet2Visible(w)){
                WebElement e =  w.findElement(By.xpath(FLY_DURATION));
                String flyDuration = e.getText();
                String [] time = flyDuration.split(" ")[0].split(":");
                int sec = Integer.parseInt(time[2]);
                int min = Integer.parseInt(time[1]);
                int hour = Integer.parseInt(time[0]);
                return sec * 1000L + min * 60 * 1000L + hour * 3600 * 1000L;
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While try downloads fly duration.");
        }
        return -1L;
    }

    public static long deuteriumConsumption(WebDriver w){
        try{
            if(isFleet2Visible(w)){
                WebElement e =  w.findElement(By.xpath(DEUTER_CONSUMPTION));
                String deuterconsumption = e.getText();
                return Long.parseLong(deuterconsumption.split(" ")[0].replace(".",""));
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While try downloads fly duration.");
        }
        return -1L;
    }

    public static long freeStorage(WebDriver w){
        try{
            if(isFleet2Visible(w)){
                WebElement e =  w.findElement(By.xpath(FREE_STORAGE));
                String freeStorage = e.getText();
                return Long.parseLong(freeStorage.replace(".",""));
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While try downloads free storage.");
        }
        return -1L;
    }

    public static long maxStorage(WebDriver w){
        try{
            if(isFleet2Visible(w)){
                WebElement e =  w.findElement(By.xpath(MAX_STORAGE));
                String freeStorage = e.getText();
                return Long.parseLong(freeStorage.replace(".",""));
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While try downloads max storage.");
        }
        return -1L;
    }

    public static boolean allResources(WebDriver w){
        try{
            if(isFleet2Visible(w)){
                WebElement e =  w.findElement(By.xpath(ALL_RESOURCES));
                WebElementUtil.scrollToElement(w,e);
                e.click();
                return true;
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While try click all resources.");
        }
        return false;
    }

    public static boolean maxMetal(WebDriver w){
        try{
            if(isFleet2Visible(w)){
                WebElement e =  w.findElement(By.xpath(MAX_METAL));
                WebElementUtil.scrollToElement(w,e);
                e.click();
                return true;
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While try click max metal.");
        }
        return false;
    }

    public static boolean maxCrystal(WebDriver w){
        try{
            if(isFleet2Visible(w)){
                WebElement e =  w.findElement(By.xpath(MAX_CRYSTAL));
                WebElementUtil.scrollToElement(w,e);
                e.click();
                return true;
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While try click max crystal.");
        }
        return false;
    }

    public static boolean maxDeuterium(WebDriver w){
        try{
            if(isFleet2Visible(w)){
                WebElement e =  w.findElement(By.xpath(MAX_DEUTERIUM));
                WebElementUtil.scrollToElement(w,e);
                e.click();
                return true;
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While try click max deuterium.");
        }
        return false;
    }

    public static boolean minMetal(WebDriver w){
        try{
            if(isFleet2Visible(w)){
                WebElement e =  w.findElement(By.xpath(MIN_METAL));
                WebElementUtil.scrollToElement(w,e);
                e.click();
                return true;
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While try click min metal.");
        }
        return false;
    }

    public static boolean minCrystal(WebDriver w){
        try{
            if(isFleet2Visible(w)){
                WebElement e =  w.findElement(By.xpath(MIN_CRYSTAL));
                WebElementUtil.scrollToElement(w,e);
                e.click();
                return true;
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While try click min crystal.");
        }
        return false;
    }

    public static boolean minDeuterium(WebDriver w){
        try{
            if(isFleet2Visible(w)){
                WebElement e =  w.findElement(By.xpath(MIN_DEUTERIUM));
                WebElementUtil.scrollToElement(w,e);
                e.click();
                return true;
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While try click min deuterium.");
        }
        return false;
    }

    public static boolean setMetalValue(WebDriver w, long value){
        try{
            if(isFleet2Visible(w)){
                WebElement e =  w.findElement(By.xpath(INPUT_METAL));
                e.click();
                e.sendKeys(String.valueOf(value));
                return true;
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While trying set metal value.");
        }
        return false;
    }

    public static boolean setCrystalValue(WebDriver w, long value){
        try{
            if(isFleet2Visible(w)){
                WebElement e =  w.findElement(By.xpath(INPUT_CRYSTAL));
                e.click();
                e.sendKeys(String.valueOf(value));
                return true;
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While trying set crystal value.");
        }
        return false;
    }

    public static boolean setDeueriumValue(WebDriver w, long value){
        try{
            if(isFleet2Visible(w)){
                WebElement e =  w.findElement(By.xpath(INPUT_DEUTERIUM));
                e.click();
                e.sendKeys(String.valueOf(value));
                return true;
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While trying set deuterium value.");
        }
        return false;
    }

    /**
     * Sets spped of fleet.
     * @param w ***
     * @param speed Value [1-10]. 1 equals 10%. 10 equals 100%
     * @return Returns true if select speed.
     */
    public static boolean setSpeed(WebDriver w, int speed){
        try{
            if(speed < 0 || speed > 10){
                AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While try set speed because value is lower than 1 or higher than 10.");
                return false;
            }
            if(isFleet2Visible(w)){
                SPEED_CONTAINER.setEdit(speed);
                WebElement e =  w.findElement(By.xpath(SPEED_CONTAINER.get()));
                WebElementUtil.scrollToElement(w,e);
                e.click();
                return true;
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While try set speed.");
        }
        return false;
    }

    public static int selectedSpeed(WebDriver w){
        try{
            if(isFleet2Visible(w)){
                for(int i = 1; i <= 10; i++){
                    SPEED_CONTAINER.setEdit(i);
                    WebElement e =  w.findElement(By.xpath(SPEED_CONTAINER.get()));
                    if(WebElementUtil.attrContainsText(e,"class","selected"))
                        return i;
                }
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While try check selected speed.");
        }
        return -1;
    }

    public static boolean sendFleet(WebDriver w){
        try{
            if(isFleet2Visible(w)){
                WebElement e =  w.findElement(By.xpath(SEND_FLEET_BUTTON));
                WebElementUtil.scrollToElement(w,e);
                e.click();
                return true;
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While try send fleet.");
        }
        return false;
    }

    public static boolean setAllShips(WebDriver w, DataTechnology ship){
        try{
            if(visible(w)){
                WebElement e;
                if(ship.getType() == Type.BATTLE){
                    MILITARY_SHIP_CONTENER.setEdit(ship.getListIndex());
                    e =  w.findElement(By.xpath(MILITARY_SHIP_CONTENER.get()));
                }else{
                    CIVIL_SHIP_CONTENER.setEdit(ship.getListIndex());
                    e =  w.findElement(By.xpath(CIVIL_SHIP_CONTENER.get()));
                }
                WebElementUtil.scrollToElement(w,e);
                e.click();
                return true;
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While try set all ships " + ship);
        }
        return false;
    }

    public static boolean setValueShips(WebDriver w, DataTechnology ship, int value){
        try{
            if(visible(w)){
                WebElement e;
                if(ship.getType() == Type.BATTLE){
                    MILITARY_SHIP_INPUT.setEdit(ship.getListIndex());
                    e =  w.findElement(By.xpath(MILITARY_SHIP_INPUT.get()));
                }else{
                    CIVIL_SHIP_INPUT.setEdit(ship.getListIndex());
                    e =  w.findElement(By.xpath(CIVIL_SHIP_INPUT.get()));
                }
                WebElementUtil.scrollToElement(w,e);
                e.click();
                e.sendKeys(String.valueOf(value));
                return true;
            }
        }
        catch (Exception e){
            AppLog.printOnConsole(FleetDispatch.class.getName(),1,"While try set value of ship " + ship);
        }
        return false;
    }
}
