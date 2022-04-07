package ogame.utils;

import ogame.tabs.Supplies;
import ogame.utils.log.AppLog;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import javax.xml.bind.Element;
import java.util.List;

public class WebElementUtil
{
    /**
     * Sprawdza czy wartość atrybutu posiada określony ciąg znaków w każdym elemncie listy.
     * Checks if the attribute value contains string in every element of list.
     * @param elementList ***
     * @param attr name of attribute (e.g "class","id")
     * @param s Contained text.
     * @return If any attribute contains text, returns true.
     */
    public static boolean classContainsAttr(List<WebElement> elementList, String attr, String s){
        for(WebElement e : elementList){
            String value = e.getAttribute(attr);
            if(value.contains(s))
                return true;
        }
        return false;
    }

    /**
     * Sprawdza czy attrybut webelementu zawiera określony ciąg znaków.
     * Checks that the declared attribute of webelement contains text.
     * @param element ***
     * @param attr name of attribute (e.g "class","id")
     * @param s Contained text.
     * @return If attribute contains text, returns true.
     */
    public static boolean attrContainsText(WebElement element, String attr, String s){
//        String attrContent = element.getAttribute(attr);
        return element.getAttribute(attr).contains(s);
    }

    public static boolean isWebElementVisible(WebDriver w, String xPathElemnt){
        try{
            WebElement e =  w.findElement(By.xpath(xPathElemnt));
            return true;
        }
        catch (Exception e){
            AppLog.printOnConsole(Supplies.class.getName(),1,"When it checks, the webelement is visible.");
        }
        return false;
    }

    public static void scrollToElement(WebDriver w, WebElement e) {
        JavascriptExecutor js = (JavascriptExecutor) w;
        js.executeScript("arguments[0].scrollIntoView();", e);
    }
    public static void moveCursorToElement(WebDriver webDriver, WebElement element){
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element).perform();
    }
}
