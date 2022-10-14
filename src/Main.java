import menu.MenuRun;
import password.Password;

public class Main {

    void run() {
        new Password().checkPassword();
        new MenuRun().menuRun();
        System.out.println("test");
        System.out.println("test");
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
