package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    public static final String RULES_MESSAGE = "Find the greatest common divisor of given numbers.";
    public static final int MIN_RANDOM_NUMBER = 2;
    public static final int MAX_RANDOM_NUMBER = 100;

    public static void startGame() {
        String[][] questionsAndAnswers = new String[Engine.MAX_ROUNDS][2];
        for (int i = 0; i < Engine.MAX_ROUNDS; i++) {
            int firstNumber = Utils.getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            int secondNumber = Utils.getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            questionsAndAnswers[i][Engine.QUESTION] = firstNumber + " " + secondNumber;
            questionsAndAnswers[i][Engine.ANSWER] = String.valueOf(getGCD(firstNumber, secondNumber));
        }
        Engine.runGame(RULES_MESSAGE, questionsAndAnswers);
    }

    public static int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }
}

