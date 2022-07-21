package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    public static final String RULES_MESSAGE = "What is the result of the expression?";
    private static final String[] MATH_OPERATORS = {"+", "-", "*"};
    public static final int MIN_RANDOM_NUMBER = 0;
    public static final int MAX_RANDOM_NUMBER = 101;

    public static void startGame() {
        String[][] questionsAndAnswers = new String[Engine.MAX_ROUNDS][2];
        for (int i = 0; i < Engine.MAX_ROUNDS; i++) {
            int firstNum = Utils.getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            int secondNum = Utils.getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            String mathOperator = getMathOperator(MATH_OPERATORS);
            questionsAndAnswers[i][Engine.QUESTION] = firstNum + " " + mathOperator + " " + secondNum;
            questionsAndAnswers[i][Engine.ANSWER] = String.valueOf(calculate(mathOperator, firstNum, secondNum));
        }
        Engine.runGame(RULES_MESSAGE, questionsAndAnswers);
    }

    public static String getMathOperator(String[] mathOperators) {
        int randomIndexOfOperator = Utils.getRandomNumber(MIN_RANDOM_NUMBER, mathOperators.length);
        return mathOperators[randomIndexOfOperator];
    }

    public static int calculate(String mathOperator, int firstNumber, int secondNumber) {
        switch (mathOperator) {
            case "+" -> {
                return firstNumber + secondNumber;
            }
            case "-" -> {
                return firstNumber - secondNumber;
            }
            case "*" -> {
                return firstNumber * secondNumber;
            }
            default -> throw new RuntimeException("There is no logic for the '" + mathOperator + "' operator");
        }
    }
}
