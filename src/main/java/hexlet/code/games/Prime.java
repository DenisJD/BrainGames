package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    private static final String[][] QUESTIONS_AND_ANSWERS = new String[Engine.MAX_ROUNDS][2];
    public static final String RULES_MESSAGE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    public static final int MIN_RANDOM_NUMBER = 2;
    public static final int MAX_RANDOM_NUMBER = 100;

    public static void startGame() {
        for (int i = 0; i < Engine.MAX_ROUNDS; i++) {
            int number = Utils.getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            QUESTIONS_AND_ANSWERS[i][Engine.QUESTION] = String.valueOf(number);
            QUESTIONS_AND_ANSWERS[i][Engine.ANSWER] = getCorrectAnswer(number);
        }
        Engine.runGame(RULES_MESSAGE, QUESTIONS_AND_ANSWERS);
    }

    public static boolean isNumberPrime(int a) {
        for (int i = 2; i < a; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String getCorrectAnswer(int a) {
        if (isNumberPrime(a)) {
            return "yes";
        }
        return "no";
    }
}
