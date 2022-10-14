package menu;

import java.util.Scanner;

public class Payment {
    Scanner sc = new Scanner(System.in);

    Appointments a = new Appointments();

    public double registerPayment() {
        System.out.println("Enter amount payed by customer: ");
        double paymentAmount = sc.nextInt();
        return paymentAmount;
    }
    public void updatePayment() {
        int week = a.weekChoice();
        int day = a.dayChoice();
        a.viewDayAppointments(week, day);
        String timeslot = a.readTimeslot();
        String name = timeslot + "-" + a.readName() + " Amount payed: " + registerPayment() + " "; //TODO: Don't ask for name
        a.year.getWeek(week).getDay(day).addAppointment(a.timeslotToIndex(timeslot), name);
    }
}
