package ogame.utils;

import org.openqa.selenium.WebElement;

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
        return element.getAttribute(attr).contains(s);
    }
}
