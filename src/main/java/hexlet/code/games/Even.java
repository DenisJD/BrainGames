package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    public static final String RULES_MESSAGE = "Answer 'yes' if number even otherwise answer 'no'.";
    public static final int MIN_RANDOM_NUMBER = 0;
    public static final int MAX_RANDOM_NUMBER = 101;

    public static void startGame() {
        String[][] questionsAndAnswers = new String[Engine.MAX_ROUNDS][2];
        for (int i = 0; i < Engine.MAX_ROUNDS; i++) {
            int number = Utils.getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            questionsAndAnswers[i][Engine.QUESTION] = String.valueOf(number);
            questionsAndAnswers[i][Engine.ANSWER] = getCorrectAnswer(number);
        }
        Engine.runGame(RULES_MESSAGE, questionsAndAnswers);
    }

    public static boolean isNumberEven(int number) {
        return number % 2 == 0;
    }

    public static String getCorrectAnswer(int number) {
        return isNumberEven(number) ? "yes" : "no";
    }
}
