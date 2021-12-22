package ogame.eventbox;

import ogame.planets.Resources;
import ogame.utils.StringFactory;
import java.util.ArrayList;

public class FleetDetails {
    private final String value;
    private StringBuilder stringBuilder;

    public FleetDetails(String value) {
        String tmp = value.replace(" ","");
        this.value = tmp;
        this.stringBuilder = new StringBuilder(tmp);
    }

    /**
     * Gets position of first exist tag <tr>
     * @param startIndex the position from which to start.
     * @return position of tag
     */
    private int getStartTrTagIndex(int startIndex){
        return stringBuilder.indexOf("<tr>",startIndex);
    }
    /**
     * Gets position of first end tag </tr>
     * @param startIndex the position from which to start.
     * @return position of end tag
     */
    private int getEndTrTagIndex(int startIndex){
        return stringBuilder.indexOf("</tr>",startIndex)+5;
    }
    /**
     * The text between index
     * @param startIndex the position from which to start.
     * @param endIndex the end position.
     * @return text
     */
    private String tagContent(int startIndex, int endIndex){
        return stringBuilder.substring(startIndex,endIndex);
    }

    /**
     * @return Returns list of table row from fleet details text.
     */
    public ArrayList<String> trTagList(){
        ArrayList<String> list = new ArrayList<>();

        int startTrTagIndex = getStartTrTagIndex(0);
        int endTrTagIndex = getEndTrTagIndex(0);

        while(startTrTagIndex != -1){
            list.add(tagContent(startTrTagIndex,endTrTagIndex));
            startTrTagIndex = getStartTrTagIndex(endTrTagIndex);
            endTrTagIndex = getEndTrTagIndex(endTrTagIndex);
        }
        return list;
    }

    /**
     * @param trContent Table row content
     * @return name value from table row
     */
    public String name(String trContent){
        return trContent.split(":")[0].split(">")[2];
    }

    /**
     * @param trContent Table row content
     * @return  value from table row
     */
    public String value(String trContent){
        String [] st1 = trContent.split("class=");
        String s1 = st1[1].replace("</td>","").replace("</tr>","");
        String [] st2 = s1.split(">");
        return st2[1];
    }

    /**
     * Get ships and ammount of ship
     * @return Data of ships
     */
    public ArrayList<FleetDetailsShip> ships (){
        ArrayList<String> list = trTagList();
        ArrayList<FleetDetailsShip> ship = new ArrayList<>();
        for(String s :list){
            if(isSpace(s))
                break;
            if(isNextResource(s))
                continue;
            String name = name(s);
            String value = value(s);
            ship.add(new FleetDetailsShip(name,value));
        }
        return ship;
    }

    /**
     * Get value of resoruces.
     * @return ***
     */
    public ArrayList<FleetDetailsResources> resources (){
        ArrayList<String> list = trTagList();
        ArrayList<FleetDetailsResources> resources = new ArrayList<>();
        boolean addFlag = false;
        for(String s :list){
            if(isNextResource(s))
                continue;
            if(isSpace(s)){
                addFlag = true;
                continue;
            }

            if(addFlag){
                String name = name(s);
                String value = value(s);
                resources.add(new FleetDetailsResources(name,value));
            }
        }
        return resources;
    }
    /**
     * Get value of resoruces.
     * @return ***
     */
    public Resources getResources (){
        ArrayList<String> list = trTagList();
        boolean addFlag = false;
        int count = 1;
        int metal = 0, crystal = 0, deuterium = 0;
        for(String s :list){
            if(isNextResource(s))
                continue;
            if(isSpace(s)){
                addFlag = true;
                continue;
            }
            if(addFlag){
                String value = value(s);
                value = StringFactory.deleteChars('\n',value);
                switch (count){
                    case 1:
                        metal = Integer.parseInt(value);
                        break;
                    case 2:
                        crystal = Integer.parseInt(value);
                        break;
                    case 3:
                        deuterium = Integer.parseInt(value);
                        break;
                }
                count++;
            }
        }
        return new Resources(metal,crystal,deuterium,0);
    }

    /**
     * Checks tr content is contain data of resource or ship
     * @param trContent Content of tr tag.
     * @return false - if contains data of resource or ship, else - true
     */
    public boolean isNextResource(String trContent){
        return trContent.contains("</th>");
    }
    /**
     * Checks tr content is space tr.
     * @param trContent Content of tr tag.
     * @return true - if is space tr
     */
    public boolean isSpace(String trContent){
        return trContent.contains("&nbsp");
    }
}
