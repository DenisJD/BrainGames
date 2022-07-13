package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    public static final int COUNT_MATH_OPERATORS = 3;

    public static void startGame() {
        String rulesMessage = "What is the result of the expression?";
        while (Engine.getFlag()) {
            int a = Utils.getRandomNumber();
            int b = Utils.getRandomNumber();
            char mathOperator = getMathOperator();
            String question = a + " " + mathOperator + " " + b;
            String correctAnswer = getCorrectAnswer(a, b, mathOperator);
            Engine.gameProcess(rulesMessage, question, correctAnswer);
        }
    }

    public static char getMathOperator() {
        return "+-*".charAt(Utils.getRandomNumber(0, COUNT_MATH_OPERATORS));
    }

    public static String getCorrectAnswer(int a, int b, char mathOperator) {
        int correctAnswer = 0;
        if (mathOperator == '+') {
            correctAnswer = a + b;
        } else if (mathOperator == '-') {
            correctAnswer = a - b;
        } else if (mathOperator == '*') {
            correctAnswer = a * b;
        }
        return String.valueOf(correctAnswer);
    }
}
