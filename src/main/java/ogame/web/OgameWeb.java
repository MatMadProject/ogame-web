package ogame.web;

import ogame.web.utils.log.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class OgameWeb {

    public static WebDriver webDriver = null;
    private static String path = "src/main/java/resources/chromedriver.exe";
    private static String WEB_ADRESS = null;
    public static boolean closed = false;

    public OgameWeb(String loginPage) {
        WEB_ADRESS = loginPage;
    }
    /**
     * Close Google Chrome.
     */
    public static void close() {
        AppLog.print(OgameWeb.class.getName(),0,"Google Chrome closed.");
        webDriver.quit();
        closed = true;
    }

    public static void open(){
        //Chrome
        System.setProperty("webdriver.chrome.driver", path);
        webDriver = new ChromeDriver();
        AppLog.print(OgameWeb.class.getName(),0,"Runs Google Chrome.");
        webDriver.get(WEB_ADRESS);
        AppLog.print(OgameWeb.class.getName(),0,"Web page runs. ["+WEB_ADRESS+"]");
        // Maksymalizacja okna przeglądarki
        webDriver.manage().window().maximize();
        closed = false;
    }

    /**
     * Moves page to element.
     */
    public static void scrollToElement(WebElement e) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView();", e);
    }


    public static String pageTitle(){
        return webDriver.getTitle();
    }

    /**
     * Switch tabs.
     * @param tabText Text which tab contains.
     */
    public static void switchTab(String tabText){
        Set<String> s = OgameWeb.webDriver.getWindowHandles();
        for(String child : s) {
            OgameWeb.webDriver.switchTo().window(child);
            if(OgameWeb.webDriver.getTitle().contains(tabText))
                break;
        }
    }

    public static void setPath(String path) {
        OgameWeb.path = path;
    }

    public String getPath() {
        return path;
    }
}
