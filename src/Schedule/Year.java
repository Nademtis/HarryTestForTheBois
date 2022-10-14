package Schedule;

import java.util.ArrayList;

public class Year {

    private static ArrayList<Week> year = new ArrayList<>();

    private void createYear(){
        for (int i = 0; i < 52; i++) {
            year.add(new Week());
        }
    }
    public Week getWeek (int weekChoice){
        Week week = year.get(weekChoice);

        return week;
    }
    public Year (){
        createYear();
    }
}
