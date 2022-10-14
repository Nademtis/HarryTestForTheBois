package menu;

import java.util.ArrayList;

public class MenuRun {
    public void menuRun() {
        ArrayList<String> ChooseUser = new ArrayList<>();
        ChooseUser.add("Barber");
        ChooseUser.add("Accountant");
        Menu userMenu = new Menu("Welcome back, Pick your account", "Type the number", ChooseUser);

        userMenu.printMenu();

        boolean valid = false;
        do {
            switch (userMenu.readChoice()) {
                case 1:
                    valid = true;
                    new UserMenu().barberMenu();
                    break;
                case 2:
                    valid = true;
                    new UserMenu().accountantMenu();
                    break;
                default:
                    System.out.println("Your choice is out of bounds...\n");
                    break;
            }
        } while (valid != true);
    }
}
