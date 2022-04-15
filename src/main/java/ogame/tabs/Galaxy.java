package ogame.tabs;

import ogame.ContentWrapper;
import ogame.OgameWeb;
import ogame.galaxy.*;
import ogame.DataTechnology;
import ogame.FinalXPath;
import ogame.planets.Coordinate;
import ogame.planets.Resources;
import ogame.ships.Ship;
import ogame.utils.StringFactory;
import ogame.utils.WebElementPath;
import ogame.utils.WebElementUtil;
import ogame.utils.log.AppLog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Galaxy {

    private static final String GALAXY_COMPONENT_ID = "galaxycomponent";
    private static final String GALAXY_BUTTON = "//*[@id=\"menuTable\"]/li[9]/a";
    private static final String EMPTY_GALAXY_ROW_CLASS = "empty_filter";
    private static final String PREVIOUS_GALAXY = "//*[@id=\"galaxyHeader\"]/form/span[2]";
    private static final String NEXT_GALAXY = "//*[@id=\"galaxyHeader\"]/form/span[3]";
    private static final String PREVIOUS_SYSTEM = "//*[@id=\"galaxyHeader\"]/form/span[5]";
    private static final String NEXT_SYSTEM = "//*[@id=\"galaxyHeader\"]/form/span[6]";
    private static final String INPUT_GALAXY = "//*[@id=\"galaxy_input\"]";
    private static final String INPUT_SYSTEM = "//*[@id=\"system_input\"]";
    private static final String CHANGE_COORDINATE = "//*[@id=\"galaxyHeader\"]/form/div[1]";
    private static final String EXPEDITION_DEBRIS = "//*[@id=\"expeditionDebris\"]";

    private static final WebElementPath GALAXY_ROW = new WebElementPath("//*[@id=\"galaxyRow","\"]");
    private static final String ACTIVE_ALERT_PLANET = "/div[2]/a/div/div[1]";
    private static final String PLANET_NAME = "/div[3]/span";
    private static final String ACTIVE_ALERT_MOON = "/div[4]/a/div/div[1]";
    private static final String PLAYER = "/div[6]/span[1]";
    private static final String PLAYER_STATUS = "/div[6]/span[2]";
    private static final String ALLIANCE = "/div[7]/span";
    private static final String SEND_ESPIONAGE = "/div[8]/a[1]";
    private static final String OPEN_CHAT = "/div[8]/a[2]";
    private static final String SEND_MISSILE = "/div[8]/a[4]";
    private static final String PLANET_INFO = "/div[2]/a";
    private static final String PLANET_DEBRIS_INFO = "/div[5]/a";

    private static final WebElementPath MOON_ON_GALAXY_ROW = new WebElementPath("//*[@id=\"moon","\"]");

    private static final WebElementPath DEBRIS_ON_GALAXY_ROW = new WebElementPath("//*[@id=\"debris","\"]");
    private static final String METAL_VALUE_ON_DEBRIS = "/ul[2]/li[1]";
    private static final String CRYSTAL_VALUE_ON_DEBRIS = "/ul[2]/li[2]";
    private static final String REQUIRED_SHIPS = "/ul[2]/li[3]";


    public static boolean visible(WebDriver w) {
        try{
            //Check 1
            WebElement e =  w.findElement(By.xpath(GALAXY_BUTTON));
            String s = e.getAttribute("class");
            if(s.contains("selected"))
                return true;
            //Check 2
            e =  w.findElement(By.xpath(FinalXPath.MIDDLE_COMPONENT+"/div[2]"));
            s = e.getAttribute("id");
            return s.contains(GALAXY_COMPONENT_ID);
        }
        catch (Exception e){
            AppLog.printOnConsole(Galaxy.class.getName(),1,"When it checks, the tab is visible.");
        }
        return false;
    }
    public static boolean click(WebDriver w){
        try{
            if(visible(w)){ return true;
            }
            WebElement e =  w.findElement(By.xpath(GALAXY_BUTTON));
            e.click();
            return true;
        }
        catch (Exception e){
            AppLog.printOnConsole(Galaxy.class.getName(),1,"While trying to click on a tab.");
        }
        return false;
    }
    public static boolean inputGalaxy(WebDriver w, int amount){
        try {
            WebElement e =  w.findElement(By.xpath(INPUT_GALAXY));
            e.click();
            e.sendKeys(String.valueOf(amount));
            return true;
        }
        catch (Exception ex) {
            AppLog.printOnConsole(Defence.class.getName(),1,"While try input galaxy value.");
        }
        return false;
    }
    public static boolean inputSystem(WebDriver w, int amount){
        try {
            WebElement e =  w.findElement(By.xpath(INPUT_SYSTEM));
            e.click();
            e.sendKeys(String.valueOf(amount));
            return true;
        }
        catch (Exception ex) {
            AppLog.printOnConsole(Defence.class.getName(),1,"While try input system value.");
        }
        return false;
    }

    public static boolean changeCoordinate(WebDriver w){
        try{
            WebElement e =  w.findElement(By.xpath(CHANGE_COORDINATE));
            e.click();
            return true;
        }
        catch (Exception e){
            AppLog.printOnConsole(Galaxy.class.getName(),1,"While trying to click on change coordinate button.");
        }
        return false;
    }

    public static boolean previousGalaxy(WebDriver w){
        try{
            WebElement e =  w.findElement(By.xpath(PREVIOUS_GALAXY));
            e.click();
            return true;
        }
        catch (Exception e){
            AppLog.printOnConsole(Galaxy.class.getName(),1,"While trying to click on previous galaxy button.");
        }
        return false;
    }

    public static boolean nextGalaxy(WebDriver w){
        try{
            WebElement e =  w.findElement(By.xpath(NEXT_GALAXY));
            e.click();
            return true;
        }
        catch (Exception e){
            AppLog.printOnConsole(Galaxy.class.getName(),1,"While trying to click on next galaxy button.");
        }
        return false;
    }

    public static boolean previousSystem(WebDriver w){
        try{
            WebElement e =  w.findElement(By.xpath(PREVIOUS_SYSTEM));
            e.click();
            return true;
        }
        catch (Exception e){
            AppLog.printOnConsole(Galaxy.class.getName(),1,"While trying to click on previous system button.");
        }
        return false;
    }

    public static boolean nextSystem(WebDriver w){
        try{
            WebElement e =  w.findElement(By.xpath(NEXT_SYSTEM));
            e.click();
            return true;
        }
        catch (Exception e){
            AppLog.printOnConsole(Galaxy.class.getName(),1,"While trying to click on next system button.");
        }
        return false;
    }

    public static List<Integer> colonizedPlanet(WebDriver w){
        List<Integer> colonizedPlanet = new ArrayList<>();
        for(int i = 1; i <= 15; i++){
            GALAXY_ROW.setEdit(i);
            try{
                WebElement element = w.findElement(By.xpath(GALAXY_ROW.get()));
                if(!WebElementUtil.attrContainsText(element,"class",EMPTY_GALAXY_ROW_CLASS))
                    colonizedPlanet.add(i);
            }catch (Exception ex){
                AppLog.printOnConsole(Galaxy.class.getName(),1,"While trying download colonized planet.");
            }
        }
        return colonizedPlanet;
    }
    public static Coordinate selectedCoordinate(WebDriver w){
        List<Integer> colonizedPlanet = colonizedPlanet(w);
        if(!colonizedPlanet.isEmpty()){
            GALAXY_ROW.setEdit(colonizedPlanet.get(0));

            try{
                WebElement webElement = w.findElement(By.xpath(GALAXY_ROW.get().concat(PLANET_INFO)));
                String attr = webElement.getAttribute("onclick");
                String [] tmp = attr.split(",");
                return new Coordinate(
                        Integer.parseInt(tmp[1].replaceFirst(" ","")),
                        Integer.parseInt(tmp[2].replaceFirst(" ","")),
                        Integer.parseInt(tmp[3].replaceFirst(" ","")));
            }catch (Exception ex){
                AppLog.printOnConsole(Galaxy.class.getName(),1,"While trying get selected coordinate.");
            }
        }
        return new Coordinate(0,0,0);
    }

    public static boolean showPlanetCoordinate(WebDriver webDriver, int planetCoordinate){
        if(hasPlanetDebris(webDriver, planetCoordinate)){
            GALAXY_ROW.setEdit(planetCoordinate);
            WebElement webElement = webDriver.findElement(By.xpath(GALAXY_ROW.get().concat(PLANET_INFO)));
            WebElementUtil.scrollToElement(webDriver,webElement);
            WebElementUtil.moveCursorToElement(webDriver,webElement);
            return ContentWrapper.isVisible(webDriver);
        }
        return false;
    }
    public static ActiveAlert activeAlertPlanet(WebDriver w, int planetCoordinate){
        GALAXY_ROW.setEdit(planetCoordinate);
        try{
            WebElement element = w.findElement(By.xpath(GALAXY_ROW.get().concat(ACTIVE_ALERT_PLANET)));
            if(WebElementUtil.attrContainsText(element,"class","activity ")){
                String alertValue = element.getText();
                int timeInMinutes = Integer.parseInt(alertValue.isEmpty() ? "0" : alertValue);
                return new ActiveAlert(timeInMinutes);
            }
        }catch (Exception ex){
            AppLog.printOnConsole(Galaxy.class.getName(),1,"While trying get active alert planet "+ planetCoordinate+".");
        }
        return null;
    }
    public static ActiveAlert activeAlertMoon(WebDriver w, int planetCoordinate){
        GALAXY_ROW.setEdit(planetCoordinate);
        try{
            WebElement element = w.findElement(By.xpath(GALAXY_ROW.get().concat(ACTIVE_ALERT_MOON)));
            int timeInMinutes = Integer.parseInt(element.getText());
            return new ActiveAlert(timeInMinutes);
        }catch (Exception ex){
            AppLog.printOnConsole(Galaxy.class.getName(),1,"While trying get active alert on moon position " + planetCoordinate +".");
        }
        return null;
    }

    private static String planetName(WebDriver w, int planetCoordinate){
        GALAXY_ROW.setEdit(planetCoordinate);
        try{
            WebElement element = w.findElement(By.xpath(GALAXY_ROW.get().concat(PLANET_NAME)));
            return element.getText();
        }catch (Exception ex){
            AppLog.printOnConsole(Galaxy.class.getName(),1,"While trying get planet name " + planetCoordinate+".");
        }
        return "";
    }

    public static boolean hasMoon(WebDriver w, int planetCoordinate){
        MOON_ON_GALAXY_ROW.setEdit(planetCoordinate);
        try{
            WebElement element = w.findElement(By.xpath(MOON_ON_GALAXY_ROW.get()));
            return element != null;
        }catch (Exception ex){
            AppLog.printOnConsole(Galaxy.class.getName(),1,"While trying check the planet has moon " + planetCoordinate+".");
        }
        return false;
    }

    public static boolean hasPlanetDebris(WebDriver w, int planetCoordinate){
        DEBRIS_ON_GALAXY_ROW.setEdit(planetCoordinate);
        try{
            WebElement element = w.findElement(By.xpath(DEBRIS_ON_GALAXY_ROW.get()));
            return element != null;
        }catch (Exception ex){
            AppLog.printOnConsole(Galaxy.class.getName(),1,"While trying check the planet has debris " + planetCoordinate+".");
        }
        return false;
    }

    public static boolean showPlanetDebris(WebDriver webDriver, int planetCoordinate){
        if(hasPlanetDebris(webDriver, planetCoordinate)){
            GALAXY_ROW.setEdit(planetCoordinate);
            WebElement webElement = webDriver.findElement(By.xpath(GALAXY_ROW.get().concat(PLANET_DEBRIS_INFO)));
            WebElementUtil.scrollToElement(webDriver,webElement);
            WebElementUtil.moveCursorToElement(webDriver,webElement);
            return ContentWrapper.isVisible(webDriver);
        }
        return false;
    }

    public static Debris planetDebris(WebDriver w, int planetCoordinate){
        Debris debris = new Debris();
        if(hasPlanetDebris(w,planetCoordinate)){
            try {
                DEBRIS_ON_GALAXY_ROW.setEdit(planetCoordinate);
                WebElement element = w.findElement(By.xpath(DEBRIS_ON_GALAXY_ROW.get().concat(METAL_VALUE_ON_DEBRIS)));
                String metalOnDebris = element.getText();
                element = w.findElement(By.xpath(DEBRIS_ON_GALAXY_ROW.get().concat(CRYSTAL_VALUE_ON_DEBRIS)));
                String crystalOnDebris = element.getText();
                element = w.findElement(By.xpath(DEBRIS_ON_GALAXY_ROW.get().concat(REQUIRED_SHIPS)));
                String requiredShip = element.getText();
                long metal = Long.parseLong(StringFactory.deleteChars('.',metalOnDebris.split(" ")[1]));
                long crystal = Long.parseLong(StringFactory.deleteChars('.',crystalOnDebris.split(" ")[1]));
                long requiredShips = Long.parseLong(StringFactory.deleteChars('.',requiredShip.split(" ")[2]));
                debris.setResources(new Resources(metal,crystal,0L,0));
                Ship ship = new Ship(DataTechnology.RECYCLER);
                ship.setValue((int)requiredShips);
                debris.setRequiredShip(ship);
            }catch (Exception e){
                AppLog.printOnConsole(Galaxy.class.getName(),1,"While trying trying get resources on debris " + planetCoordinate+".");
            }
        }
        return debris;
    }

    public static Resources resourcesOnPlanetDebris(WebDriver w, int planetCoordinate){
        Resources resources = new Resources(0L,0L,0L,0);
        if(hasPlanetDebris(w,planetCoordinate)){
            try {
                DEBRIS_ON_GALAXY_ROW.setEdit(planetCoordinate);
                WebElement element = w.findElement(By.xpath(DEBRIS_ON_GALAXY_ROW.get().concat(METAL_VALUE_ON_DEBRIS)));
                String metalOnDebris = element.getText();
                element = w.findElement(By.xpath(DEBRIS_ON_GALAXY_ROW.get().concat(CRYSTAL_VALUE_ON_DEBRIS)));
                String crystalOnDebris = element.getText();
                long metal = Long.parseLong(StringFactory.deleteChars('.',metalOnDebris.split(" ")[1]));
                long crystal = Long.parseLong(StringFactory.deleteChars('.',crystalOnDebris.split(" ")[1]));
                resources.setMetal(metal);
                resources.setCrystal(crystal);
            }catch (Exception e){
                AppLog.printOnConsole(Galaxy.class.getName(),1,"While trying trying get resources on debris " + planetCoordinate+".");
            }
        }
        return resources;
    }

    public static String playerName(WebDriver w, int planetCoordinate){
        GALAXY_ROW.setEdit(planetCoordinate);
        try{
            WebElement element = w.findElement(By.xpath(GALAXY_ROW.get().concat(PLAYER)));
            if(isHonorRankElement(element)){
                element = w.findElement(By.xpath(GALAXY_ROW.get().concat(PLAYER_STATUS)));
            }
            return element.getText();
        }catch (Exception ex){
            AppLog.printOnConsole(Galaxy.class.getName(),1,"While trying get player name " + planetCoordinate+".");
        }
        return "";
    }

    public static String playerId(WebDriver w, int planetCoordinate){
        GALAXY_ROW.setEdit(planetCoordinate);
        try{
            WebElement element = w.findElement(By.xpath(GALAXY_ROW.get().concat(PLAYER)));
            if(isHonorRankElement(element)){
                element = w.findElement(By.xpath(GALAXY_ROW.get().concat(PLAYER_STATUS)));
            }
            return element.getAttribute("rel");
        }catch (Exception ex){
            AppLog.printOnConsole(Galaxy.class.getName(),1,"While trying get player id " + planetCoordinate+".");
        }

        return "";
    }

    public static HonorRank playerHonorRank(WebDriver w, int planetCoordinate){
        GALAXY_ROW.setEdit(planetCoordinate);
        try{
            WebElement element = w.findElement(By.xpath(GALAXY_ROW.get().concat(PLAYER)));
            if(isHonorRankElement(element)){
                if(WebElementUtil.attrContainsText(element,"class","starlord"))
                    return HonorRank.STAR_LORD;
                else
                    return HonorRank.BANDIT;
            }
        }catch (Exception ex){
            AppLog.printOnConsole(Galaxy.class.getName(),1,"While trying get honor ranks " + planetCoordinate+".");
        }
        return HonorRank.NONE;
    }

    public static PlayerStatus playerStatus(WebDriver w, int planetCoordinate){
        GALAXY_ROW.setEdit(planetCoordinate);
        try{
            WebElement element = w.findElement(By.xpath(GALAXY_ROW.get().concat(PLAYER)));
            boolean isHonorRankElement = isHonorRankElement(element);
            if(isHonorRankElement)
                element = w.findElement(By.xpath(GALAXY_ROW.get().concat(PLAYER_STATUS)));
            if(WebElementUtil.attrContainsText(element,"class","status_abbr_active"))
                return PlayerStatus.ACTIVE;
            if(WebElementUtil.attrContainsText(element,"class","status_abbr_inactive"))
                return PlayerStatus.INACTIVE;
            if(WebElementUtil.attrContainsText(element,"class","status_abbr_longinactive"))
                return PlayerStatus.LONG_INACTIVE;
            if(WebElementUtil.attrContainsText(element,"class","status_abbr_honorableTarget"))
                return PlayerStatus.HONORABLE_TARGET;
            if(WebElementUtil.attrContainsText(element,"class","status_abbr_vacation"))
                return PlayerStatus.VACATION;
            if(WebElementUtil.attrContainsText(element,"class","status_abbr_admin"))
                return PlayerStatus.ADMIN;

        }catch (Exception ex){
            AppLog.printOnConsole(Galaxy.class.getName(),1,"While trying get player status " + planetCoordinate+".");
        }

        return PlayerStatus.NONE;
    }

    private static boolean isHonorRankElement(WebElement element){
        return WebElementUtil.attrContainsText(element,"class","honorRank");
    }

    public static String allianceName(WebDriver w, int planetCoordinate){
        GALAXY_ROW.setEdit(planetCoordinate);
        try{
            WebElement element = w.findElement(By.xpath(GALAXY_ROW.get().concat(ALLIANCE)));
            return element.getText();
        }catch (Exception ex){
            AppLog.printOnConsole(Galaxy.class.getName(),1,"While trying get alliance name " + planetCoordinate+".");
        }
        return "";
    }

    public static String allianceId(WebDriver w, int planetCoordinate){
        GALAXY_ROW.setEdit(planetCoordinate);
        try{
            WebElement element = w.findElement(By.xpath(GALAXY_ROW.get().concat(ALLIANCE)));
            return element.getAttribute("rel");
        }catch (Exception ex){
            AppLog.printOnConsole(Galaxy.class.getName(),1,"While trying get alliance id "+ planetCoordinate+".");
        }
        return "";
    }

    public static boolean sendEspionage(WebDriver w, int planetCoordinate){
        GALAXY_ROW.setEdit(planetCoordinate);
        try{
            WebElement element = w.findElement(By.xpath(GALAXY_ROW.get().concat(SEND_ESPIONAGE)));
            element.click();
            return true;
        }catch (Exception ex){
            AppLog.printOnConsole(Galaxy.class.getName(),1,"While trying send espionage "+ planetCoordinate+".");
        }
        return false;
    }
    public static boolean openChat(WebDriver w, int planetCoordinate){
        GALAXY_ROW.setEdit(planetCoordinate);
        try{
            WebElement element = w.findElement(By.xpath(GALAXY_ROW.get().concat(OPEN_CHAT)));
            element.click();
            return true;
        }catch (Exception ex){
            AppLog.printOnConsole(Galaxy.class.getName(),1,"While trying open chat "+ planetCoordinate+".");
        }
        return false;
    }
    public static boolean sendMissile(WebDriver w, int planetCoordinate){
        GALAXY_ROW.setEdit(planetCoordinate);
        try{
            WebElement element = w.findElement(By.xpath(GALAXY_ROW.get().concat(SEND_MISSILE)));
            element.click();
            return true;
        }catch (Exception ex){
            AppLog.printOnConsole(Galaxy.class.getName(),1,"While trying send missile "+ planetCoordinate+".");
        }
        return false;
    }
    public static boolean showExpeditionDebris(WebDriver webDriver){
        if(hasExpeditionDebris(webDriver)){
            WebElement webElement = webDriver.findElement(By.xpath(EXPEDITION_DEBRIS));
            WebElementUtil.scrollToElement(webDriver,webElement);
            WebElementUtil.moveCursorToElement(webDriver,webElement);
            return ContentWrapper.isVisible(webDriver);
        }
        return false;
    }
    public static boolean hasExpeditionDebris(WebDriver w){
        DEBRIS_ON_GALAXY_ROW.setEdit(16);
        try{
            WebElement element = w.findElement(By.xpath(DEBRIS_ON_GALAXY_ROW.get()));
            return element != null;
        }catch (Exception ex){
            AppLog.printOnConsole(Galaxy.class.getName(),1,"While trying check the expedition debris.");
        }
            return false;
    }
    public static Debris expeditionDebris(WebDriver w){
        Debris debris = new Debris();
        if(showExpeditionDebris(w)){
            try {
                DEBRIS_ON_GALAXY_ROW.setEdit(16);
                WebElement element = w.findElement(By.xpath(DEBRIS_ON_GALAXY_ROW.get().concat(METAL_VALUE_ON_DEBRIS)));
                String metalOnDebris = element.getText();
                element = w.findElement(By.xpath(DEBRIS_ON_GALAXY_ROW.get().concat(CRYSTAL_VALUE_ON_DEBRIS)));
                String crystalOnDebris = element.getText();
                element = w.findElement(By.xpath(DEBRIS_ON_GALAXY_ROW.get().concat(REQUIRED_SHIPS)));
                String requiredShip = element.getText();
                long metal = Long.parseLong(StringFactory.deleteChars('.',metalOnDebris.split(" ")[1]));
                long crystal = Long.parseLong(StringFactory.deleteChars('.',crystalOnDebris.split(" ")[1]));
                String[] tmp = requiredShip.split(" ");
                long requiredShips = Long.parseLong(StringFactory.deleteChars('.',tmp[2]));
                debris.setResources(new Resources(metal,crystal,0L,0));
                Ship ship = new Ship(DataTechnology.EXPLORER);
                ship.setValue((int)requiredShips);
                debris.setRequiredShip(ship);
            }catch (Exception e){
                AppLog.printOnConsole(Galaxy.class.getName(),1,"While trying trying get resources on expedition debris.");
            }
        }
        return debris;
    }

    public static Resources resourcesOnExpeditionDebris(WebDriver w){
        Resources resources = new Resources(0L,0L,0L,0);
        if(showExpeditionDebris(w)){
            try {
                DEBRIS_ON_GALAXY_ROW.setEdit(16);
                WebElement element = w.findElement(By.xpath(DEBRIS_ON_GALAXY_ROW.get().concat(METAL_VALUE_ON_DEBRIS)));
                String metalOnDebris = element.getText();
                element = w.findElement(By.xpath(DEBRIS_ON_GALAXY_ROW.get().concat(CRYSTAL_VALUE_ON_DEBRIS)));
                String crystalOnDebris = element.getText();
                long metal = Long.parseLong(StringFactory.deleteChars('.',metalOnDebris.split(" ")[1]));
                long crystal = Long.parseLong(StringFactory.deleteChars('.',crystalOnDebris.split(" ")[1]));
                resources.setMetal(metal);
                resources.setCrystal(crystal);
            }catch (Exception e){
                AppLog.printOnConsole(Galaxy.class.getName(),1,"While trying trying get resources on expedition debris.");
            }
        }
        return resources;
    }

    public static GalaxyRow getGalaxyRow(WebDriver w, int planetPosition){
        List<Integer> colonizedPlanet = colonizedPlanet(w);
        GalaxyRow galaxyRow = new GalaxyRow();
        if(colonizedPlanet.contains(planetPosition)){
            Coordinate coordinate = selectedCoordinate(w);
            coordinate.setPlanet(planetPosition);
            String planetName = planetName(w,planetPosition);
            boolean moon = hasMoon(w,planetPosition);
            boolean showPlanetDebris = showPlanetDebris(w,planetPosition);
            Debris debris = new Debris();
            if(showPlanetDebris){
                debris = planetDebris(w,planetPosition);
                debris.setCoordinate(coordinate);
            }
            ActiveAlert activeAlertPlanet = activeAlertPlanet(w,planetPosition);
            ActiveAlert activeAlertMoon = activeAlertMoon(w,planetPosition);
            String playerName = playerName(w,planetPosition);
            String playerId = playerId(w,planetPosition);
            String allianceName = allianceName(w,planetPosition);
            String allianceId = allianceId(w,planetPosition);
            HonorRank honorRank = playerHonorRank(w,planetPosition);
            PlayerStatus playerStatus = playerStatus(w,planetPosition);

            galaxyRow.setCoordinate(coordinate);
            galaxyRow.setPlanetName(planetName);
            galaxyRow.setHasMoon(moon);
            galaxyRow.setHasDebris(showPlanetDebris);
            galaxyRow.setDebris(debris);
            galaxyRow.setActiveAlertPlanet(activeAlertPlanet);
            galaxyRow.setActiveAlertMoon(activeAlertMoon);
            galaxyRow.setPlayerName(playerName);
            galaxyRow.setPlayerId(playerId);
            galaxyRow.setAllianceName(allianceName);
            galaxyRow.setAllianceId(allianceId);
            galaxyRow.setHonorRank(honorRank);
            galaxyRow.setPlayerStatus(playerStatus);
        }
        return galaxyRow;
    }
    public static List<GalaxyRow> getGalaxyRows(WebDriver w){
        List<GalaxyRow> galaxyRows = new ArrayList<>();
        List<Integer> colonizedPlanet = colonizedPlanet(w);
        Coordinate coordinate = selectedCoordinate(w);
        for(int planetPosition : colonizedPlanet){
            GalaxyRow galaxyRow = new GalaxyRow();
            coordinate.setPlanet(planetPosition);
            String planetName = planetName(w,planetPosition);
            boolean moon = hasMoon(w,planetPosition);
            boolean showPlanetDebris = showPlanetDebris(w,planetPosition);
            Debris debris = new Debris();
            if(showPlanetDebris){
                debris = planetDebris(w,planetPosition);
                debris.setCoordinate(coordinate);
            }
            ActiveAlert activeAlertPlanet = activeAlertPlanet(w,planetPosition);
            ActiveAlert activeAlertMoon = activeAlertMoon(w,planetPosition);
            String playerName = playerName(w,planetPosition);
            String playerId = playerId(w,planetPosition);
            String allianceName = allianceName(w,planetPosition);
            String allianceId = allianceId(w,planetPosition);
            HonorRank honorRank = playerHonorRank(w,planetPosition);
            PlayerStatus playerStatus = playerStatus(w,planetPosition);

            galaxyRow.setCoordinate(new Coordinate(coordinate.getText()));
            galaxyRow.setPlanetName(planetName);
            galaxyRow.setHasMoon(moon);
            galaxyRow.setHasDebris(showPlanetDebris);
            galaxyRow.setDebris(debris);
            galaxyRow.setActiveAlertPlanet(activeAlertPlanet);
            galaxyRow.setActiveAlertMoon(activeAlertMoon);
            galaxyRow.setPlayerName(playerName);
            galaxyRow.setPlayerId(playerId);
            galaxyRow.setAllianceName(allianceName);
            galaxyRow.setAllianceId(allianceId);
            galaxyRow.setHonorRank(honorRank);
            galaxyRow.setPlayerStatus(playerStatus);

            galaxyRows.add(galaxyRow);
        }
        return galaxyRows;
    }

    public static boolean isDeclaredCoordinateSelected(WebDriver webDriver, Coordinate declaredCoordinate){
        Coordinate currentGalaxyCoordinate = selectedCoordinate(webDriver);
        return currentGalaxyCoordinate.equals(declaredCoordinate);
    }

    public static boolean inputDeclaredCoordinate(WebDriver webDriver, Coordinate declaredCoordinate){
        boolean inputGalaxy = inputGalaxy(webDriver,declaredCoordinate.getGalaxy());
        boolean inputSystem = inputSystem(webDriver, declaredCoordinate.getSystem());

        if(inputGalaxy && inputSystem)
            return  changeCoordinate(webDriver);
        else
            return false;
    }
}
