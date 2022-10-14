package menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private String menuHeader;
    private String leadText;
    private ArrayList<String> menuItems;

    public Menu(String menuHeader, String leadText, ArrayList<String> menuItems) {
        this.menuHeader = menuHeader;
        this.leadText = leadText;
        this.menuItems = menuItems;
    }

    public void printMenu() {
        System.out.println(menuHeader);
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.print(i + 1 + "." + menuItems.get(i) + "\n");
        }
        System.out.println("\n" + leadText);
    }

    public int readChoice() {
        Scanner sc = new Scanner(System.in);
        try {
            int a = sc.nextInt();
            return a;
        } catch (Exception e) {
            System.out.println(leadText);
            readChoice();
        }
        return 0;
    }
}
