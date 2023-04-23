package simplestartup;

import java.util.ArrayList;

public class Startup {
    private String name;
    private ArrayList<String> locationCells = new ArrayList<>();

    public void setName(String name1){
        name = name1;
    }
    public String getName(){
        return name;
    }
    public void setLocationCells(ArrayList<String> locs){
        locationCells = locs;
    }
    public String checkYourself(String userInput){
        String result = "miss";
        int index = locationCells.indexOf(userInput);

        if(index >= 0){
            locationCells.remove(index);
            if(locationCells.isEmpty()){
                result = "kill";
            }else {
                result = "hit";
            }
        }
        return result;
    }

}
