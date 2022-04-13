package ogame.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContentWrapper {
    public static final String CLASS_NAME = "tpd-content-wrapper";

    public static WebElement get(WebDriver webDriver){
        return webDriver.findElement(By.className(CLASS_NAME));
    }

    public static boolean isVisible(WebDriver webDriver){
        WebElement element = get(webDriver);
        if(element == null)
            return false;
        String styleVisibility = element.getAttribute("style");

        return styleVisibility.contains("visible");
    }
}
