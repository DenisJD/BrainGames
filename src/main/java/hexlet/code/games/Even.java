package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Even {

    private final Engine engine;
    private final Scanner scanner;
    private int countCorrect = 0;
    private final int MAX_CORRECT = 3;
    private boolean hasNoWrongAnswer = true;

    public Even(Engine engine, Scanner scanner) {
        this.engine = engine;
        this.scanner = scanner;
    }

    public void startGame() {
        engine.greetUser();
        System.out.println(getGameRulesMessage());
        countCorrect = 0;

        while (shouldContinueGame()) {
            int randomNumber = engine.getRandomNumber();
            String correctAnswer = getCorrectAnswer(randomNumber);
            System.out.println(getQuestionMessage(randomNumber));
            System.out.print(getYourAnswerMessage());
            String userAnswer = getUserAnswer();

            if (correctAnswer.equals(userAnswer)) {
                processCorrectAnswer();
            } else {
                processWrongAnswer(correctAnswer, userAnswer);
            }
        }
    }

    private void processWrongAnswer(String correctAnswer, String userAnswer) {
        System.out.println(getWrongAnswerMessage(correctAnswer, userAnswer));
        hasNoWrongAnswer = false;
    }

    private boolean shouldContinueGame() {
        return countCorrect < MAX_CORRECT && hasNoWrongAnswer;
    }

    private String getQuestionMessage(int number) {
        return "Question: " + number;
    }

    private String getYourAnswerMessage() {
        return "Your answer: ";
    }

    private String getWrongAnswerMessage(String correctAnswer, String userAnswer) {
        return "'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'" + "\n" +
                "Let's try again, " + engine.getUserName() + "!";
    }

    private void processCorrectAnswer() {
        countCorrect++;
        System.out.println("Correct!");
        if (countCorrect == MAX_CORRECT) {
            System.out.println("Congratulations, " + engine.getUserName() + "!");
        }
    }

    private String getCorrectAnswer(int number) {
        return (number % 2 == 0) ? "yes" : "no";
    }

    private String getGameRulesMessage() {
        return "Answer 'yes' if number even otherwise answer 'no'.";
    }

    private String getUserAnswer() {
        return scanner.nextLine();
    }
}
