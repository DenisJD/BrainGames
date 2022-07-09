package hexlet.code;


import java.util.Random;
import java.util.Scanner;

public class Engine {

    private final Scanner scanner;
    private final Random random;

    private String userName = "";

    public Engine(Scanner scanner, Random random) {
        this.scanner = scanner;
        this.random = random;
    }

    public void greetUser() {
        String welcomeMessage = "\nWelcome to the Brain Games!";
        System.out.println(welcomeMessage);
        String message = "May I have your name? ";
        System.out.print(message);

        userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
    }

    public String askUserAnswer() {
        System.out.print(getYourAnswerMessage());
        return scanner.nextLine();
    }

    public String getUserName() {
        return userName;
    }

    public int getRandomNumber() {
        int maxRandomNumber = 100;
        return random.nextInt(maxRandomNumber);
    }

    private String getYourAnswerMessage() {
        return "Your answer: ";
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
