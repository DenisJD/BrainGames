package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    private static final String[][] QUESTIONS_AND_ANSWERS = new String[Engine.MAX_ROUNDS][2];
    private static final String[] MATH_OPERATORS = {"+", "-", "*"};
    public static final String RULES_MESSAGE = "What is the result of the expression?";
    public static final int MIN_RANDOM_NUMBER = 0;
    public static final int MAX_RANDOM_NUMBER = 101;

    public static void startGame() {
        for (int i = 0; i < Engine.MAX_ROUNDS; i++) {
            int firstNumber = Utils.getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            int secondNumber = Utils.getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            String mathOperator = getMathOperator(MATH_OPERATORS);
            QUESTIONS_AND_ANSWERS[i][Engine.QUESTION] = firstNumber + " " + mathOperator + " " + secondNumber;
            QUESTIONS_AND_ANSWERS[i][Engine.ANSWER] = calculate(mathOperator, firstNumber, secondNumber);
        }
        Engine.runGame(RULES_MESSAGE, QUESTIONS_AND_ANSWERS);
    }

    public static String getMathOperator(String[] mathOperators) {
        int randomIndexOfOperator = Utils.getRandomNumber(MIN_RANDOM_NUMBER, mathOperators.length);
        return mathOperators[randomIndexOfOperator];
    }

    public static String calculate(String mathOperator, int firstNumber, int secondNumber) {
        switch (mathOperator) {
            case "+" -> {
                return String.valueOf(firstNumber + secondNumber);
            }
            case "-" -> {
                return String.valueOf(firstNumber - secondNumber);
            }
            case "*" -> {
                return String.valueOf(firstNumber * secondNumber);
            }
            default -> {
                return "There is no logic for the '" + mathOperator + "' operator";
            }
        }
    }
}
