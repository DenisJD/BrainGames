package hexlet.code;

import java.util.Scanner;

public class Cli {
    private static String userName = "";

    public static void greetings() {
        Scanner scanner = new Scanner(System.in);
        String welcomeMessage = "\nWelcome to the Brain Games!";
        System.out.println((welcomeMessage));
        String message = "May I have your name? ";
        System.out.print(message);
        userName = scanner.nextLine();
        System.out.println(("Hello, " + userName + "!"));
    }

    public static String getUserName() {
        return userName;
    }
}
