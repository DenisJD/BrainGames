package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    public static final int MIN_RANDOM_NUMBER = 2;
    public static final int MAX_RANDOM_NUMBER = 100;

    public static void startGame() {
        String rulesMessage = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        while (Engine.getFlag()) {
            int a = Utils.getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            String question = String.valueOf(a);
            String correctAnswer = getCorrectAnswer(a);
            Engine.gameProcess(rulesMessage, question, correctAnswer);
        }
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
