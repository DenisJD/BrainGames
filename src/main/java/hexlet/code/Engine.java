package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int MAX_ROUNDS = 3;
    public static final int QUESTION = 0;
    public static final int ANSWER = 1;

    public static void runGame(String rules, String[][] questionsAndAnswers) {
        Scanner scanner = new Scanner(System.in);
        String welcomeMessage = "\nWelcome to the Brain Games!";
        String message = "May I have your name? ";
        System.out.println(welcomeMessage);
        System.out.print(message);
        String userName = scanner.nextLine();
        System.out.println(("Hello, " + userName + "!"));
        System.out.println(rules);
        for (int i = 0; i < MAX_ROUNDS; i++) {
            System.out.println("Question: " + questionsAndAnswers[i][QUESTION]);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();
            if (userAnswer.equals(questionsAndAnswers[i][ANSWER])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. "
                        + "Correct answer was '" + questionsAndAnswers[i][ANSWER] + "'");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
        scanner.close();
    }
}

