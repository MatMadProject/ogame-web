package ogame;

import ogame.utils.log.AppLog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResourcesBar {

    public static final String METAL = "//*[@id=\"resources_metal\"]";
    public static final String CRYSTAL = "//*[@id=\"resources_crystal\"]";
    public static final String DEUTERIUM = "//*[@id=\"resources_deuterium\"]";
    public static final String DARKMATTER = "//*[@id=\"resources_darkmatter\"]";
    public static final String ENERGY_BALANCE = "//*[@id=\"resources_energy\"]";

    public static long metal(WebDriver w) {
        return value(w,METAL,"Doesn't download value of metal.");
    }
    public static long crystal(WebDriver w) {
        return value(w,CRYSTAL,"Doesn't download value of crystal.");
    }
    public static long deuterium(WebDriver w) {
        return value(w,DEUTERIUM,"Doesn't download value of deuterium.");
    }
    public static long darkmatter(WebDriver w) {
        return value(w,DARKMATTER,"Doesn't download value of darkmatter.");
    }
    public static long energyBalanace(WebDriver w) {
        return value(w,ENERGY_BALANCE,"Doesn't download value of energy.");
    }
    private static long value(WebDriver w, String xPath, String errorMsg){
        try {
            WebElement e = w.findElement(By.xpath(xPath));
            String value = e.getText().replace(".", "");
            return Long.parseLong(value);
        } catch (Exception ex) {
            AppLog.printOnConsole(ResourcesBar.class.getName(), 1, errorMsg);
        }
        return -1;
    }
}
