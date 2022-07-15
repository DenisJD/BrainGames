package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    private static final String[][] QUESTIONS_AND_ANSWERS = new String[Engine.MAX_ROUNDS][2];
    public static final String RULES_MESSAGE = "Answer 'yes' if number even otherwise answer 'no'.";
    public static final int MIN_RANDOM_NUMBER = 0;
    public static final int MAX_RANDOM_NUMBER = 101;

    public static void startGame() {
        for (int i = 0; i < Engine.MAX_ROUNDS; i++) {
            int number = Utils.getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            QUESTIONS_AND_ANSWERS[i][Engine.QUESTION] = String.valueOf(number);
            QUESTIONS_AND_ANSWERS[i][Engine.ANSWER] = number % 2 == 0 ? "yes" : "no";
        }
        Engine.runGame(RULES_MESSAGE, QUESTIONS_AND_ANSWERS);
    }
}

