package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Calc {

    private final Engine engine;
    private final Scanner scanner;

    private final int MAX_CORRECT = 3;
    private int countCorrect = 0;
    private boolean hasNoWrongAnswer = true;

    public Calc(Engine engine, Scanner scanner) {
        this.engine = engine;
        this.scanner = scanner;
    }

    public void startGame() {
        engine.greetUser();
        System.out.println(getGameRulesMessage());
        countCorrect = 0;
        while (shouldContinueGame()) {
            int a = engine.getRandomNumber();
            int b = engine.getRandomNumber();
            char mathOperator = getMathOperator();

            System.out.println(getQuestionMessage(a, b, mathOperator));
            System.out.print(getYourAnswerMessage());

            int correctAnswer = getCorrectAnswer(a, b, mathOperator);
            int userAnswer = scanner.nextInt();
            if (userAnswer == correctAnswer) {
                processCorrectAnswer();
            } else {
                processWrongAnswer(userAnswer, correctAnswer);
            }
        }
    }

    private void processWrongAnswer(int userAnswer, int correctAnswer) {
        System.out.println(getWrongAnswerMessage(correctAnswer, userAnswer));
        hasNoWrongAnswer = false;
    }

    private void processCorrectAnswer() {
        countCorrect++;
        System.out.println("Correct!");
        if (countCorrect == MAX_CORRECT) {
            System.out.println("Congratulations, " + engine.getUserName() + "!");
        }
    }

    private String getWrongAnswerMessage(int correctAnswer, int userAnswer) {
        return "'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'" + "\n" +
                "Let's try again, " + engine.getUserName() + "!";
    }

    private boolean shouldContinueGame() {
        return countCorrect < MAX_CORRECT && hasNoWrongAnswer;
    }

    private int getCorrectAnswer(int a, int b, char mathOperator) {
        int correctAnswer = 0;
        if (mathOperator == '+') {
            correctAnswer = a + b;
        } else if (mathOperator == '-') {
            correctAnswer = a - b;
        } else if (mathOperator == '*') {
            correctAnswer = a * b;
        }
        return correctAnswer;
    }

    private char getMathOperator() {
        return "+-*".charAt(new Random().nextInt(3));
    }

    private String getGameRulesMessage() {
        return "What is the result of the expression?";
    }

    private String getQuestionMessage(int a, int b, char mathOperator) {
        return "Question: " + a + " " + mathOperator + " " + b;
    }

    private String getYourAnswerMessage() {
        return "Your answer: ";
    }
}
