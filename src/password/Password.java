package password;

import java.util.Scanner;

public class Password {
    Scanner sc = new Scanner(System.in);
    private String correctPW = "hairyharry";

    //Method for writing and checking password
    public void checkPassword() {
        boolean pwIsCorrect = false;
        String pw;
        System.out.println("Welcome!");
        do {
            try {
                System.out.print("Insert password: ");
                pw = sc.nextLine();
                    if (pw.equals(correctPW)){
                        //System.out.println("Correct, Welcome back");
                        pwIsCorrect=true;
                    }
            } catch (Exception e) {
                checkPassword();
            }
        } while (pwIsCorrect != true);
    }
}
