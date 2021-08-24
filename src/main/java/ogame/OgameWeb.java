package ogame;

//import app.data.StaticStrings;
import ogame.utils.log.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OgameWeb {

    public static WebDriver webDriver = null;
    private String path = "src/main/resources/chromedriver.exe";
    private static String WEB_ADRESS = null;
    public static boolean closed = false;

    public OgameWeb(String loginPage) {
        WEB_ADRESS = loginPage;
    }
    /**
     * Close Google Chrome.
     */
    public void close() {
        AppLog.print(OgameWeb.class.getName(),0,"Google Chrome closed.");
        webDriver.quit();
        closed = true;
    }

    public void open(){
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

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
