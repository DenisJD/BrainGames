package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void greetings() {
        Scanner scanner = new Scanner(System.in);
        String welcomeMessage = "\nWelcome to the Brain Games!";
        String message = "May I have your name? ";
        System.out.println(welcomeMessage);
        System.out.print(message);
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
        scanner.close();
    }
}
