package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    public static final int MIN_RANDOM_NUMBER = 2;
    public static final int MAX_RANDOM_NUMBER = 100;

    public static void startGame() {
        String rulesMessage = "Find the greatest common divisor of given numbers.";
        while (Engine.getFlag()) {
            int a = Utils.getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            int b = Utils.getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            String question = a + " " + b;
            String correctAnswer = getCorrectAnswer(a, b);
            Engine.gameProcess(rulesMessage, question, correctAnswer);
        }
    }

    public static int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }

    public static String getCorrectAnswer(int a, int b) {
        return String.valueOf(getGCD(a, b));
    }
}
