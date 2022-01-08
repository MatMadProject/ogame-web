package ogame.tabs;

import ogame.eventbox.Event;
import ogame.eventbox.GalaxyObject;
import ogame.eventbox.Type;
import ogame.planets.Coordinate;
import ogame.ships.Mission;
import ogame.utils.WebElementPath;
import ogame.utils.WebElementUtil;
import ogame.utils.log.AppLog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class EventBoxContent {

    private static final String EVENT_BOX_CONTENT = "//*[@id=\"eventboxContent\"]";
    private static final String SHOW_BOX_CONTENT_BUTTON = "//*[@id=\"js_eventDetailsClosed\"]";
    private static final String CLOSE_BOX_CONTENT_BUTTON = "//*[@id=\"js_eventDetailsOpen\"]";
    private static final String EVENT_BOX_CONTENT_TABLE_BODY = "//*[@id=\"eventContent\"]/tbody";
    private static final String TYPE = "/td[1]/span";
    private static final String ORIGIN_OBJECT = "/td[4]/figure";
    private static final String ORIGIN_COORD = "/td[5]/a";
    private static final String FLEET_DETAILS = "/td[7]/span";
    private static final String DESTINATION_OBJECT = "/td[8]/span/figure";
    private static final String DESTINATION_OBJECT_DEBRIS_MOON = "/td[8]/figure";
    private static final String DESTINATION_CORD = "/td[9]/a";
    private static final String SEND_PROBE = "/td[10]/a";
    private static final String SEND_MSG = "/td[11]/a";

    private static final WebElementPath EVENT = new WebElementPath("//*[@id=\"eventContent\"]/tbody/tr[","]");


    public static boolean visible(WebDriver w) {
        try{
            WebElement e =  w.findElement(By.xpath(EVENT_BOX_CONTENT));
            return !WebElementUtil.attrContainsText(e,"style","display");
        }
        catch (Exception e){
            AppLog.printOnConsole(EventBoxContent.class.getName(),1,"When it checks, the container is visible.");
        }
        return false;
    }

    public static boolean open(WebDriver w) {
        try{
            if(visible(w))
                return true;

            WebElement e =  w.findElement(By.xpath(SHOW_BOX_CONTENT_BUTTON));
            e.click();
            return true;
        }
        catch (Exception e){
            AppLog.printOnConsole(EventBoxContent.class.getName(),1,"When try open event box.");
        }
        return false;
    }

    public static boolean close(WebDriver w) {
        try{
            if(visible(w)){
                WebElement e =  w.findElement(By.xpath(CLOSE_BOX_CONTENT_BUTTON));
                e.click();
                return true;
            }
            AppLog.printOnConsole(EventBoxContent.class.getName(),1,"When try close event box. Event box is not open.");
        }
        catch (Exception e){
            AppLog.printOnConsole(EventBoxContent.class.getName(),1,"When try close event box.");
        }
        return false;
    }

    public static int eventBoxSize(WebDriver w){
        try{
                WebElement e =  w.findElement(By.xpath(EVENT_BOX_CONTENT_TABLE_BODY));
                List<WebElement> table = e.findElements(By.tagName("tr"));
                return table.size();
        }
        catch (Exception e){
            AppLog.printOnConsole(EventBoxContent.class.getName(),1,"When try download size of event box.");
        }
        return -1;
    }

    public static String id(WebDriver w, int position){
        try{
                EVENT.setEdit(position);
                WebElement e =  w.findElement(By.xpath(EVENT.get()));
                return e.getAttribute("id");
        }
        catch (Exception e){
            AppLog.printOnConsole(EventBoxContent.class.getName(),1,"When try download id of event.");
        }
        return null;
    }

    public static int missionType(WebDriver w, int position){
        try{
                EVENT.setEdit(position);
                WebElement e =  w.findElement(By.xpath(EVENT.get()));
                String s = e.getAttribute("data-mission-type");
                return Integer.parseInt(s);
        }
        catch (Exception e){
            AppLog.printOnConsole(EventBoxContent.class.getName(),1,"When try download mission type of event.");
        }
        return -1;
    }

    public static Type type(WebDriver w, int position){
        try{
            EVENT.setEdit(position);
            WebElement e =  w.findElement(By.xpath(EVENT.get().concat(TYPE)));
            String s = e.getAttribute("class");
            return Type.getFromValue(s.split(" ")[0]);
        }
        catch (Exception e){
            AppLog.printOnConsole(EventBoxContent.class.getName(),1,"When try download type of event.");
        }
        return Type.UNDEFINED;
    }

    public static boolean isReturn(WebDriver w, int position){
        try{
            EVENT.setEdit(position);
            WebElement e =  w.findElement(By.xpath(EVENT.get()));
            String s = e.getAttribute("data-return-flight");
            return Boolean.parseBoolean(s);
        }
        catch (Exception e){
            AppLog.printOnConsole(EventBoxContent.class.getName(),1,"When try download is event return.");
        }
        return false;
    }

    public static long arrivalTime(WebDriver w, int position){
        try{
            EVENT.setEdit(position);
            WebElement e =  w.findElement(By.xpath(EVENT.get()));
            String s = e.getAttribute("data-arrival-time");
            return Long.parseLong(s);
        }
        catch (Exception e){
            AppLog.printOnConsole(EventBoxContent.class.getName(),1,"When try download arrival type of event.");
        }
        return -1;
    }

    public static GalaxyObject origin(WebDriver w, int position){
        try{
            EVENT.setEdit(position);
            WebElement e =  w.findElement(By.xpath(EVENT.get().concat(ORIGIN_OBJECT)));
            String s = e.getAttribute("class");
            if(s.contains("planetIcon planet"))
                return GalaxyObject.PLANET;
            else if(s.contains("planetIcon moon"))
                return GalaxyObject.MOON;
            else if(s.contains("planetIcon tf"))
                return GalaxyObject.DEBRIS;
        }
        catch (Exception e){
            AppLog.printOnConsole(EventBoxContent.class.getName(),1,"When try download origin galaxy object.");
        }
        return GalaxyObject.UNDEFINED;
    }

    public static Coordinate originCoordinate(WebDriver w, int position){
        try{
            if(visible(w)){
            EVENT.setEdit(position);
            WebElement e =  w.findElement(By.xpath(EVENT.get().concat(ORIGIN_COORD)));
            return new Coordinate(e.getText());
            }
            AppLog.printOnConsole(EventBoxContent.class.getName(),1,"When try download origin coordinate. Event box is not open.");
        }
        catch (Exception e){
            AppLog.printOnConsole(EventBoxContent.class.getName(),1,"When try download origin coordinate.");
        }
        return null;
    }

    public static String fleetDetails(WebDriver w, int position){
        try{
            EVENT.setEdit(position);
            WebElement e =  w.findElement(By.xpath(EVENT.get().concat(FLEET_DETAILS)));
            return e.getAttribute("title");
        }
        catch (Exception e){
            AppLog.printOnConsole(EventBoxContent.class.getName(),1,"When try download fleet details.");
        }
        return null;
    }

    public static GalaxyObject destination(WebDriver w, int position){
        //Planet & Moon
        if(visible(w)){
            try{
                EVENT.setEdit(position);
                WebElement e =  w.findElement(By.xpath(EVENT.get().concat(DESTINATION_OBJECT)));
                String s = e.getAttribute("class");
                if(s.contains("planetIcon planet"))
                    return GalaxyObject.PLANET;
            }
            catch (Exception e){
                AppLog.printOnConsole(EventBoxContent.class.getName(),1,"When try download destination galaxy object.");
            }
            //Debris
            try{
                EVENT.setEdit(position);
                WebElement e = w.findElement(By.xpath(EVENT.get().replace(DESTINATION_OBJECT,"").concat(DESTINATION_OBJECT_DEBRIS_MOON)));
                String s = e.getAttribute("class");
                if(s.contains("planetIcon tf"))
                    return GalaxyObject.DEBRIS;
                else if(s.contains("planetIcon moon"))
                    return GalaxyObject.MOON;
            }
            catch (Exception e){
                AppLog.printOnConsole(EventBoxContent.class.getName(),1,"When try download destination galaxy object.");
            }
        }
        return GalaxyObject.UNDEFINED;
    }

    public static Coordinate destiantionCoordinate(WebDriver w, int position){
        try{
            if(visible(w)){
            EVENT.setEdit(position);
            WebElement e =  w.findElement(By.xpath(EVENT.get().concat(DESTINATION_CORD)));
            return new Coordinate(e.getText());
            }
            AppLog.printOnConsole(EventBoxContent.class.getName(),1,"When try download destination coordinate. Event box is not open.");
        }
        catch (Exception e){
            AppLog.printOnConsole(EventBoxContent.class.getName(),1,"When try download destination coordinate.");
        }
        return null;
    }
    /*
    Only if mission type is attack and fly to target not returns.
     */
    public static boolean sendProbe (WebDriver w, int position){
        try{
            if(visible(w)){
                EVENT.setEdit(position);
                WebElement e =  w.findElement(By.xpath(EVENT.get().concat(SEND_PROBE)));
                e.click();
                return true;
            }
            AppLog.printOnConsole(EventBoxContent.class.getName(),1,"When try send probe. Event box is not open.");
        }
        catch (Exception e){
            AppLog.printOnConsole(EventBoxContent.class.getName(),1,"When try send probe.");
        }
        return false;
    }

    public static boolean sendMessage (WebDriver w, int position){
        try{
            if(visible(w)){
                EVENT.setEdit(position);
                WebElement e =  w.findElement(By.xpath(EVENT.get().concat(SEND_MSG)));
                e.click();
                return true;
            }
            AppLog.printOnConsole(EventBoxContent.class.getName(),1,"When try send message. Event box is not open.");
        }
        catch (Exception e){
            AppLog.printOnConsole(EventBoxContent.class.getName(),1,"When try send message.");
        }
        return false;
    }

    public static ArrayList<Event> events(WebDriver w){
        ArrayList<Event> list = new ArrayList<>();

        int eventBoxSize = eventBoxSize(w);
        if(eventBoxSize > 0){
            for(int i = 1; i <= eventBoxSize; i++){
                String id = id(w,i);
                Event event = new Event(id);
                event.setMissionType(missionType(w,i));
                event.setType(type(w,i));
                event.setReturn(isReturn(w,i));
                event.setArrivalTime(arrivalTime(w,i));
                event.setOrigin(origin(w,i));
                event.setOriginCoordinate(originCoordinate(w,i));
                event.setDestination(destination(w,i));
                event.setDestinationCoordinate(destiantionCoordinate(w,i));
                event.setFleetDetails(fleetDetails(w,i));
                list.add(event);
            }
        }

        return list;
    }

    public static ArrayList<Event> events(WebDriver w, Mission mission){
        ArrayList<Event> list = new ArrayList<>();

        int eventBoxSize = eventBoxSize(w);
        if(eventBoxSize > 0){
            for(int i = 1; i <= eventBoxSize; i++){
                int missionType = missionType(w,i);
                if(missionType == mission.getDATA_MISSION_TYPE()){
                    String id = id(w,i);
                    Event event = new Event(id);
                    event.setMissionType(missionType);
                    event.setType(type(w,i));
                    event.setReturn(isReturn(w,i));
                    event.setArrivalTime(arrivalTime(w,i));
                    event.setOrigin(origin(w,i));
                    event.setOriginCoordinate(originCoordinate(w,i));
                    event.setDestination(destination(w,i));
                    event.setDestinationCoordinate(destiantionCoordinate(w,i));
                    event.setFleetDetails(fleetDetails(w,i));
                    list.add(event);
                }
            }
        }

        return list;
    }

    public static Event eventFromId(WebDriver w, String idEvent){
        int eventBoxSize = eventBoxSize(w);
        if(eventBoxSize > 0){
            for(int i = 1; i <= eventBoxSize; i++){
                String id = id(w,i);
                if(id != null && id.equals(idEvent)) {
                    Event event = new Event(id);
                    event.setMissionType(missionType(w,i));
                    event.setType(type(w,i));
                    event.setReturn(isReturn(w,i));
                    event.setArrivalTime(arrivalTime(w,i));
                    event.setOrigin(origin(w,i));
                    event.setOriginCoordinate(originCoordinate(w,i));
                    event.setDestination(destination(w,i));
                    event.setDestinationCoordinate(destiantionCoordinate(w,i));
                    event.setFleetDetails(fleetDetails(w,i));
                    return event;
                }
            }
        }
        return null;
    }
}
