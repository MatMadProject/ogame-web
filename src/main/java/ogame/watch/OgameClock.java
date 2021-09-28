package ogame.watch;

import ogame.ResourcesBar;
import ogame.utils.log.AppLog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OgameClock {
    public static final String CLOCK = "//*[@id=\"bar\"]/ul/li[9]";

    public static String date(WebDriver w){
        try {
            WebElement e = w.findElement(By.xpath(CLOCK));
            String value = e.getText().split(" ")[0];
            return value;
        } catch (Exception ex) {
            AppLog.printOnConsole(OgameClock.class.getName(), 1, "Doesn't download date.");
        }
        return "00.00.0000";
    }

    public static String time(WebDriver w){
        try {
            WebElement e = w.findElement(By.xpath(CLOCK));
            String value = e.getText().split(" ")[1];
            return value;
        } catch (Exception ex) {
            AppLog.printOnConsole(OgameClock.class.getName(), 1, "Doesn't download time.");
        }
        return "00:00:00";
    }

    public static String dateAndTime(WebDriver w){
        try {
            WebElement e = w.findElement(By.xpath(CLOCK));
            String value = e.getText();
            return value;
        } catch (Exception ex) {
            AppLog.printOnConsole(OgameClock.class.getName(), 1, "Doesn't download date and time.");
        }
        return "00.00.0000 00:00:00";
    }
}
