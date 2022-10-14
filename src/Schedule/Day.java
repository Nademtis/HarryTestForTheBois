package Schedule;

import menu.Appointments;
import java.util.ArrayList;
import java.util.Scanner;

public class Day {

    private ArrayList<String> appointmentOnThisDay = new ArrayList<>();


    public Day(){
        generateTimeslots();
    }

    public ArrayList<String> getAppointmentOnThisDay(){
        return appointmentOnThisDay;
    }

    public void generateTimeslots(){
        appointmentOnThisDay.add("10:00-empty");
        appointmentOnThisDay.add("10:30-empty");
        appointmentOnThisDay.add("11:00-empty");
        appointmentOnThisDay.add("11:30-empty");
        appointmentOnThisDay.add("12:00-empty");
        appointmentOnThisDay.add("12:30-empty");
        appointmentOnThisDay.add("13:00-empty");
        appointmentOnThisDay.add("13:30-empty");
        appointmentOnThisDay.add("14:00-empty");
        appointmentOnThisDay.add("14:30-empty");
        appointmentOnThisDay.add("15:00-empty");
        appointmentOnThisDay.add("15:30-empty");
        appointmentOnThisDay.add("16:00-empty");
        appointmentOnThisDay.add("16:30-empty");
        appointmentOnThisDay.add("17:00-empty");
        appointmentOnThisDay.add("17:30-empty");
    }

    public void addAppointment(int timeslot, String name){
        appointmentOnThisDay.set(timeslot,name);
    }
    public void insertVacationDay(){
        appointmentOnThisDay.clear();
        appointmentOnThisDay.add("harry is off");
    }
    @Override
    public String toString() {
        return   appointmentOnThisDay +
                "\n";
    }
}

