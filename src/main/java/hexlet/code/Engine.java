package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static int roundCounter = 0;
    private static boolean flag = true;
    public static final int MAX_ROUNDS = 3;

    public static void gameProcess(String rules, String question, String correctAnswer) {
        Scanner scanner = new Scanner(System.in);
        if (roundCounter == 0) {
            Cli.greetings();
            System.out.println(rules);
        }
        System.out.println("Question: " + question);
        System.out.print("Your answer: ");
        String userAnswer = scanner.nextLine();
        if (userAnswer.equals(correctAnswer)) {
            System.out.println("Correct!");
            roundCounter++;
            if (roundCounter == MAX_ROUNDS) {
                System.out.println("Congratulations, " + Cli.getUserName() + "!");
                flag = false;
                scanner.close();
            }
        } else {
            System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'");
            System.out.println("Let's try again, " + Cli.getUserName() + "!");
            flag = false;
            scanner.close();
        }
    }

    public static boolean getFlag() {
        return flag;
    }
}
