package menu;

import Schedule.Year;
import java.util.Scanner;

public class Appointments {
    Scanner sc = new Scanner(System.in);
    Year year = new Year();

    public void createAppointment() {
        int week = weekChoice();
        int day = dayChoice();
        viewSingleDaySchedule(week, day);
        String timeslot = readTimeslot();
        String name = timeslot + "-" + readName();
        year.getWeek(week).getDay(day).addAppointment(timeslotToIndex(timeslot), name);
    }

    public void editAppointment() {
        int week = weekChoice();
        int day = dayChoice();
        viewDayAppointments(week, day);
        String timeslot = readTimeslot();
        String name = timeslot + "-" + readName();
        year.getWeek(week).getDay(day).addAppointment(timeslotToIndex(timeslot), name);
    }

    public void deleteAppointment() {
        int week = weekChoice();
        int day = dayChoice();
        viewSingleDaySchedule(week, day);
        String timeslot = readTimeslot();
        String defaultValue = timeslot + "-empty";
        year.getWeek(week).getDay(day).addAppointment(timeslotToIndex(timeslot), defaultValue);
    }

    public void vacationPlanning() {
        int week = weekChoice();
        int day = dayChoice();
        year.getWeek(week).getDay(day).insertVacationDay();
    }

    public void viewSchedule() { //TODO Make it look sliiick
        System.out.println(year.getWeek(weekChoice()));
    }

    public void viewSingleDaySchedule(int weekchoice, int daychoice) {
        System.out.println(year.getWeek(weekchoice).getDay(daychoice));
    }

    public void viewDayAppointments(int weekchoice, int daychoice) {
        for (int i = 0; i < 15; i++) {
            if (!year.getWeek(weekchoice).getDay(daychoice).getAppointmentOnThisDay().get(i).contains("empty")) {
                System.out.print(year.getWeek(weekchoice).getDay(daychoice).getAppointmentOnThisDay().get(i));
            }
        }
    }

    public void viewWeekAppointments(int weekchoice) {
        System.out.print("\nAppointments in week number " + weekchoice + " ");
        for (int i = 0; i < 5; i++) {
            System.out.print(intToDay(i) + ": ");
            viewDayAppointments(weekchoice, i);
        }
    }

    public void viewYearAppointments() {
        for (int i = 1; i < 52; i++) {
            viewWeekAppointments(i);
        }
    }

    public String readTimeslot() {
        System.out.println("Please type a timeslot (press 9 to return to main menu): ");
        String newTime = sc.nextLine();
        if (newTime.equals("9")) {
            new UserMenu().barberMenu();
        }
        return newTime;
    }

    public int timeslotToIndex(String newTime) {
        int timeslotIndex = 0;
        boolean again = true;
        while (again) {
            again = false;
            switch (newTime) {
                case "10:00", "1000" -> timeslotIndex = 0;
                case "10:30", "1030" -> timeslotIndex = 1;
                case "11:00", "1100" -> timeslotIndex = 2;
                case "11:30", "1130" -> timeslotIndex = 3;
                case "12:00", "1200" -> timeslotIndex = 4;
                case "12:30", "1230" -> timeslotIndex = 5;
                case "13:00", "1300" -> timeslotIndex = 6;
                case "13:30", "1330" -> timeslotIndex = 7;
                case "14:00", "1400" -> timeslotIndex = 8;
                case "14:30", "1430" -> timeslotIndex = 9;
                case "15:00", "1500" -> timeslotIndex = 10;
                case "15:30", "1530" -> timeslotIndex = 11;
                case "16:00", "1600" -> timeslotIndex = 12;
                case "16:30", "1630" -> timeslotIndex = 13;
                case "17:00", "1700" -> timeslotIndex = 14;
                case "17:30", "1730" -> timeslotIndex = 15;
                default -> {
                    System.out.println("Wrong input with the timeslot, try again");
                    newTime = sc.nextLine();
                    again = true;
                }
            }
        }
        return timeslotIndex;
    }

    public String readName() {
        System.out.println("Enter name of customer: ");
        String name = sc.nextLine();
        return name;
    }

    public int weekChoice() {
        System.out.print("write the week number: ");
        int weekChoice = sc.nextInt();
        sc.nextLine();
        return weekChoice;
    }

    public int dayChoice() {
        int daychoice = 0;

        System.out.println("Write the day of the week (eg. \"Monday\")");
        String userInput = sc.nextLine().toLowerCase();
        switch (userInput) {
            case "monday":
                daychoice = 0;
                break;
            case "tuesday":
                daychoice = 1;
                break;
            case "wednesday":
                daychoice = 2;
                break;
            case "thursday":
                daychoice = 3;
                break;
            case "friday":
                daychoice = 4;
                break;
            default:
                System.out.println("Something ain't working in dayChoice()");
        }
        return daychoice;
    }

    public String intToDay(int dayNum) {
        return switch (dayNum) {
            case 0 -> "Monday";
            case 1 -> "Tuesday";
            case 2 -> "Wednesday";
            case 3 -> "Thursday";
            case 4 -> "Friday";
            default -> "Bug in intToDay - please inform the developers";
        };
    }
}
