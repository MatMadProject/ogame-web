package ogame.planets;

import ogame.OgameWeb;
import ogame.tabs.Overview;
import ogame.utils.WebElementPath;
import ogame.utils.WebElementUtil;
import ogame.utils.log.AppLog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PlanetsList {

    private static final String PLANETS_LIST_CONTAINER = "//*[@id=\"planetList\"]";
    private static final String NUMBER_OF_PLANETS = "//*[@id=\"countColonies\"]/p/span";
    private static final String PLANET_IMAGE = "/a[1]/img";
    private static final String MOON_IMAGE = "/a[2]/img";
    private static final String HIGHTLIGHT_PLANET = "hightlightPlanet";
    private static final String HIGHTLIGHT_MOON = "hightlightMoon";
    private static final String CONTAINS_MOON = "moonlink";
    private static final WebElementPath PLANET_CONTAINER = new WebElementPath(PLANETS_LIST_CONTAINER.concat("/div["),"]");
    private static final WebElementPath NAME_OF_PLANET = new WebElementPath(PLANETS_LIST_CONTAINER.concat("/div["),"]/a[1]/span[1]");
    private static final WebElementPath COORDINATE_OF_PLANET = new WebElementPath(PLANETS_LIST_CONTAINER.concat("/div["),"]/a[1]/span[2]");

    public static int numberOfPlanet(WebDriver w) {
        try {
            WebElement e = w.findElement(By.xpath(NUMBER_OF_PLANETS));
            String[] tab = e.getText().split("/");
            return Integer.parseInt(tab[0]);
        }
        catch (Exception ex) {
            AppLog.printOnConsole(Overview.class.getName(),1,"Doesn't download number of planets.");
            return -1;
        }
    }

    public static String nameOfPlanet(WebDriver w, int pos){
        int a = numberOfPlanet(w);
        if(pos <= a){
            NAME_OF_PLANET.setEdit(pos);
            WebElement e = w.findElement(By.xpath(NAME_OF_PLANET.get()));
            return e.getText();
        }
        return null;
    }

    public static String coordinateOfPlanet(WebDriver w, int pos){
        int a = numberOfPlanet(w);
        if(pos <= a){
            COORDINATE_OF_PLANET.setEdit(pos);
            WebElement e = w.findElement(By.xpath(COORDINATE_OF_PLANET.get()));
            return e.getText();
        }
        return null;
    }

    public static int maxNumberOfPlanet(WebDriver w) {
        try {
            WebElement e = w.findElement(By.xpath(NUMBER_OF_PLANETS));
            String[] tab = e.getText().split("/");
            return Integer.parseInt(tab[1]);
        }
        catch (Exception ex) {
            AppLog.printOnConsole(Overview.class.getName(),1,"Doesn't download maximum number of planets.");
            return -1;
        }
    }

    /**
     * @param pos Planet position on list.
     */
    public static String planetID(WebDriver w, int pos) {
        int a = numberOfPlanet(w);
        if(pos <= a){
            PLANET_CONTAINER.setEdit(pos);
            WebElement e = w.findElement(By.xpath(PLANET_CONTAINER.get()));
            return e.getAttribute("id");
        }
        return null;
    }



    public static Planet selectedPlanet(WebDriver w){
        int a = numberOfPlanet(w);
        WebElement e;
        for(int pos = 1; pos <= a; pos++){
            PLANET_CONTAINER.setEdit(pos);
            e = w.findElement(By.xpath(PLANET_CONTAINER.get()));
            String tmp = e.getAttribute("class");
            if(tmp.contains(HIGHTLIGHT_PLANET))
                return new Planet(planetID(w,pos), pos);
        }
        return null;
    }

    public static Planet selectedMoon(WebDriver w){
        int a = numberOfPlanet(w);
        WebElement e;
        for(int pos = 1; pos <= a; pos++){
            PLANET_CONTAINER.setEdit(pos);
            e = w.findElement(By.xpath(PLANET_CONTAINER.get()));
            String tmp = e.getAttribute("class");
            if(tmp.contains(HIGHTLIGHT_MOON))
                return new Planet(planetID(w,pos), pos);
        }
        return null;
    }



    public static boolean clickOnPlanet(WebDriver w, int pos){
        int a = numberOfPlanet(w);
        if(pos <= a){
            Planet selectedPlanet = selectedPlanet(OgameWeb.webDriver);
            if(selectedPlanet != null && selectedPlanet.getPositionOnList() == pos)
                return true;

            PLANET_CONTAINER.setEdit(pos);
            WebElement e = w.findElement(By.xpath(PLANET_CONTAINER.get().concat(PLANET_IMAGE)));
            OgameWeb.scrollToElement(e);
            e.click();
            return true;
        }
        return false;
    }

    public static boolean clickOnMoon(WebDriver w, int pos){
        int a = numberOfPlanet(w);
        if(pos <= a){
            Planet selectedPlanet = selectedMoon(OgameWeb.webDriver);
            if(selectedPlanet != null && selectedPlanet.getPositionOnList() == pos)
                return true;
            PLANET_CONTAINER.setEdit(pos);
            WebElement e = w.findElement(By.xpath(PLANET_CONTAINER.get().concat(MOON_IMAGE)));
            OgameWeb.scrollToElement(e);
            e.click();
            return true;
        }
        return false;
    }

    public static boolean planetHasMoon(WebDriver w, int pos){
        int a = numberOfPlanet(w);
        if(pos <= a){
            PLANET_CONTAINER.setEdit(pos);
            WebElement e = w.findElement(By.xpath(PLANET_CONTAINER.get()));
            List<WebElement> list =e.findElements(By.tagName("a"));
            return WebElementUtil.classContainsAttr(list,"class",CONTAINS_MOON);
        }
        return false;
    }
}
