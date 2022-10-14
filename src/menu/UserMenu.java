package menu;

import java.util.ArrayList;
import java.util.Scanner;

public class UserMenu {
    Scanner sc = new Scanner(System.in);

    Appointments a = new Appointments();

    public void barberMenu() {
        ArrayList<String> barberMenulist = new ArrayList<>();
        barberMenulist.add("Create Appointment");
        barberMenulist.add("Edit Appointment");
        barberMenulist.add("Delete Appointment");
        barberMenulist.add("View Schedule");
        barberMenulist.add("Register Vacation");
        barberMenulist.add("Register Payment");
        barberMenulist.add("Change Account");
        Menu barberMenu = new Menu("What do you want to do", "Type the number", barberMenulist);

        Appointments appointments = new Appointments();
        Payment p = new Payment();

        do {
            barberMenu.printMenu();
            switch (barberMenu.readChoice()) {
                case 1 -> appointments.createAppointment();
                case 2 -> appointments.editAppointment();
                case 3 -> appointments.deleteAppointment();
                case 4 -> appointments.viewSchedule();
                case 5 -> appointments.vacationPlanning();
                case 6 -> p.updatePayment();
                case 7 -> accountantMenu();
                default -> System.out.println("Your choice is out of bounds...\n");
            }
        } while (!isDone());
    }

    public void accountantMenu() {
        ArrayList<String> accountantOptions = new ArrayList<>();
        accountantOptions.add("View appointments on given week");
        accountantOptions.add("View all appointments");

        Menu accountantMenu = new Menu("What do you want to do?", "Type number", accountantOptions);


        do {
            accountantMenu.printMenu();
            switch (accountantMenu.readChoice()) {
                case 1:
                    System.out.println("Type a week number: ");
                    int userInput = sc.nextInt();
                    a.viewWeekAppointments(userInput);
                    break;
                case 2:
                    a.viewYearAppointments();
                    break;
                default:
                    System.out.println("Wrong input, try again");
                    break;
            }
        } while (!isDone());
    }

    public boolean isDone() {
        Scanner sc = new Scanner(System.in);
        boolean isDone = false;
        System.out.println("Are you done with the program? no(1) yes(2) ");
        int x = sc.nextInt();

        switch (x) {
            case 1:
                break;
            case 2:
                System.out.println("Okay. bye!");
                isDone = true;
                break;
            default:
                System.out.println("Wrong input. go again");
                isDone();
                break;
        }
        return isDone;
    }
}
