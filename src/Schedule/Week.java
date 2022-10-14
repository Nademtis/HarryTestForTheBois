package Schedule;

import java.util.ArrayList;

public class Week {

    private ArrayList<Day> week = new ArrayList<>();

    public Week() {
        createWeek();
    }

    private void createWeek() {
        for (int i = 0; i < 5; i++) {
            week.add(new Day());
        }
    }
    public Day getDay (int dayChoice){
        return week.get(dayChoice);
    }

    @Override
    public String toString() {
        return "" + week;
    }
}
